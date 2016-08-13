package com.ligang.xiangha.utils;

import android.os.AsyncTask;

import com.ligang.xiangha.model.MvpModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by javac on 2016/8/13.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public class MyAsynTask extends AsyncTask<String,Void,byte[]> {
    private MvpModel.OnLoadaDataCompleted loadaDataCompleted;
    private String path;
    public MyAsynTask(MvpModel.OnLoadaDataCompleted loadaDataCompleted) {
        this.loadaDataCompleted = loadaDataCompleted;
    }

    @Override
    protected byte[] doInBackground(String... params) {
        path=params[0];
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.connect();
            int code = conn.getResponseCode();

            if(!isCancelled()&&code==HttpURLConnection.HTTP_OK){
                InputStream inputStream = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int len;
                byte bs[]=new byte[1024];
                while((len=inputStream.read(bs))!=-1){
                    baos.write(bs,0,len);
                }
                inputStream.close();
                return baos.toByteArray();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
        if(bytes!=null){
            loadaDataCompleted.load(bytes,path);
        }
    }
}
