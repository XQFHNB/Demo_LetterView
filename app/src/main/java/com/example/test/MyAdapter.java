package com.example.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 *
 * @author XQF
 * @created 2017/2/7
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<Character> mList;
    private Context mContext;

    public MyAdapter(Context context) {
        mContext = context;
        mList = getSortLetters();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Character c = mList.get(position);
        holder.bind(c);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    private List<Character> getSortLetters() {
        List<Character> result = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            result.add(Character.toUpperCase(i));
        }
        return result;
    }
}
