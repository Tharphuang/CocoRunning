package com.hzp.cocorunning;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.hzp.cocorunning.ui.CardallActivity;
import com.hzp.cocorunning.ui.LoginActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.bmob.v3.Bmob;


public class MainActivity extends AppCompatActivity implements AMap.OnMyLocationChangeListener {
    private Button btn_mianlogin;
    private Button btn_download;

    MyLocationStyle myLocationStyle;
    private LatLng latlngA = new LatLng(39.964546,116.358041);//北邮学6坐标
    //指示点的坐标
    private LatLng latlngDirection;

    TextView text;
    TextView tex1;
    private double distance = 10000;
    private UiSettings mUiSettings;
    //在地图上画一个点 ，以显示方向
    private MarkerOptions markerOption;
    private Marker marker;
    MapView mMapView = null;
    private AMap aMap;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"dcb6f3d496754f2894444be08632e0fa");
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.info_text);
        tex1 = findViewById(R.id.info_text1);
        //获取地图控件的引用
        mMapView = findViewById(R.id.map);
        //创建地图
        mMapView.onCreate(savedInstanceState);// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        //初始化地图控制器对象
        aMap = mMapView.getMap();

//        AmapLocationInit();
//        startLocation();
        aMap.setOnMyLocationChangeListener(this);
        aMap.setMinZoomLevel(19);
        setMapCustomStyleFile(this);
        aMap.setMapCustomEnable(true);


        //定位小蓝点的显示
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.strokeColor(Color.argb(255,255,255,255));//设置定位蓝点精度圆圈的边框颜色的方法。
        myLocationStyle.radiusFillColor(Color.argb(0,0,0,0));//设置定位蓝点精度圆圈的填充颜色的方法。
        myLocationStyle.strokeWidth((float) 2.0);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory
                .fromResource(R.drawable.br_up));// 设置小蓝点的图标
        myLocationStyle.interval(1500); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。

        //设置一些地图的参数
        mUiSettings = aMap.getUiSettings();
        //mUiSettings.setTiltGesturesEnabled(false);// 设置地图是否可以倾斜
        mUiSettings.setScaleControlsEnabled(true);// 设置地图默认的比例尺是否显示

        if(judgeTheDistance(distance)){
            //Intent intent = new Intent(this,Main2Activity.class);
           // startActivity(intent);
        }


        btn_mianlogin=findViewById(R.id.btn_mainlogin);
        btn_mianlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_download=findViewById(R.id.btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this, CardallActivity.class);
               startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //活动销毁时销毁地图
        mMapView.onDestroy();
        //停止定位，销毁定位客户端
    }
    @Override
    protected void onResume(){
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onMyLocationChange(Location location) {
        LatLng latlngB = new LatLng(location.getLatitude(),location.getLongitude());
        distance = AMapUtils.calculateLineDistance(latlngA, latlngB);
        text.setText("你的坐标为："+latlngB+"\n距离目标点:"+distance+"m\n");
        tex1.setText(myLocationStyle.getRadiusFillColor()+" "+myLocationStyle.getStrokeColor()+" "+myLocationStyle.getStrokeWidth());
        //显示指明方向的点
        double lat = latlngA.latitude-latlngB.latitude;
        double lng = latlngA.longitude-latlngB.longitude;
        //计算除指示方向的点的经纬度
        latlngDirection = new LatLng(((30/distance)*lat+latlngB.latitude),((30/distance)*lng+latlngB.longitude));
        //在地图上画出指示方向的点
        setDirection();
    }

    //获取自定义地图的文件位置，并进行相关设置
    private void setMapCustomStyleFile(Context context) {
        String styleName = "style.data";
        FileOutputStream outputStream = null;
        InputStream inputStream = null;
        String filePath = null;
        try {
            inputStream = context.getAssets().open(styleName);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);

            filePath = context.getFilesDir().getAbsolutePath();
            File file = new File(filePath + "/" + styleName);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            outputStream.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();

                if (outputStream != null)
                    outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        aMap.setCustomMapStylePath(filePath + "/" + styleName);

    }

    //判断是否已经到达目的地
    public boolean judgeTheDistance(double distance) {
        return !(distance > 20) && distance >= 0;
    }
    //显示一个maker，来标识方位
    public void setDirection(){
        if(marker!=null){

        }
        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.sq_br_up))
                .position(latlngDirection)
                .draggable(true);
        marker = aMap.addMarker(markerOption);
    }

}
