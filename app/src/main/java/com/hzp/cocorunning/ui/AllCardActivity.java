package com.hzp.cocorunning.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.presenter.BitWheelInfo;
import com.hzp.cocorunning.ui.CardPages.baiyang;
import com.hzp.cocorunning.ui.CardPages.chunv;
import com.hzp.cocorunning.ui.CardPages.jinniu;
import com.hzp.cocorunning.ui.CardPages.juxie;
import com.hzp.cocorunning.ui.CardPages.mojie;
import com.hzp.cocorunning.ui.CardPages.sheshou;
import com.hzp.cocorunning.ui.CardPages.shizi;
import com.hzp.cocorunning.ui.CardPages.shuangyu;
import com.hzp.cocorunning.ui.CardPages.shuangzi;
import com.hzp.cocorunning.ui.CardPages.shuiping;
import com.hzp.cocorunning.ui.CardPages.tianping;
import com.hzp.cocorunning.ui.CardPages.tianxie;
import com.hzp.cocorunning.util.BitView;
import com.hzp.cocorunning.util.Constans;

import java.util.ArrayList;
import java.util.List;

public class AllCardActivity extends AppCompatActivity implements View.OnClickListener {

    private List<BitWheelInfo> infos = new ArrayList<>();

    private TextView tvInfo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_card);

        getBitWheelInfos();
        BitView mBitView = findViewById(R.id.bitview);
        mBitView.setBitInfos(infos);
        mBitView.setOnWheelCheckListener(new BitView.OnWheelCheckListener() {
            @Override
            public void onCheck(int position) {
                switch (infos.get(position).text){
                    case "baiyang":
                        startActivity(new Intent(AllCardActivity.this,baiyang.class));
                        break;
                    case "jinniu":
                        startActivity(new Intent(AllCardActivity.this,jinniu.class));
                        break;
                    case "shuangzi":
                        startActivity(new Intent(AllCardActivity.this,shuangzi.class));
                        break;
                    case "juxie":
                        startActivity(new Intent(AllCardActivity.this,juxie.class));
                        break;
                    case "shizi":
                        startActivity(new Intent(AllCardActivity.this,shizi.class));
                        break;
                    case "chunv":
                        startActivity(new Intent(AllCardActivity.this,chunv.class));
                        break;
                    case "tianping":
                        startActivity(new Intent(AllCardActivity.this,tianping.class));
                        break;
                    case "tianxie":
                        startActivity(new Intent(AllCardActivity.this,tianxie.class));
                        break;
                    case "sheshou":
                        startActivity(new Intent(AllCardActivity.this,sheshou.class));
                        break;
                    case "mojie":
                        startActivity(new Intent(AllCardActivity.this,mojie.class));
                        break;
                    case "shuiping":
                        startActivity(new Intent(AllCardActivity.this,shuiping.class));
                        break;
                    case "shuangyu":
                        startActivity(new Intent(AllCardActivity.this,shuangyu.class));
                        break;
                    default:
                        break;
                }
            }
        });

        //返回键
        findViewById(R.id.fanhui).setOnClickListener(this);
    }

    //转盘显示的信息
    public void getBitWheelInfos() {

        infos.add(new BitWheelInfo( "baiyang",BitmapFactory.decodeResource(getResources(), R.mipmap.baiyang)));
        infos.add(new BitWheelInfo( "jinniu",BitmapFactory.decodeResource(getResources(), R.mipmap.jinniu)));
        infos.add(new BitWheelInfo( "shuangzi",BitmapFactory.decodeResource(getResources(), R.mipmap.shuangzi)));
        infos.add(new BitWheelInfo( "juxie",BitmapFactory.decodeResource(getResources(), R.mipmap.juxie)));
        infos.add(new BitWheelInfo( "shizi",BitmapFactory.decodeResource(getResources(), R.mipmap.shizi)));
        infos.add(new BitWheelInfo( "chunv",BitmapFactory.decodeResource(getResources(), R.mipmap.chunv)));
        infos.add(new BitWheelInfo( "tianping",BitmapFactory.decodeResource(getResources(), R.mipmap.tianping)));
        infos.add(new BitWheelInfo( "tianxie",BitmapFactory.decodeResource(getResources(), R.mipmap.tianxie)));
        infos.add(new BitWheelInfo( "sheshou",BitmapFactory.decodeResource(getResources(), R.mipmap.sheshou)));
        infos.add(new BitWheelInfo( "mojie",BitmapFactory.decodeResource(getResources(), R.mipmap.mojie)));
        infos.add(new BitWheelInfo( "shuiping",BitmapFactory.decodeResource(getResources(), R.mipmap.shuiping)));
        infos.add(new BitWheelInfo( "shuangyu",BitmapFactory.decodeResource(getResources(), R.mipmap.shuangyu)));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            default:
                break;
        }
    }
}
