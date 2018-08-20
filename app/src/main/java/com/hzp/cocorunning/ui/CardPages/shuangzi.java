package com.hzp.cocorunning.ui.CardPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.ui.CardshowActivity;

public class shuangzi extends AppCompatActivity implements View.OnClickListener {

    View view1;
    View view2;
    View view3;
    View view4;
    View view5;
    View view6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuangzi);

        view1 = findViewById(R.id.view301);
        view2 = findViewById(R.id.view302);
        view3 = findViewById(R.id.view303);
        view4 = findViewById(R.id.view304);
        view5 = findViewById(R.id.view305);
        view6 = findViewById(R.id.view306);

        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view301:
                startActivity(new Intent(shuangzi.this, CardshowActivity.class));
                break;
            case R.id.view302:
                startActivity(new Intent(shuangzi.this, CardshowActivity.class));
                break;
            case R.id.view303:
                startActivity(new Intent(shuangzi.this, CardshowActivity.class));
                break;
            case R.id.view304:
                startActivity(new Intent(shuangzi.this, CardshowActivity.class));
                break;
            case R.id.view305:
                startActivity(new Intent(shuangzi.this, CardshowActivity.class));
                break;
            case R.id.view306:
                startActivity(new Intent(shuangzi.this, CardshowActivity.class));
                break;
            default:
                break;
        }
    }
}
