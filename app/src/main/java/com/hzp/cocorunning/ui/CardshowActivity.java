package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.ui.FinishPackage.MissionFinishStory0;
import com.hzp.cocorunning.ui.unityActivities.UnityPlayerActivity;

public class CardshowActivity extends AppCompatActivity implements View.OnClickListener {

    // private CardshowActivity imageView;
//    private TextView cardshowtv1;
//    private TextView cardshowtv2;
//    private ImageView cardshowbk;
//    ConstraintLayout constraintLayout1 =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cradshow);


        ImageView ar_button = findViewById(R.id.ar_button);
        ImageView memory_button = findViewById(R.id.memory_button);

        ar_button.setOnClickListener(this);
        memory_button.setOnClickListener(this);

//        cardshowtv1=findViewById(R.id.cardShowTV1);
//        cardshowtv2=findViewById(R.id.cardShowTV2);
//        cardshowbk=findViewById(R.id.cardshowbk);
//        constraintLayout1 = findViewById(R.id.constraintLayout1);


//        if(Constans.CardSelect>Constans.cardList){
////            ImageView imageView = (ImageView)findViewById(R.id.cardshowbk);
////            imageView.setImageResource(R.drawable.liuhan);
//            cardshowtv2.setText("暂未获得该卡片");
//        }
//        else {
////            cardshowtv1.setText(Constans.cardBeans.get(Constans.CardSelect).getCardLevel());
//            cardshowtv2.setText(Constans.cardBeans.get(Constans.CardSelect).getCardStory());
//            Glide.with(this).load(Constans.cardBeans.get(Constans.CardSelect).getCardFileUrl()).into(cardshowbk);
//        }

//        switch (Constans.CardSelect){
//            case 101:
//                if(Constans.cardList<1)
//                cardshowtv1.setText(Constans.cardBeans.get(0).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(0).getCardStory());
//                Glide.with(this).load(Constans.cardBeans.get(0).getCardFileUrl()).into(cardshowbk);
//                break;
//            case 102:
//                cardshowtv1.setText(Constans.cardBeans.get(1).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(1).getCardStory());
//                Glide.with(this).load(Constans.cardBeans.get(1).getCardFileUrl()).into(cardshowbk);
//                break;
//            case 103:
//                cardshowtv1.setText(Constans.cardBeans.get(2).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(2).getCardStory());
//                break;
//            case 201:
//                cardshowtv1.setText(Constans.cardBeans.get(3).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(3).getCardStory());
//                break;
//            case 202:
//                cardshowtv1.setText(Constans.cardBeans.get(4).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(4).getCardStory());
//                break;
//            case 203:
//                cardshowtv1.setText(Constans.cardBeans.get(5).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(5).getCardStory());
//                break;
//            case 204:
//                cardshowtv1.setText(Constans.cardBeans.get(6).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(6).getCardStory());
//                break;
//            case 205:
//                cardshowtv1.setText(Constans.cardBeans.get(7).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(7).getCardStory());
//                break;
//            case 206:
//                cardshowtv1.setText(Constans.cardBeans.get(8).getCardLevel());
//                cardshowtv2.setText(Constans.cardBeans.get(8).getCardStory());
//                break;
//            default:
//                break;
//        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ar_button:
                startActivity(new Intent(CardshowActivity.this, UnityPlayerActivity.class));
                break;
            case R.id.memory_button:
                startActivity(new Intent(CardshowActivity.this, MissionFinishStory0.class));
                break;
            default:
                break;
        }
    }
}
