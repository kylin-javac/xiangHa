package com.ligang.xiangha.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ligang.xiangha.R;

import java.util.List;

/**
 * Created by javac on 2016/8/12.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class LearnCookeAdapter extends BaseAdapter {
    private List<String> list;

    public LearnCookeAdapter(List<String> list) {
        this.list=list;

    }


    @Override
    public int getCount() {
        return list==null?0:list.size();
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
        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.learn_cooke_item,null);
            holder=new ViewHolder();
            holder.txt= (TextView) convertView.findViewById(R.id.txt);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
            holder.txt.setText(list.get(position));
        }
        return convertView;
    }
    static  class ViewHolder{
        TextView txt;
    }
}
