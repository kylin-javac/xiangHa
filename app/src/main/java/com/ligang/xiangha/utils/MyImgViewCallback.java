package com.ligang.xiangha.utils;

import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.ligang.xiangha.model.MvpModel;

/**
 * Created by javac on 2016/8/13.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class MyImgViewCallback implements MvpModel.OnLoadaDataCompleted {
    private ImageView imageView;

    public MyImgViewCallback(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    public void load(byte[] bs, String path) {
        String path1 = (String) imageView.getTag();
        if(path1!=null&&path.equals(path)){
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bs,0,bs.length));
        }

    }
}
