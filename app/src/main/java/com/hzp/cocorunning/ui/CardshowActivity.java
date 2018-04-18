package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hzp.cocorunning.R;

public class CardshowActivity extends AppCompatActivity {

   // private CardshowActivity imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cradshow);


    }

    public void skipCardAll(View view){
        Intent intent = new Intent();
        intent.setClass(CardshowActivity.this,CardallActivity.class);
        startActivity(intent);
    }
}
