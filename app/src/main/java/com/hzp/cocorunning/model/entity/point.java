package com.hzp.cocorunning.model.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobPointer;

/**
 * Created by hzp on 2018/4/22.
 */

public class point extends BmobObject {

    private int pointID;
    private BmobGeoPoint longitude;

    public int getPointID() {
        return pointID;
    }

    public void setPointID(int pointId) {
        this.pointID = pointId;
    }


    public BmobGeoPoint getLongitude() {
        return longitude;
    }

    public void setLongitude(double l,double a) {
        BmobGeoPoint point=new BmobGeoPoint(l,a);
        this.longitude = point;
    }
}
