package com.hzp.cocorunning.configBase;

import android.util.Log;
import android.widget.Toast;

import com.hzp.cocorunning.model.entity.point;
import com.hzp.cocorunning.ui.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListListener;

/**
 * Created by hzp on 2018/4/22.
 */

public class pointCreat {
    public  void initPointCreat(){
        //批量添加点
        double[] l={116.356351,116.358003,116.360766,116.357399,116.358091};
        double[] a={39.960395,39.962099,39.961966,39.962373,39.961249};

        List<BmobObject> pointsList= new ArrayList<BmobObject>();
        for(int i=0;i<5;i++){
            point points=new point();
            points.setPointID(i+1);
            points.setLongitude(l[i],a[i]);
            pointsList.add(points);
        }
        new BmobBatch().insertBatch(pointsList).doBatch(new QueryListListener<BatchResult>() {
            @Override
            public void done(List<BatchResult> list, BmobException e) {
                if(e==null){
                    Log.i("添加点","SUCCESS");
                }
            }
        });
    }
}
