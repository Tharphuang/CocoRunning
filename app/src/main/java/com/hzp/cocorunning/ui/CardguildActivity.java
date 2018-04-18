package com.hzp.cocorunning.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.util.Constans;

import java.util.ArrayList;
import java.util.List;

public class CardguildActivity extends AppCompatActivity {
    private List<String> imageUrl;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardguild);

        imageUrl=new ArrayList<>();
        for(int i=0;i<Constans.cardBeans.size();i++){
            imageUrl.add(Constans.cardBeans.get(i).getCardFileUrl());
        }

        gridView=(GridView)findViewById(R.id.gvImages);

        //设置适配器
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return imageUrl.size();
            }

            @Override
            public Object getItem(int position) {
                return imageUrl.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView=new ImageView(CardguildActivity.this);
                Glide.with(CardguildActivity.this).load(imageUrl.get(position)).into(imageView);
                return imageView;
            }
        });
    }
}
