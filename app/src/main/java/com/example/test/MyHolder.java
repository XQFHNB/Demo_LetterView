package com.example.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * @author XQF
 * @created 2017/2/7
 */
public class MyHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    public MyHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.textView);
    }

    public void bind(Character c) {
        mTextView.setText(c.toString());
    }
}
