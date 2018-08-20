package com.hzp.cocorunning.ui;

import android.annotation.SuppressLint;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.util.Constans;

import cn.bmob.sms.exception.BmobException;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class MissionFinishActivity extends AppCompatActivity {

    private ImageView cardshowbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_finish);

        cardshowbk=findViewById(R.id.cardshowbk_finish);

//        Glide.with(this).load(Constans.cardBeans.get(Constans.cardList).getCardFileUrl()).into(cardshowbk);
//        Constans.cardList++;
//        if(Constans.cardList>=9){
//            Constans.cardList=9;
//        }

//        BmobUser bmobUser = BmobUser.getCurrentUser();
//        bmobUser.setValue("cardScore", Constans.cardList);
//        bmobUser.update(new UpdateListener() {
//            @Override
//            public void done(cn.bmob.v3.exception.BmobException e) {
//                if(e==null){
//                    Toast.makeText(MissionFinishActivity.this,"数据上传成功",Toast.LENGTH_LONG).show();
//                }
//            }
//        });








    }
}
