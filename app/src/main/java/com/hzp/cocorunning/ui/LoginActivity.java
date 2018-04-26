package com.hzp.cocorunning.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hzp.cocorunning.MainActivity;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.configBase.pointCreat;
import com.hzp.cocorunning.model.entity.Card;
import com.hzp.cocorunning.model.entity.point;
import com.hzp.cocorunning.model.entity.userBean;
import com.hzp.cocorunning.util.Constans;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity{
    private Button btn_login;
    private EditText et_lName,et_lPass;
    private TextView tv_etpass,tv_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"dcb6f3d496754f2894444be08632e0fa");
        setContentView(R.layout.activity_login);


        /**
         * 初次创建程序时 永远初始化目标点的坐标
         * */
        //pointCreat pc=new pointCreat();
        //pc.initPointCreat();

        //初始化地点列表
        //读数据
        if(getSharedPreferences("cardList",MODE_PRIVATE)==null){
            SharedPreferences.Editor editor = getSharedPreferences("positionList",MODE_PRIVATE).edit();
            editor.putFloat("latitude1", (float) 39.960395);
            editor.putFloat("longitude1",(float) 116.356351);

            editor.putFloat("latitude2", (float) 39.962099);
            editor.putFloat("longitude2",(float) 116.358003);

            editor.putFloat("latitude3", (float) 39.961966);
            editor.putFloat("longitude3",(float) 116.360766);

            editor.putFloat("latitude4", (float) 39.962373);
            editor.putFloat("longitude4",(float) 116.357399);

            editor.putFloat("latitude5", (float) 39.961249);
            editor.putFloat("longitude5",(float) 116.358091);

            editor.putInt("rank" ,0);
        }


        btn_login=(Button)findViewById(R.id.btn_login);
        et_lName=(EditText)findViewById(R.id.et_lName);
        et_lPass=(EditText)findViewById(R.id.et_lPass);
        tv_etpass=(TextView)findViewById(R.id.tv_etpass);
        tv_register=(TextView)findViewById(R.id.tv_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser bu=new BmobUser();
                bu.setUsername(et_lName.getText().toString());
                bu.setPassword(et_lPass.getText().toString());
                bu.login(new SaveListener<userBean>(){

                    @Override
                    public void done(userBean user, BmobException e) {
                        if(e==null){
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }else {
                            Log.e("登录失败","原因",e);
                            //e=101 '用户名或密码错误'
                            //e=9018 '密码不能为空'
                            //邮箱未验证
                        }

                    }
                });
            }
        });

        //card类的下载
        final BmobQuery<Card> bmobQuery = new BmobQuery<Card>();
        bmobQuery.findObjects(new FindListener<Card>() {
            @Override
            public void done(List<Card> list, BmobException e) {
                if(e==null){
                    for(int i = 0; i<list.size(); i++){
                        Constans.cardBeans.add(list.get(i));
                    }
                    // Toast.makeText(LoginActivity.this,"查询成功"+ Constans.cardBeans.get(1).getCardStory(),Toast.LENGTH_LONG).show();
                }
            }
        });


        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
