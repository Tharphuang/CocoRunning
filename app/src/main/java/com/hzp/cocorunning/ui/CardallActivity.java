package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzp.cocorunning.MainActivity;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.model.entity.Card;
import com.hzp.cocorunning.util.Constans;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CardallActivity extends AppCompatActivity {
    //private Button btn0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardall);

        //imageDownload iml=new imageDownload();
        //Toast.makeText(CardallActivity.this,String.valueOf(Constans.cardOwn.get(1)),Toast.LENGTH_LONG).show();
    }

    public void skipMe(View view){
        Intent intent = new Intent();
        intent.setClass(CardallActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void skipCardshow(View view){
        Intent intent = new Intent();
        intent.setClass(CardallActivity.this,MaincardActivity.class);
        startActivity(intent);
    }
}
