package com.hzp.cocorunning.presenter;

import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.View;

import java.util.List;

/**
 * Created by hzp on 2018/4/18.
 */

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
