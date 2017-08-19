package com.dream.william.photophase;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.photophase.model.Disposition;
import com.dream.william.photophase.model.Dispositions;
import com.dream.william.photophase.utils.DispositionUtil;
import com.dream.william.photophase.widgets.DispositionView;
import com.dream.william.photophase.widgets.ResizeFrame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PhaseActivity extends BaseActivity implements DispositionView.OnFrameSelectedListener, ViewPager.OnPageChangeListener {

    public static final String DEFAULT_PORTRAIT_DISPOSITION = "0x0:2x1|0x2:1x3|0x4:3x6|2x2:3x3|3x0:3x0|3x1:3x1";
    private static final String PREFERENCES_FILE = "com.hylaa";

    private static final int DEFAULT_COLS = 4;
    private static final int DEFAULT_ROWS = 7;

    private TextView mAdvise;
    private ResizeFrame mResizeFrame;
    private ViewPager mPager;
    private DispositionAdapter mAdapter;
    private DispositionView mCurrentDispositionView;

    private int mAdviseLines = -1;
    private int mCurrentPage;
    private int mNumberOfTemplates;
    private boolean mOkPressed;

    private List<Disposition> dispositions;
    private List<List<Disposition>> userDispositions = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDispositions = new ArrayList<>();
        saveDispositions(getDefaultDispositions());

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mOkPressed = false;

        setContentView(R.layout.activity_phase);

        mCurrentPage = 0;
        mNumberOfTemplates = getDispositionsTemplates().length;

        mAdvise = (TextView) findViewById(R.id.advise);
        mResizeFrame = (ResizeFrame) findViewById(R.id.resize_frame);

        mAdapter = new DispositionAdapter(this, getAllDispositions(), mResizeFrame, this);
        mPager = (ViewPager) findViewById(R.id.dispositions_pager);
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(this);
        mPager.setCurrentItem(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPause() {
        // Saved ?
        if (mOkPressed) {
            boolean saved = false;

            if (mCurrentDispositionView == null) {
                mCurrentDispositionView = mAdapter.getView(0);
            }

            if (mCurrentDispositionView != null) {
                if (mCurrentPage != 0 || mCurrentDispositionView.isChanged()) {
                    saveDispositions(mCurrentDispositionView.getDispositions());
                    saved = true;
                }

//                // Notify that the settings was changed
//                Intent intent = new Intent(PreferencesProvider.ACTION_SETTINGS_CHANGED);
//                if (saved) {
//                    intent.putExtra(PreferencesProvider.EXTRA_FLAG_REDRAW, Boolean.TRUE);
//                    intent.putExtra(PreferencesProvider.EXTRA_FLAG_RECREATE_WORLD, Boolean.TRUE);
//                }
//                this.sendBroadcast(intent);
            }
        }

        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPager.removeOnPageChangeListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.mnu_ok:
//                mOkPressed = true;
//                this.finish();
//                return true;
//            case R.id.mnu_restore:
//                restoreData();
//                return true;
//            case R.id.mnu_save:
//                addCurrentToSaved();
//                return true;
//            case R.id.mnu_delete:
//                if (mPager.getCurrentItem() > 0) {
//                    deleteCurrentSaved();
//                } else {
//                    deleteFrame();
//                }
//                return true;
//            default:
        return super.onOptionsItemSelected(item);
//        }
    }

    /**
     * Method that restores the disposition view to the default state
     */
    private void restoreData() {
        if (mCurrentDispositionView == null) {
            mCurrentDispositionView = mAdapter.getView(0);
        }
        mCurrentDispositionView.setDispositions(getCurrentDispositions(), getCols(), getRows(), true);
    }

    /**
     * Method that restores the disposition view to the default state
     */
    private void deleteFrame() {
        mCurrentDispositionView = mAdapter.getView(0);
        mCurrentDispositionView.deleteCurrentFrame();
    }

    /**
     * Method that returns the system-defined dispositions templates
     *
     * @return List<Dispositions> All the system-defined dispositions templates
     */
    public List<Dispositions> getAllDispositions() {
        final int rows = getRows();
        final int cols = getCols();

        List<Dispositions> allDispositions = new ArrayList<>();
        allDispositions.add(new Dispositions(Dispositions.TYPE_CURRENT, getCurrentDispositions(), rows, cols));
        allDispositions.addAll(getSavedDispositions(rows, cols));
        allDispositions.addAll(getSystemDefinedDispositions(rows, cols));
        return allDispositions;
    }

    /**
     * Method that returns the user-saved dispositions
     *
     * @param rows The number of rows
     * @param cols The number of columns
     * @return List<Dispositions> All the user-saved dispositions
     */
    private List<Dispositions> getSavedDispositions(int rows, int cols) {
        List<List<Disposition>> saved = getUserDispositions();
        List<Dispositions> savedDispositions = new ArrayList<>(saved.size());
        for (List<Disposition> d : saved) {
            savedDispositions.add(new Dispositions(Dispositions.TYPE_SAVED, d, rows, cols));
        }
        return savedDispositions;
    }

    /**
     * Method that returns the system-defined dispositions templates
     *
     * @param rows The number of rows
     * @param cols The number of columns
     * @return List<Dispositions> All the system-defined dispositions templates
     */
    private List<Dispositions> getSystemDefinedDispositions(int rows, int cols) {
        String[] templates = getDispositionsTemplates();
        List<Dispositions> systemDispositions = new ArrayList<>(templates.length);
        for (String template : templates) {
            systemDispositions.add(new Dispositions(Dispositions.TYPE_SYSTEM,DispositionUtil.toDispositions(template), rows, cols));
        }
        return systemDispositions;
    }

    public static List<List<Disposition>> getPortraitUserDispositions(Context context) {
        return getUserDispositions(context, "ui_layout_portrait_saved_disposition");
    }


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
    }


    private static List<List<Disposition>> getUserDispositions(Context context, String key) {
        Set<String> savedDispositions = getSharedPreferences(context).getStringSet(key, null);
        if (savedDispositions == null) {
            return new ArrayList<>();
        }

        List<String> ordered = new ArrayList<>(savedDispositions);
        Collections.sort(ordered, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                Integer lid = Integer.valueOf(lhs.substring(0, lhs.indexOf("=")));
                Integer rid = Integer.valueOf(rhs.substring(0, rhs.indexOf("=")));
                return lid.compareTo(rid);
            }
        });

        List<List<Disposition>> dispositions = new ArrayList<>();
        for (String s : ordered) {
            dispositions.add(DispositionUtil.toDispositions(s.substring(s.indexOf("=") + 1)));
        }
        return dispositions;
    }

    public static void setPortraitUserDispositions(Context context, List<List<Disposition>> dispositions) {
        setUserDispositions(context, "ui_layout_portrait_saved_disposition", dispositions);
    }

    private static void setUserDispositions(Context context, String key, List<List<Disposition>> dispositions) {
        Set<String> savedDispositions = new HashSet<>(dispositions.size());
        int i = 0;
        for (List<Disposition> d : dispositions) {
            savedDispositions.add(i + "=" + DispositionUtil.fromDispositions(d));
        }

        SharedPreferences preferences =
                context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(key, savedDispositions);
        editor.apply();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFrameSelectedListener(View v) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFrameUnselectedListener() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Ignored
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPageSelected(int position) {
        // Save state
        mCurrentPage = position;
        mCurrentDispositionView = mAdapter.getView(position);
        mCurrentDispositionView.deselectCurrentFrame();

        // Set the title
        if (position == 0) {
            mAdvise.setText(getString(R.string.pref_disposition_description));
        } else {
            if (mAdviseLines == -1) {
                mAdviseLines = mAdvise.getLineCount();
                mAdvise.setLines(mAdviseLines);
            }
            int saved = mAdapter.getCountOfSavedDispositions();
            if (position <= saved) {
                mAdvise.setText(getString(R.string.pref_disposition_saved,String.valueOf(position), String.valueOf(saved)));
            } else {
                mAdvise.setText(getString(R.string.pref_disposition_template,String.valueOf(position - saved), String.valueOf(mNumberOfTemplates)));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        mResizeFrame.setVisibility(View.GONE);
    }

    private void deleteCurrentSaved() {
        int current = mPager.getCurrentItem();
        deleteUserDisposition(current - 1);
        mAdapter.deleteUserDisposition(current);
        mPager.setCurrentItem(current - 1);
        mPager.setAdapter(mAdapter);
        Toast.makeText(this, R.string.saved_dispositions_delete_success,Toast.LENGTH_SHORT).show();
    }

    private void addCurrentToSaved() {
        List<Disposition> current = mAdapter.getView(0).getDispositions();
        if (getUserDispositions().contains(current)) {
            Toast.makeText(this, R.string.saved_dispositions_save_exists,Toast.LENGTH_SHORT).show();
            return;
        }
        Dispositions dispositions = new Dispositions(Dispositions.TYPE_SAVED,current, getRows(), getCols());
        saveUserDisposition(current);
        mAdapter.addUserDisposition(dispositions);
        mPager.setAdapter(mAdapter);
        Toast.makeText(this, R.string.saved_dispositions_save_success,Toast.LENGTH_SHORT).show();
    }


    /**
     * {@inheritDoc}
     */
    public List<Disposition> getCurrentDispositions() {
        return dispositions;
    }


    public List<Disposition> getDefaultDispositions() {
        return DispositionUtil.toDispositions(DEFAULT_PORTRAIT_DISPOSITION);
    }


    public String[] getDispositionsTemplates() {
        return this.getResources().getStringArray(R.array.portrait_disposition_templates);
    }


    public void saveDispositions(List<Disposition> dispositions) {
        this.dispositions = dispositions;
    }


    public List<List<Disposition>> getUserDispositions() {
        return userDispositions;
    }


    public void saveUserDisposition(List<Disposition> disposition) {
        userDispositions.add(disposition);
    }


    public void deleteUserDisposition(int position) {
        userDispositions.remove(position);
    }


    public int getRows() {
        return DEFAULT_ROWS;
    }


    public int getCols() {
        return DEFAULT_COLS;
    }

}

