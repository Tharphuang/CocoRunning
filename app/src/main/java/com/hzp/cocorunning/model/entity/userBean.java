package com.hzp.cocorunning.model.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by hzp on 2018/4/12.
 */

public class userBean extends BmobUser {
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
