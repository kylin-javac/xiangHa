package com.ligang.xiangha.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ligang.xiangha.R;
import com.ligang.xiangha.bean.ListViewBean;
import com.ligang.xiangha.utils.MyAsynTask;
import com.ligang.xiangha.utils.MyImgViewCallback;

import java.util.List;

/**
 * Created by javac on 2016/8/12.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class LearnCookAdapter extends BaseAdapter {
    private List<ListViewBean.DataBean> dataBeanList;

    public LearnCookAdapter(List<ListViewBean.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }

    @Override
    public int getCount() {
        return dataBeanList==null?0:dataBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewBean.DataBean dataBean = dataBeanList.get(position);
        ViewHolder viewHolder =null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jincaishenghuo, null);
            viewHolder.userpic = (ImageView) convertView.findViewById(R.id.userpic);
            viewHolder.first = (ImageView) convertView.findViewById(R.id.first);
            viewHolder.second = (ImageView) convertView.findViewById(R.id.second);
            viewHolder.third = (ImageView) convertView.findViewById(R.id.third);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.username);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.desc);
            viewHolder.time = (TextView) convertView.findViewById(R.id.timeandcategory);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.userName.setText(dataBean.getCustomer().getNickName());
        viewHolder.title.setText(dataBean.getTitle());
        viewHolder.desc.setText(dataBean.getContent());
        viewHolder.time.setText(dataBean.getTimeShow()+" - "+dataBean.getCName());
        viewHolder.userpic.setTag(dataBean.getCustomer().getImg());
        Log.e("自定义标签", "类名==LearnCookAdapter" + "方法名==getView=====:" + dataBean.getImgs().size());
        viewHolder.first.setTag(dataBean.getImgs().get(0));
        viewHolder.second.setTag(dataBean.getImgs().get(1));
        int i= dataBean.getImgs().size() > 2 ? 2 : 1;//根据数据源的长度来把最后一张图片确定一下,如果是3张图就取2,是两张图就取1
        viewHolder.third.setTag(dataBean.getImgs().get(i));
        viewHolder.userpic.setImageBitmap(null);
        viewHolder.first.setImageBitmap(null);
        viewHolder.second.setImageBitmap(null);
        viewHolder.third.setImageBitmap(null);
        new MyAsynTask(new MyImgViewCallback(viewHolder.userpic)).execute(dataBean.getCustomer().getImg());
        new MyAsynTask(new MyImgViewCallback(viewHolder.first)).execute(dataBean.getImgs().get(0));
        new MyAsynTask(new MyImgViewCallback(viewHolder.second)).execute(dataBean.getImgs().get(1));
        new MyAsynTask(new MyImgViewCallback(viewHolder.third)).execute(dataBean.getImgs().get(i));
        return convertView;
    }

    static class ViewHolder{
        ImageView userpic,first,second, third;
        TextView userName,title,desc, time;


    }
}