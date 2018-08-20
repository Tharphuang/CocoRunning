package com.hzp.cocorunning.ui.CardPages;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.ui.CardshowActivity;
import com.hzp.cocorunning.util.Constans;

public class baiyang extends AppCompatActivity implements View.OnClickListener {
    View view1;
    View view2;
    View view3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baiyang);

        view1 = findViewById(R.id.view101);
        view2 = findViewById(R.id.view102);
        view3 = findViewById(R.id.view103);

        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view101:
                Constans.CardSelect = 0;
                startActivity(new Intent(baiyang.this, CardshowActivity.class));
                break;
            case R.id.view102:
                Constans.CardSelect = 1;
                startActivity(new Intent(baiyang.this, CardshowActivity.class));
                break;
            case R.id.view103:
                Constans.CardSelect = 2;
                startActivity(new Intent(baiyang.this, CardshowActivity.class));
                break;
            default:
                break;
        }
    }
}
