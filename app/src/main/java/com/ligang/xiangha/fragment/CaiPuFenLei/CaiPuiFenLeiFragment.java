package com.ligang.xiangha.fragment.CaiPuFenLei;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ligang.xiangha.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaiPuiFenLeiFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private Context context;
    private String[] listStr;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    public CaiPuiFenLeiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_cai_pui_fen_lei, container, false);
        ListView caipu_listView = (ListView) view.findViewById(R.id.caipu_listview);
        listStr = new String[]{"热门", "视频", "肉类", "蛋/奶", "鱼类", "水产", "蔬菜", "豆类", "果类品", "五谷杂粮", "药食", "调味品", "其他", "菜式", "菜系", "特色", "烘焙", "主食", "器具", "烹饪方式", "口味", "场合", "节日"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listStr);
        caipu_listView.setAdapter(arrayAdapter);
        caipu_listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (listStr[position]){
            case "鱼类":
                YuLeiFragment yuLeiFragment = new YuLeiFragment();
                getChildFragmentManager().beginTransaction().addToBackStack(yuLeiFragment.getClass().getSimpleName()).replace(R.id.caipu_fragment,yuLeiFragment).commit();
                break;
        }
    }
}
