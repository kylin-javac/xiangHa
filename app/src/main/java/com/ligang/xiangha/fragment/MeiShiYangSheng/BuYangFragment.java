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
public class BuYangFragment extends Fragment {
    private View view;

    public BuYangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view!=null){
            return  view;
        }
        view= inflater.inflate(R.layout.fragment_bu_yang, container, false);
        return  view;
    }

}
