package com.dream.william.component.content;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class CpUserDictionaryActivity extends BaseActivity implements TextWatcher {

    private Toolbar mTbBar;
    private EditText etWord;
    private ListView lvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_user_dictionary);

        initView();
    }

    private void initView() {
        mTbBar = findViewById(R.id.tb_bar);
        mTbBar.setTitle("User Dictionary Provider");

        setSupportActionBar(mTbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etWord = findViewById(R.id.et_word);
        etWord.addTextChangedListener(this);
        lvDesc = findViewById(R.id.lv_desc);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        query();
    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    private void query() {
        String[] mProjection = {UserDictionary.Words._ID, UserDictionary.Words.WORD, UserDictionary.Words.LOCALE};
        String mSelectionClause;
        String[] mSelectionArgs = {""};
        String mSearchString = etWord.getText().toString();

        if (TextUtils.isEmpty(mSearchString)) {
            mSelectionClause = null;
            mSelectionArgs[0] = "";
        } else {
            mSelectionClause = UserDictionary.Words.WORD + " = ?";
            mSelectionArgs[0] = mSearchString;
        }

        Cursor mCursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, null);

        if (null == mCursor) {
            Toast.makeText(this, "Cursor be null ...", Toast.LENGTH_SHORT).show();
        } else if (mCursor.getCount() < 1) {
            Toast.makeText(this, "no match data ...", Toast.LENGTH_SHORT).show();
        } else {
            String[] mWordListColumns = {UserDictionary.Words.WORD, UserDictionary.Words.LOCALE};
            int[] mWordListItems = {R.id.tv_word, R.id.tv_locale};
            SimpleCursorAdapter mCursorAdapter = new SimpleCursorAdapter(
                    getApplicationContext(),               // The application's Context object
                    R.layout.item_word,                  // A layout in XML for one row in the ListView
                    mCursor,                               // The result from the query
                    mWordListColumns,                      // A string array of column names in the cursor
                    mWordListItems,                        // An integer array of view IDs in the row layout
                    0);                                    // Flags (usually none are needed)
            lvDesc.setAdapter(mCursorAdapter);
        }

    }


}
