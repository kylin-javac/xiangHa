package com.ligang.xiangha.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.ligang.xiangha.R;
import com.ligang.xiangha.fragment.BBS.BbsFragment;
import com.ligang.xiangha.fragment.LearnCookeFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;
    private LearnCookeFragment learnCookeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        learnCookeFragment = new LearnCookeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, learnCookeFragment).commit();

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_learn_cooke:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, learnCookeFragment).commit();
                break;
            case R.id.rb_bbs:
                BbsFragment bbsFragment = new BbsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,bbsFragment).commit();
                break;
            case R.id.rb_shop:
                break;
            case R.id.rb_message:
                break;
            case R.id.rb_me:
                break;
        }

    }
}
