package com.ligang.xiangha.preserent;

import com.google.gson.Gson;
import com.ligang.xiangha.bean.ListViewBean;
import com.ligang.xiangha.bean.XiangHaTouTiaoBean;
import com.ligang.xiangha.model.MvpModel;
import com.ligang.xiangha.model.XiangHaTouTiaoModel;
import com.ligang.xiangha.view.MvpView;

/**
 * Created by javac on 2016/8/13.
 * Email:kylin_javac@outlook.com
 * Desc:香哈头条的preserent
 */
public class XiangHaTouTiaoPerserent {
    private MvpView mvpView;
    private MvpModel mvpModel;

    public XiangHaTouTiaoPerserent(MvpView mvpView) {
        this.mvpView = mvpView;
        this.mvpModel = new XiangHaTouTiaoModel();
    }

    public void getData(String path, final int tag) {
        switch (tag) {
            case 0:
                mvpModel.LodData(new MvpModel.OnLoadaDataCompleted() {
                    @Override
                    public void load(byte[] bs, String path) {
                        String json = new String(bs);
                        XiangHaTouTiaoBean touTiaoBean = new Gson().fromJson(json, XiangHaTouTiaoBean.class);
                        mvpView.Show(touTiaoBean,tag);
                    }
                }, path);
                break;
            case 1:
                mvpModel.LodData(new MvpModel.OnLoadaDataCompleted() {
                    @Override
                    public void load(byte[] bs, String path) {
                        String json = new String(bs);
                        ListViewBean listViewBean = new Gson().fromJson(json, ListViewBean.class);
                        mvpView.Show(listViewBean,tag);
                    }
                },path);


                break;
        }

    }
}
