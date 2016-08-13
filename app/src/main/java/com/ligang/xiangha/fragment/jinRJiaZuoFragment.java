package com.ligang.xiangha.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ligang.xiangha.R;
import com.ligang.xiangha.adapter.JinJiaZuoAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class jinRJiaZuoFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_jin_rjia_zuo, container, false);

        ListView listView = (ListView) view.findViewById(R.id.jia_listview);
        View head2 =  inflater.inflate(R.layout.head2,null);

        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add("数据"+i);
        }
        JinJiaZuoAdapter adapter = new JinJiaZuoAdapter(list);
        listView.setAdapter(adapter);
        listView.addHeaderView(head2);
        return view;
    }

    @Override
    public void onStop() {
        view = getView();
        super.onStop();
    }
}
