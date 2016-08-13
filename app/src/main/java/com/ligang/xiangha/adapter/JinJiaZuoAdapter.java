package com.ligang.xiangha.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ligang.xiangha.R;

import java.util.List;

/**
 * Created by javac on 2016/8/13.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class JinJiaZuoAdapter extends BaseAdapter {
    private List<String> list;

    public JinJiaZuoAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.test = (TextView) convertView.findViewById(R.id.test);
            convertView.setTag(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String s = list.get(position);
        holder.test.setText(s);
        return convertView;
    }

    static class ViewHolder {
        TextView test;
    }
}
