package com.ligang.xiangha.fragment.MeiShiYangSheng;


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
public class MeiShiYangShengFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private Context context;
    private ListView meishi_listView;
    private String[] meishi;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_mei_shi_yang_sheng, container, false);
        meishi_listView = (ListView) view.findViewById(R.id.meishi_listview);
        meishi = new String[]{"体质", "生辰", "美容", "减肥", "经期", "性", "孕妇", "常见食疗", "婴儿及妈妈", "辛苦的爸爸", "保健调养", "补养", "节气", "人群功效"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, meishi);
        meishi_listView.setAdapter(arrayAdapter);
        meishi_listView.setOnItemClickListener(this);
        return view;

    }

    @Override
    public void onStop() {
        super.onStop();
        view = getView();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (meishi[position]) {
            case "体质":
                TiZhiFragment tiZhiFragment = new TiZhiFragment();
                getChildFragmentManager().beginTransaction().addToBackStack(tiZhiFragment.getClass().getSimpleName()).replace(R.id.meishi_fragment, tiZhiFragment).commit();
                break;
            case "生辰":
                ShiChengFragment shiChengFragment = new ShiChengFragment();
                getChildFragmentManager().beginTransaction().addToBackStack(shiChengFragment.getClass().getSimpleName()).replace(R.id.meishi_fragment,shiChengFragment).commit();
                break;
            case "美容":
                MeiRongFragment meiRongFragment = new MeiRongFragment();
                getChildFragmentManager().beginTransaction().addToBackStack(meiRongFragment.getClass().getSimpleName()).replace(R.id.meishi_fragment,meiRongFragment).commit();
                break;
            case "减肥":
                JianFeiFragment jianFeiFragment = new JianFeiFragment();
                getChildFragmentManager().beginTransaction().addToBackStack(jianFeiFragment.getClass().getSimpleName()).replace(R.id.meishi_fragment,jianFeiFragment).commit();
                break;
            case "补养":
                BuYangFragment buYangFragment = new BuYangFragment();
                getChildFragmentManager().beginTransaction().addToBackStack(buYangFragment.getClass().getSimpleName()).replace(R.id.meishi_fragment,buYangFragment).commit();
                break;


        }

    }
}
