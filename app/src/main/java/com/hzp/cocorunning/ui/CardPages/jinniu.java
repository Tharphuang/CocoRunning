package com.hzp.cocorunning.ui.CardPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.ui.CardshowActivity;
import com.hzp.cocorunning.util.Constans;

public class jinniu extends AppCompatActivity implements View.OnClickListener {

    View view1;
    View view2;
    View view3;
    View view4;
    View view5;
    View view6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinniu);

        view1 = findViewById(R.id.view201);
        view2 = findViewById(R.id.view202);
        view3 = findViewById(R.id.view203);
        view4 = findViewById(R.id.view204);
        view5 = findViewById(R.id.view205);
        view6 = findViewById(R.id.view206);

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
            case R.id.view201:
                Constans.CardSelect = 3;
                startActivity(new Intent(jinniu.this, CardshowActivity.class));
                break;
            case R.id.view202:
                Constans.CardSelect = 4;
                startActivity(new Intent(jinniu.this, CardshowActivity.class));
                break;
            case R.id.view203:
                Constans.CardSelect = 5;
                startActivity(new Intent(jinniu.this, CardshowActivity.class));
                break;
            case R.id.view204:
                Constans.CardSelect = 6;
                startActivity(new Intent(jinniu.this, CardshowActivity.class));
                break;
            case R.id.view205:
                Constans.CardSelect = 7;
                startActivity(new Intent(jinniu.this, CardshowActivity.class));
                break;
            case R.id.view206:
                Constans.CardSelect = 8;
                startActivity(new Intent(jinniu.this, CardshowActivity.class));
                break;
            default:
                break;
        }
    }
}
