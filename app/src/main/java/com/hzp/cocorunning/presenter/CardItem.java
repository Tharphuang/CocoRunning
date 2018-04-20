package com.hzp.cocorunning.presenter;

/**
 * Created by hzp on 2018/4/18.
 */

public class CardItem {
    private String mTextResource;
    private String mTitleResource;

    public CardItem(String title, String text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public String getText() {
        return mTextResource;
    }

    public String getTitle() {
        return mTitleResource;
    }

}
