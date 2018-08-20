package com.hzp.cocorunning.ui.FinishPackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hzp.cocorunning.R;

public class MissionFinishStory1 extends AppCompatActivity {

    ObjectAnimator animator;
    boolean is_canceled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_finish_story1);

        ConstraintLayout story1 = findViewById(R.id.constraintLayout1_story1);
        animator = ObjectAnimator.ofFloat(story1,"alpha",0.6f,1.0f,0.0f);
        animator.setDuration(8000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(!is_canceled){
                    startActivity(new Intent(MissionFinishStory1.this,MissionFinishStory2.class));

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


        TextView skip = findViewById(R.id.skip1);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_canceled = true;
                animator.cancel();
                Toast.makeText(MissionFinishStory1.this,"新的目标点已生成，请在地图中查看",Toast.LENGTH_LONG).show();

            }
        });
    }
}
