package com.ligang.xiangha.model;

import com.ligang.xiangha.utils.MyAsynTask;

/**
 * Created by javac on 2016/8/14.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class QunZiModel implements MvpModel {
    @Override
    public void LodData(OnLoadaDataCompleted loadaDataCompleted, String path) {
        new MyAsynTask(loadaDataCompleted).execute(path);
    }
}
