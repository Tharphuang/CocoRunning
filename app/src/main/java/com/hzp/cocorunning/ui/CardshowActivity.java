package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.util.Constans;

public class CardshowActivity extends AppCompatActivity {

   // private CardshowActivity imageView;
    private TextView cardshowtv1;
    private TextView cardshowtv2;
    private ImageView cardshowbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cradshow);

        cardshowtv1=findViewById(R.id.cardShowTV1);
        cardshowtv2=findViewById(R.id.cardShowTV2);
        cardshowbk=findViewById(R.id.cardshowbk);


        switch (Constans.CardSelect){
            case 101:
                cardshowtv1.setText(Constans.cardBeans.get(0).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(0).getCardStory());
                Glide.with(this).load(Constans.cardBeans.get(0).getCardFileUrl()).into(cardshowbk);

                break;
            case 102:
                cardshowtv1.setText(Constans.cardBeans.get(1).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(1).getCardStory());
                break;
            case 103:
                cardshowtv1.setText(Constans.cardBeans.get(2).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(2).getCardStory());
                break;
            case 201:
                cardshowtv1.setText(Constans.cardBeans.get(3).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(3).getCardStory());
                break;
            case 202:
                cardshowtv1.setText(Constans.cardBeans.get(4).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(4).getCardStory());
                break;
            case 203:
                cardshowtv1.setText(Constans.cardBeans.get(5).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(5).getCardStory());
                break;
            case 204:
                cardshowtv1.setText(Constans.cardBeans.get(6).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(6).getCardStory());
                break;
            case 205:
                cardshowtv1.setText(Constans.cardBeans.get(7).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(7).getCardStory());
                break;
            case 206:
                cardshowtv1.setText(Constans.cardBeans.get(8).getCardLevel());
                cardshowtv2.setText(Constans.cardBeans.get(8).getCardStory());
                break;
            default:
                break;
        }
        //card_title = findViewById(R.id.card_title);

       // card_title.setText("卡片编号："+Constans.CardSelect);

    }

    public void skipCardAll(View view){
        Intent intent = new Intent();
        intent.setClass(CardshowActivity.this,AllCardActivity.class);
        startActivity(intent);
    }
}
