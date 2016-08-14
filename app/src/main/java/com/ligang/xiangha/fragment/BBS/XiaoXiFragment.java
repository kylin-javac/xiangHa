package com.ligang.xiangha.fragment.BBS;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.ligang.xiangha.R;
import com.ligang.xiangha.adapter.QuanZiAdapter;
import com.ligang.xiangha.bean.QuanZipBean;
import com.ligang.xiangha.preserent.QuanZiPerserent;
import com.ligang.xiangha.utils.Goable;
import com.ligang.xiangha.view.MvpView;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiaoXiFragment extends Fragment implements MvpView{
    private View view;
    private GridView bbs_grid;

    public XiaoXiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_xiao_xi, container, false);
        bbs_grid = (GridView) view.findViewById(R.id.bbs_grid);
        new QuanZiPerserent(this).getData(Goable.QUANZI,0);
        return view;
    }

    @Override
    public void Show(Object t, int tag) {
        QuanZipBean t1 = (QuanZipBean) t;
        QuanZiAdapter quanZiAdapter = new QuanZiAdapter(t1.getData().getAllQuan());
        bbs_grid.setAdapter(quanZiAdapter);
        Log.e("自定义标签", "类名==XiaoXiFragment" + "方法名==Show=====:" + t1.getData());

    }
}
