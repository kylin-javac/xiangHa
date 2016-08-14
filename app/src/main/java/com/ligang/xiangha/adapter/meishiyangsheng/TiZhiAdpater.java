package com.ligang.xiangha.adapter.meishiyangsheng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ligang.xiangha.R;

import java.util.List;

/**
 * Created by javac on 2016/8/14.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class TiZhiAdpater extends BaseAdapter {
    private List<String> list;

    public TiZhiAdpater(List<String> list) {
        this.list = list;
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
        ViewHolde holde;

        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textview,null);
            holde=new ViewHolde();
            holde.txt= (TextView) convertView.findViewById(R.id.item_txt);
            convertView.setTag(holde);

        }else{
             holde= (ViewHolde) convertView.getTag();
        }
        holde.txt.setText(list.get(position));
        return convertView;
    }
    static  class ViewHolde{
        TextView txt;
    }
}
