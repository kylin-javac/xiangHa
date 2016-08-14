package com.ligang.xiangha.preserent;

import android.util.Log;

import com.google.gson.Gson;
import com.ligang.xiangha.bean.ListViewBean;
import com.ligang.xiangha.model.JinRjiaZuoModel;
import com.ligang.xiangha.model.MvpModel;
import com.ligang.xiangha.view.MvpView;

/**
 * author: 李刚 on 2016/8/13 20:37
 * email: kylin_javac@outlook.com
 * desc :
 */
public class JinRJiaZuoPerserent {
    private MvpView mvpView;
    private MvpModel mvpModel;

    public JinRJiaZuoPerserent(MvpView mvpView) {
        this.mvpView = mvpView;
        mvpModel= new JinRjiaZuoModel();
    }
    public void getData(String path, final int tag){
        mvpModel.LodData(new MvpModel.OnLoadaDataCompleted() {
            @Override
            public void load(byte[] bs, String path) {
                String josn = new String(bs);
                Log.e("-------------", josn );
                ListViewBean listViewBean = new Gson().fromJson(josn, ListViewBean.class);
                mvpView.Show(listViewBean,tag);
            }
        },path);
    }

}
