package com.ligang.xiangha.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ligang.xiangha.R;
import com.ligang.xiangha.adapter.LearnCookAdapter;
import com.ligang.xiangha.bean.ListViewBean;
import com.ligang.xiangha.bean.XiangHaTouTiaoBean;
import com.ligang.xiangha.fragment.CaiPuFenLei.CaiPuiFenLeiFragment;
import com.ligang.xiangha.fragment.MeiShiYangSheng.MeiShiYangShengFragment;
import com.ligang.xiangha.preserent.XiangHaTouTiaoPerserent;
import com.ligang.xiangha.utils.Goable;
import com.ligang.xiangha.utils.MyAsynTask;
import com.ligang.xiangha.utils.MyImgViewCallback;
import com.ligang.xiangha.view.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * 学做菜的fragment
 */
public class LearnCookeFragment extends Fragment implements MvpView, AbsListView.OnScrollListener, View.OnClickListener {


    private ListView listView;
    private View head;
    private Context context;
    private int num = 1;
    boolean isLoding=false;
    boolean isCanLoadMore=false;
    List<ListViewBean.DataBean> listdata = new ArrayList<ListViewBean.DataBean>();
    private LearnCookAdapter adapter;
    private View view;

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
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_learn_cooke, container, false);
        listView = ((ListView) view.findViewById(R.id.listview));
        head = inflater.inflate(R.layout.learncook_header, null);
        //设置今日佳作模块
        LinearLayout jinrjiazuo = (LinearLayout) head.findViewById(R.id.jinr);
        jinrjiazuo.setOnClickListener(this);

        //设置美食养生模块
        LinearLayout meishi = (LinearLayout) head.findViewById(R.id.meishi);
        meishi.setOnClickListener(this);

        //设置菜谱分类
        LinearLayout fenlei = (LinearLayout) head.findViewById(R.id.fenlei);
        fenlei.setOnClickListener(this);

        new XiangHaTouTiaoPerserent(this).getData(Goable.SERVER + Goable.XIANGHATOUXIAO, 0);
        new XiangHaTouTiaoPerserent(this).getData(String.format(Goable.SHOUYE_JINGCAISHENGHUO, num), 1);
        listView.setOnScrollListener(this);
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
                if (num == 1) {
                    List<ListViewBean.DataBean> data = ((ListViewBean) t).getData();
                    listdata.addAll(data);
                    adapter = new LearnCookAdapter(listdata);
                    listView.setAdapter(adapter);
                } else {
                    List<ListViewBean.DataBean> data = ((ListViewBean) t).getData();
                    listdata.addAll(data);
                    adapter.notifyDataSetChanged();
                }
                break;

        }

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (isCanLoadMore && scrollState == SCROLL_STATE_IDLE) {
            Toast.makeText(context, "正在拼命加载中.....", Toast.LENGTH_SHORT).show();
            isLoding = true;
            isCanLoadMore = false;
            new XiangHaTouTiaoPerserent(this).getData(String.format(Goable.SHOUYE_JINGCAISHENGHUO, (++num)), 1);
            isLoding = false;

        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount) {
            View childAt = view.getChildAt(visibleItemCount - 1);
            if (!isLoding && childAt!=null&&childAt.getBottom() <= view.getHeight()) {
                isCanLoadMore = true;
            }
        }

    }

    @Override
    public void onStop() {
       view= getView();
        super.onStop();
    }

    /**
     * 跳转到今日佳作页面
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.meishi:
            MeiShiYangShengFragment meiShiYangShengFragment = new MeiShiYangShengFragment();
            getFragmentManager().beginTransaction().addToBackStack(meiShiYangShengFragment.getClass().getSimpleName()).replace(R.id.container, meiShiYangShengFragment).commit();
                break;
            case  R.id.fenlei:
                CaiPuiFenLeiFragment caiPuiFenLeiFragment = new CaiPuiFenLeiFragment();
                getFragmentManager().beginTransaction().addToBackStack(caiPuiFenLeiFragment.getClass().getSimpleName()).replace(R.id.container,caiPuiFenLeiFragment).commit();
                break;
            case  R.id.jinr:
                jinRJiaZuoFragment jinRJiaZuoFragment = new jinRJiaZuoFragment();
                getFragmentManager().beginTransaction().addToBackStack(jinRJiaZuoFragment.getClass().getSimpleName()).replace(R.id.container,jinRJiaZuoFragment).commit();
                break;
        }
    }
}
