package com.hzp.cocorunning.ui.talkUI;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hzp.cocorunning.R;

import java.util.Locale;

public class TalkActivity extends AppCompatActivity {
    private TextToSpeech tts;
    private Button btn_speak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        tts=new TextToSpeech(this,new MyOnInitialListener());
        btn_speak=findViewById(R.id.btu_Speak);
        btn_speak.setOnClickListener(new MyOnClickListener());
    }

    class MyOnInitialListener implements TextToSpeech.OnInitListener {

        @Override
        public void onInit(int status) {
            // tts.setEngineByPackageName("com.iflytek.vflynote");
            //tts.setLanguage(Locale.CHINESE);
            if(status==TextToSpeech.SUCCESS){
                int result=tts.setLanguage(Locale.CHINA);
            }
        }
    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btu_Speak:
                    tts.speak("hello,my name is Dean.Ts!nice to meet you!", TextToSpeech.QUEUE_ADD, null);
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) { // 关闭TTS引擎
            tts.shutdown();
        }
    }





}
