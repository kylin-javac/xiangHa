package com.ligang.xiangha.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ligang.xiangha.R;
import com.ligang.xiangha.bean.QuanZipBean;

import java.util.List;

/**
 * Created by javac on 2016/8/14.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class QuanZiAdapter extends BaseAdapter {
    private List<QuanZipBean.DataBean.AllQuanBean> list;

    public QuanZiAdapter(List<QuanZipBean.DataBean.AllQuanBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quanzi, null);
            holder = new ViewHolder();

            holder.quanzi_name = (TextView) convertView.findViewById(R.id.Quanzi_name);
            holder.quanzi_number = (TextView) convertView.findViewById(R.id.Quanzi_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        list.get(position).getDayHotNum();
        list.get(position).getName();
        holder.quanzi_number.setText(list.get(position).getDayHotNum()+"");
        holder.quanzi_name.setText(list.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        TextView quanzi_name, quanzi_number;
    }
}
