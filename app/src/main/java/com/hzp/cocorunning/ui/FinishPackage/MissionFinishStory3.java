package com.hzp.cocorunning.ui.FinishPackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzp.cocorunning.R;

public class MissionFinishStory3 extends AppCompatActivity {

    ObjectAnimator animator;
    boolean is_canceled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_finish_story3);

        LinearLayout story3 = findViewById(R.id.layout_story3);
        animator = ObjectAnimator.ofFloat(story3,"alpha",0f,1.0f,1.0f,1f,1f,0f);
        animator.setDuration(10000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(!is_canceled){
                    startActivity(new Intent(MissionFinishStory3.this,MissionFinishStory4.class));

                }
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();


        TextView skip = findViewById(R.id.skip3);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_canceled = true;
                animator.cancel();
                Toast.makeText(MissionFinishStory3.this,"新的目标点已生成，请在地图中查看",Toast.LENGTH_LONG).show();

            }
        });
    }
}
