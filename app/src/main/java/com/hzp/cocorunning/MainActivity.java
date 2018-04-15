package com.hzp.cocorunning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import cn.bmob.v3.Bmob;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"dcb6f3d496754f2894444be08632e0fa");
        setContentView(R.layout.activity_main);
        
        MapView mapView = (MapView) findViewById(R.id.map);//找到地图控件
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mapView.onCreate(savedInstanceState);
        AMap aMap = mapView.getMap();//初始化地图控制器对象
    }
}
