package com.hzp.cocorunning.ui.FinishPackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.util.Constans;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class MissionFinishActivity extends AppCompatActivity {

    private ImageView cardshowbk;
    private String juqing_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_finish);

//        cardshowbk=findViewById(R.id.cardshowbk_finish);
//
//        Glide.with(this).load(Constans.cardBeans.get(Constans.cardList).getCardFileUrl()).into(cardshowbk);
//        Constans.cardList++;
//        if(Constans.cardList>=9){
//            Constans.cardList=9;
//        }

        juqing_name = "邂逅";

        Toast.makeText(MissionFinishActivity.this,"\n剧情"+"\""+juqing_name+"\""+"已解锁",Toast.LENGTH_LONG).show();
//        BmobUser bmobUser = BmobUser.getCurrentUser();
//        bmobUser.setValue("cardScore", Constans.cardList);
//        bmobUser.update(new UpdateListener() {
//            @Override
//            public void done(cn.bmob.v3.exception.BmobException e) {
//                if(e==null){
//                    Toast.makeText(MissionFinishActivity.this,"剧情"+juqing_name+"已解锁",Toast.LENGTH_LONG).show();
//                }
//            }
//    });


        //加载一张图的动画
        CardView card = findViewById(R.id.constraintLayout1_finish);
        ObjectAnimator animator = ObjectAnimator.ofFloat(card,"scaleX",0f,1f,0f,-1f,0f,1f,1f,1f,1f,1f,1f,1f,1f);
        animator.setDuration(8000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                startActivity(new Intent(MissionFinishActivity.this,MissionFinishStory0.class));
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


    }
}
