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

        Glide.with(this).load(Constans.cardBeans.get((int)Constans.cardList).getCardFileUrl()).into(cardshowbk);
        Constans.cardList++;
        if(Constans.cardList>=9){
            Constans.cardList=9;
        }

        BmobUser bmobUser = BmobUser.getCurrentUser();
        bmobUser.setValue("cardScore", Constans.cardList);
        bmobUser.update(new UpdateListener() {
            @Override
            public void done(cn.bmob.v3.exception.BmobException e) {
                if(e==null){
                    Toast.makeText(MissionFinishActivity.this,"数据上传成功",Toast.LENGTH_LONG).show();
                }
            }
        });


        //写数据

//        //读数据
//        if(getSharedPreferences("cardList",MODE_PRIVATE)==null){
//            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getSharedPreferences("cardList",MODE_PRIVATE).edit();
//            editor.putLong("cards",0);
//        }
//
//        SharedPreferences sharedPreferences = getSharedPreferences("cardList",MODE_PRIVATE);
//        long cards = sharedPreferences.getLong("cards",0);
//        cards++;
//        Constans.cardList=cards;
//        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getSharedPreferences("cardList",MODE_PRIVATE).edit();
//        editor.putLong("cards",cards);



        View  fanhui =findViewById(R.id.back);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
