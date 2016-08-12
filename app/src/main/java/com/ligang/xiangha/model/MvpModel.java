package com.ligang.xiangha.model;

/**
 * Created by javac on 2016/8/12.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public interface MvpModel {
    void LodData(OnLoadaDataCompleted loadaDataCompleted,String path);
    public interface  OnLoadaDataCompleted{
        void load(byte bs[],String path);
    }
}
