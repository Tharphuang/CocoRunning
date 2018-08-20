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

import com.hzp.cocorunning.IMCase.model.UserModel;
import com.hzp.cocorunning.IMCase.ui.IMmainActivity;
import com.hzp.cocorunning.MainActivity;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.model.entity.Card;
import com.hzp.cocorunning.model.entity.userBean;
import com.hzp.cocorunning.util.Constans;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.newim.BmobIM;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity{
    private Button btn_login;
    private EditText et_lName,et_lPass;
    private Button forgetPassword,regiester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"dcb6f3d496754f2894444be08632e0fa");
        BmobIM.init(this);
        setContentView(R.layout.activity_login);

        btn_login=(Button)findViewById(R.id.login);
        et_lName=(EditText)findViewById(R.id.email);
        et_lPass=(EditText)findViewById(R.id.password);
        regiester=findViewById(R.id.register);
//        tv_register=(TextView)findViewById(R.id.tv_register);

        //卡片下载
        final BmobQuery<Card> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<Card>() {
            @Override
            public void done(List<Card> list, BmobException e) {
                if(e==null){
                    for(int i = 0; i< list.size(); i++){
                        Constans.cardBeans.add(list.get(i));
                    }
                }
            }
        });

//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BmobUser bu=new BmobUser();
//                bu.setUsername(et_lName.getText().toString());
//                bu.setPassword(et_lPass.getText().toString());
//                bu.login(new SaveListener<userBean>(){
//
//                    @Override
//                    public void done(userBean user, BmobException e) {
//                        if(e==null){
//                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
//                            Constans.cardList=user.getCardScore();
//                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                            finish();
//                        }else {
//                            Log.e("登录失败","原因",e);
//                            //e=101 '用户名或密码错误'
//                            //e=9018 '密码不能为空'
//                            //邮箱未验证
//                        }
//
//                    }
//                });
//            }
//        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel.getInstance().login(et_lName.getText().toString(), et_lPass.getText().toString(), new LogInListener() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if(e==null){
                            startActivity(new Intent(LoginActivity.this, IMmainActivity.class));
                            finish();
                        }
                        else {
                            Log.e("登录失败", "done: 原因",e );
                        }
                    }

                    @Override
                    public void done(Object o, Object o2) {

                    }
                });
            }
        });

        regiester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
