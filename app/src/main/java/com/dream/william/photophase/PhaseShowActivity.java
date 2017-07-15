package com.dream.william.photophase;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dream.william.R;
import com.dream.william.photophase.model.Disposition;
import com.dream.william.photophase.model.Dispositions;
import com.dream.william.photophase.utils.DispositionUtil;
import com.dream.william.photophase.widgets.DispositionView;

import java.util.List;

public class PhaseShowActivity extends AppCompatActivity {

    private static final String PORTRAIT_DISPOSITION = "0x0:2x1|0x2:1x3|0x4:3x6|2x2:3x3|3x0:3x0|3x1:3x1";
    private static final int DEFAULT_COLS = 4;
    private static final int DEFAULT_ROWS = 7;

    private Dispositions mDispositions;
    private DispositionView dvView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_phase_show);

        setTitle("展示格子铺");

        List<Disposition> dispositions = DispositionUtil.toDispositions(PORTRAIT_DISPOSITION);
        mDispositions = new Dispositions(Dispositions.TYPE_CURRENT, dispositions, DEFAULT_ROWS, DEFAULT_COLS);

        dvView = (DispositionView) findViewById(R.id.dv_view);
        dvView.post(new Runnable() {
            @Override
            public void run() {
                dvView.setDispositions(mDispositions, true);
            }
        });

    }


}
