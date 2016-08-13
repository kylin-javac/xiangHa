package com.ligang.xiangha.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ligang.xiangha.R;
import com.ligang.xiangha.adapter.LearnCookeAdapter;
import com.ligang.xiangha.bean.ListViewBean;
import com.ligang.xiangha.bean.XiangHaTouTiaoBean;
import com.ligang.xiangha.preserent.XiangHaTouTiaoPerserent;
import com.ligang.xiangha.utils.Goable;
import com.ligang.xiangha.utils.MyAsynTask;
import com.ligang.xiangha.utils.MyImgViewCallback;
import com.ligang.xiangha.view.MvpView;

import java.util.ArrayList;

/**
 * 学做菜的fragment
 */
public class LearnCookeFragment extends Fragment implements MvpView {


    private ListView listView;
    private View head;
    private Context context;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_cooke, container, false);
        listView = ((ListView) view.findViewById(R.id.listview));
        head = inflater.inflate(R.layout.learncook_header, null);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("数据" + i);
        }
        LearnCookeAdapter myAdapter = new LearnCookeAdapter(list);
        listView.setAdapter(myAdapter);
        new XiangHaTouTiaoPerserent(this).getData(Goable.SERVER + Goable.XIANGHATOUXIAO,0);
        new XiangHaTouTiaoPerserent(this).getData(Goable.SHOUYE_JINGCAISHENGHUO,1);
        return view;
    }



    /**
     * 设置头部局的内容
     *
     * @param xiang
     * @param head
     * @param listView
     */
    public void setDataHead(XiangHaTouTiaoBean xiang, View head, ListView listView) {
        /**
         * 香哈头条布局填充
         */
        View diyigeView = head.findViewById(R.id.diyigetoutiao);
        getTopView(xiang, diyigeView, 0);

        View diergeView = head.findViewById(R.id.diergetoutiao);
        getTopView(xiang, diergeView, 1);

        /**
         *人气美食家布局填充
         */
        LinearLayout touxianglin = (LinearLayout) head.findViewById(R.id.touxianglin);
        for (int i = 0; i < xiang.getData().getActiveUser().size(); i++) {
            View view = View.inflate(context, R.layout.item1, null);
            TextView text = (TextView) view.findViewById(R.id.name);
            ImageView imageView = (ImageView) ((ImageView) view.findViewById(R.id.img));
            imageView.setTag(xiang.getData().getActiveUser().get(i).getImg());
            new MyAsynTask(new MyImgViewCallback(imageView)).execute(xiang.getData().getActiveUser().get(i).getImg());
            text.setText(xiang.getData().getActiveUser().get(i).getNickName());
            touxianglin.addView(view);
        }
        /**
         * 精选专题
         */
        FrameLayout topfirst_view = (FrameLayout) head.findViewById(R.id.topfirst);
        getImageView(xiang, topfirst_view, 0);

        FrameLayout topsecond_view = (FrameLayout) head.findViewById(R.id.topsecond);
        getImageView(xiang, topsecond_view, 1);

        FrameLayout topthird_view = (FrameLayout) head.findViewById(R.id.topthird);
        getImageView(xiang, topthird_view, 2);

        listView.addHeaderView(head);

    }

    private void getTopView(XiangHaTouTiaoBean xiang, View diyigeView, int i) {
        ImageView diyigeView_img = (ImageView) diyigeView.findViewById(R.id.pic);
        TextView diyigeView_titile = (TextView) diyigeView.findViewById(R.id.titile);
        TextView diyigeView_jinxuan = (TextView) diyigeView.findViewById(R.id.jinxuan);
        TextView diyigeView_reviewcount = (TextView) diyigeView.findViewById(R.id.reviewcount);
        TextView diyigeView_pcount = (TextView) diyigeView.findViewById(R.id.pcount);
        diyigeView_titile.setText(xiang.getData().getNous().get(i).getTitle());
        diyigeView_jinxuan.setText(xiang.getData().getNous().get(i).getClassifyname());
        diyigeView_pcount.setText(xiang.getData().getNous().get(i).getCommentCount() + "评论");
        diyigeView_reviewcount.setText(xiang.getData().getNous().get(i).getAllClick() + "浏览");
        diyigeView_img.setTag(xiang.getData().getNous().get(i).getImg());
        new MyAsynTask(new MyImgViewCallback(diyigeView_img)).execute(xiang.getData().getNous().get(i).getImg());
    }

    private void getImageView(XiangHaTouTiaoBean xiang, FrameLayout topfirst_view, int i) {
        ImageView topfirst_jingxuanpic = (ImageView) topfirst_view.findViewById(R.id.jingxuanpic);
        TextView topfirst__jingxuantitle = (TextView) topfirst_view.findViewById(R.id.jingxuantitle);
        TextView topfirst__jingxuansubtitle = (TextView) topfirst_view.findViewById(R.id.jingxuansubtitle);
        topfirst_jingxuanpic.setTag(xiang.getData().getTopic().get(i).getImgs());
        new MyAsynTask(new MyImgViewCallback(topfirst_jingxuanpic)).execute(xiang.getData().getTopic().get(i).getImgs());
        topfirst__jingxuantitle.setText(xiang.getData().getTopic().get(i).getTitle());
        topfirst__jingxuansubtitle.setText(xiang.getData().getTopic().get(i).getSubtitle());
    }

    @Override
    public void Show(Object t, int tag) {
        switch (tag) {
            case 0:
                ((XiangHaTouTiaoBean) t).getData().getActiveUser();
                setDataHead((XiangHaTouTiaoBean) t, head, listView);
                break;
            case 1:
                Log.e("自定义标签", "类名==LearnCookeFragment" + "方法名==Show=====:" + ((ListViewBean) t));
                break;
        }

    }
}
