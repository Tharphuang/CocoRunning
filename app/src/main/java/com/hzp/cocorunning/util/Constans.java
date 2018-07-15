package com.hzp.cocorunning.util;

import com.amap.api.maps.model.LatLng;
import com.hzp.cocorunning.model.entity.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzp on 2018/4/16.
 */

public class Constans {
    public static List<Card> cardBeans =new ArrayList<Card>();

    public static int CardSelect;
    public static long cardList;
    //学六
    public static LatLng latLng0 = new LatLng(39.964546,116.358041);
    //教三
    public static LatLng latLng1 = new LatLng(39.960395,116.356351);
    //小白楼
    public static LatLng latLng2 = new LatLng(39.962099,116.358003);
    //游泳馆
    public static LatLng latLng3 = new LatLng(39.961966,116.360766);
    //时光广场
    public static LatLng latLng4 = new LatLng(39.962373,116.357399);
    //主楼
    public static LatLng latLng5 = new LatLng(39.961249,116.358091);
    //一个List存储北邮校内的一些标志性建筑物
    public static List<LatLng> latLngList = Arrays.asList(latLng0,latLng1,latLng2,latLng3,latLng4,latLng5);
}
