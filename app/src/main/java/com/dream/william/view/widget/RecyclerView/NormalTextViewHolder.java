package com.dream.william.view.widget.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.william.R;

/**
 * Created by william on 10/16/17.
 */

public class NormalTextViewHolder extends RecyclerView.ViewHolder {


    TextView mTextView;

    public NormalTextViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.tv_card);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Click Item View !", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
