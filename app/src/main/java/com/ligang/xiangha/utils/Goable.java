package com.ligang.xiangha.utils;

/**
 * Created by javac on 2016/8/12.
 * Email:kylin_javac@outlook.com
 * Desc:
 */
public interface Goable {
    String SERVER="http://api.xiangha.com/";
    String XIANGHATOUXIAO="main6/index/baseData?";
    String SHOUYE_JINGCAISHENGHUO = SERVER + "main6/index/getTieList?page=%d&pageTime=";
    String JINJIAZUO=SERVER+"main6/index/todayGood?type=1&page=1";

}
