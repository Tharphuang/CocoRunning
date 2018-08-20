package com.hzp.cocorunning.ui.CardPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.ui.CardshowActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class irobot extends AppCompatActivity implements View.OnClickListener{
    View view1;
    View view2;
    View view3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irobot);

        CircleImageView xiehou = findViewById(R.id.circleImageView);
        CircleImageView qiyuan = findViewById(R.id.circleImageView2);

        xiehou.setOnClickListener(this);
        qiyuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.circleImageView:
                startActivity(new Intent(irobot.this, CardshowActivity.class));
                break;
            case R.id.circleImageView2:
                startActivity(new Intent(irobot.this, CardshowActivity.class));
                break;
            default:
                break;
        }
    }
}
