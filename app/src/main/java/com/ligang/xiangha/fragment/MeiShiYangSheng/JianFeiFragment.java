package com.ligang.xiangha.fragment.MeiShiYangSheng;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ligang.xiangha.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JianFeiFragment extends Fragment {
    private View view;

    public JianFeiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view!=null){
            return  view;
        }
        view= inflater.inflate(R.layout.fragment_jian_fei, container, false);
        return  view;
    }

}
