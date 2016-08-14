package com.ligang.xiangha.model;

import com.ligang.xiangha.utils.MyAsynTask;

/**
 * author: 李刚 on 2016/8/13 20:36
 * email: kylin_javac@outlook.com
 * desc :
 */
public class JinRjiaZuoModel implements MvpModel {
    @Override
    public void LodData(OnLoadaDataCompleted loadaDataCompleted, String path) {
        new MyAsynTask(loadaDataCompleted).execute(path);
    }
}
