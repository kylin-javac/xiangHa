package com.ligang.xiangha.preserent;

import com.google.gson.Gson;
import com.ligang.xiangha.bean.QuanZipBean;
import com.ligang.xiangha.model.MvpModel;
import com.ligang.xiangha.model.QunZiModel;
import com.ligang.xiangha.view.MvpView;

/**
 * Created by javac on 2016/8/14.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class QuanZiPerserent {
    private MvpView mvpView;
    private MvpModel mvpModel;

    public QuanZiPerserent(MvpView mvpView) {
        this.mvpView = mvpView;
        mvpModel = new QunZiModel();
    }

    public void getData(String path, final int tag) {
        mvpModel.LodData(new MvpModel.OnLoadaDataCompleted() {
            @Override
            public void load(byte[] bs, String path) {
                String json = new String(bs);
                QuanZipBean quanZipBean = new Gson().fromJson(json, QuanZipBean.class);
                mvpView.Show(quanZipBean, tag);
            }
        }, path);
    }
}
