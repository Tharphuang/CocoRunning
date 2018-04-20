package com.hzp.cocorunning.model.entity;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

/**
 * Created by hzp on 2018/4/12.
 */

public class userBean extends BmobUser {
    private String nick;
    private List<Boolean> cardOwn=new ArrayList<Boolean>();

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<Boolean> getCardOwn() {
        return cardOwn;
    }

    public void setCardOwn(List<Boolean> cardOwn) {
        this.cardOwn = cardOwn;
    }
}
