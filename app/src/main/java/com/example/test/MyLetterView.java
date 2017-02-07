package com.example.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义快速导航
 *
 * @author XQF
 * @created 2017/2/7
 */
public class MyLetterView extends LinearLayout {
    private Context mContext;

    public MyLetterView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyLetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public MyLetterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        setLetters(getSortLetters());
    }

    private void setLetters(List<Character> charList) {
        removeAllViews();

        for (int i = 0; i < charList.size(); i++) {
            TextView tv = new TextView(mContext);
            tv.setText(charList.get(i).toString());
            addView(tv);
            final int temp = i;
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyEvent event = new MyEvent();
                    event.i = temp;
                    EventBus.getDefault().post(event);
                }
            });
        }
    }

    private List<Character> getSortLetters() {
        List<Character> result = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            result.add(Character.toUpperCase(i));
        }
        return result;
    }


}
