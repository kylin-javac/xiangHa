package com.ligang.xiangha.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ligang.xiangha.R;

import java.util.ArrayList;

/**
 * 学做菜的fragment
 */
public class LearnCookeFragment extends Fragment {


    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_cooke, container, false);
        listView = ((ListView) view.findViewById(R.id.listview));
        View head = inflater.inflate(R.layout.learncook_header, null);
        listView.addHeaderView(head);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("数据"+i);
        }
        LearnCookeAdapter myAdapter = new LearnCookeAdapter(list);
        listView.setAdapter(myAdapter);
        return view;
    }

}
