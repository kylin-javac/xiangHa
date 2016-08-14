package com.ligang.xiangha.fragment.MeiShiYangSheng;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.ligang.xiangha.R;
import com.ligang.xiangha.adapter.meishiyangsheng.TiZhiAdpater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiZhiFragment extends Fragment {
    private View view;
    private GridView gird_tizhi;

    public TiZhiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_ti_zhi, container, false);
        gird_tizhi = (GridView) view.findViewById(R.id.gird_tizhi);
        ArrayList<String> list = new ArrayList<>();
        list.add("平和质");
        list.add("阳虚质");
        list.add("气虚质");
        list.add("痰湿质");
        list.add("湿热质");
        list.add("阴虚质");
        list.add("血瘀质");
        list.add("气郁质");
        list.add("特禀质");
        TiZhiAdpater tiZhiAdpater = new TiZhiAdpater(list);
        gird_tizhi.setAdapter(tiZhiAdpater);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        view=getView();
    }
}
