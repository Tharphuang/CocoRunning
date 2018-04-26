package com.hzp.cocorunning.ui;

import android.annotation.SuppressLint;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.util.Constans;

import com.hzp.cocorunning.R;

public class MissionFinishActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_finish);

        //读数据
        if(getSharedPreferences("cardList",MODE_PRIVATE)==null){
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getSharedPreferences("cardList",MODE_PRIVATE).edit();
            editor.putLong("cards",0);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("cardList",MODE_PRIVATE);
        long cards = sharedPreferences.getLong("cards",0);
        cards++;
        Constans.cardList=cards;
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getSharedPreferences("cardList",MODE_PRIVATE).edit();
        editor.putLong("cards",cards);



        Button  fanhui =findViewById(R.id.back);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
