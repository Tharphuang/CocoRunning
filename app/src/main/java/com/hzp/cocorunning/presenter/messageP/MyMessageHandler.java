package com.hzp.cocorunning.presenter.messageP;

import cn.bmob.newim.event.MessageEvent;
import cn.bmob.newim.event.OfflineMessageEvent;
import cn.bmob.newim.listener.BmobIMMessageHandler;

/**
 * Created by hzp on 2018/7/7.
 */

public class MyMessageHandler extends BmobIMMessageHandler {
    @Override
    public void onMessageReceive(final MessageEvent messageEvent) {
        //在线消息
        //super.onMessageReceive(messageEvent);
    }

    @Override
    public void onOfflineReceive(final OfflineMessageEvent offlineMessageEvent) {
        //离线消息，每次登录时加载离线消息
       // super.onOfflineReceive(offlineMessageEvent);
    }
}
