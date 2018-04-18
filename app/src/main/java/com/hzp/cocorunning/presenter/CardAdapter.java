package com.hzp.cocorunning.presenter;

import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by hzp on 2018/4/18.
 */

public class CardAdapter extends PagerAdapter {
    private Fragment mContext;
    private List<String> mList;
    //private List<PhotoView>

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
