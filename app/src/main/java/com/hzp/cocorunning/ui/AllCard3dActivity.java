package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.ui.CardPages.irobot;

public class AllCard3dActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_card3d);


        TextView enter = findViewById(R.id.enter_chapter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCard3dActivity.this,irobot.class));
            }
        });
    }
}
