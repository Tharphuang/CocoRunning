package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.util.Constans;

public class CardshowActivity extends AppCompatActivity {

   // private CardshowActivity imageView;
    TextView card_title = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cradshow);
        card_title = findViewById(R.id.card_title);

        card_title.setText("卡片编号："+Constans.CardSelect);

    }

    public void skipCardAll(View view){
        Intent intent = new Intent();
        intent.setClass(CardshowActivity.this,AllCardActivity.class);
        startActivity(intent);
    }
}
