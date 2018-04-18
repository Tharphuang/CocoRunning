package com.hzp.cocorunning.model.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by hzp on 2018/4/15.
 */

public class Card extends BmobObject {
    private int cardID;
    private String cardStory;
    private BmobFile cardFile;

    public Card(int cardID){
        //this.setTableName("Card");
        this.cardID=cardID;
        //this.cardStory=cardStory;
        //this.cardFile=cardFile;
    }

    public int getCardID() {
        return cardID;
    }

    public String getCardStory() {
        return cardStory;
    }

    public String getCardFileUrl() {
        return cardFile.getUrl();
    }

}
