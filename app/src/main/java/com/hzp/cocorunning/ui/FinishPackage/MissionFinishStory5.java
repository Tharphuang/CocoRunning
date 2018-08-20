package com.hzp.cocorunning.ui.FinishPackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.hzp.cocorunning.R;

public class MissionFinishStory5 extends AppCompatActivity implements Animator.AnimatorListener {

    ObjectAnimator animator;
    boolean is_canceled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_finish_story);



        ConstraintLayout story_chapter = findViewById(R.id.layout_story_chapter);
        animator = ObjectAnimator.ofFloat(story_chapter,"alpha",1.0f,1.0f,1.0f,1f,1f,1f,0.8f,0.6f,0.4f,0.2f,0f);
        animator.setDuration(10000);
        animator.addListener(this);


        animator.start();


        TextView skip = findViewById(R.id.skip5);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_canceled = true;
                animator.cancel();
                Toast.makeText(MissionFinishStory5.this,"新的目标点已生成，请在地图中查看",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {
        if(!is_canceled){
            Toast.makeText(MissionFinishStory5.this,"新的目标点已生成，请在地图中查看",Toast.LENGTH_LONG).show();

        }
        finish();
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
