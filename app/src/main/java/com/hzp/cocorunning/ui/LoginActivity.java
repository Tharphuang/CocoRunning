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
import android.widget.Toast;

import com.hzp.cocorunning.MainActivity;
import com.hzp.cocorunning.R;
import com.hzp.cocorunning.base.BaseActivity;
import com.hzp.cocorunning.bean.User;
import com.hzp.cocorunning.model.UserModel;
import com.hzp.cocorunning.model.entity.Card;
import com.hzp.cocorunning.model.entity.userBean;
import com.hzp.cocorunning.presenter.messageP.MyMessageHandler;
import com.hzp.cocorunning.ui.imUI.IMActivity;
import com.hzp.cocorunning.util.Constans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.newim.BmobIM;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity{
    private EditText et_lName,et_lPass;
    private Button forgetPassword,regiester;
    private Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bmob后端云初始化
        Bmob.initialize(this,"dcb6f3d496754f2894444be08632e0fa");
        BmobIM.init(this);
        //Leancould后端云初始化
        //AVOSCloud.initialize(this,"v0fpi7In2SGCBq94vNfGdkVo-gzGzoHsz","M4EKExiR9WdKJTOEikrjXRjC");



        setContentView(R.layout.activity_login);

        btn_login=(Button)findViewById(R.id.btn_login);
        et_lName=(EditText)findViewById(R.id.etname);
        et_lPass=(EditText)findViewById(R.id.password);
        regiester=findViewById(R.id.register);





        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                UserModel.getInstance().login(et_lName.getText().toString(), et_lPass.getText().toString(), new LogInListener() {

                    @Override
                    public void done(Object o, BmobException e) {
                        if (e == null) {
                            //登录成功
                            //startActivity(MainActivity.class, null, true);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {
                            toast(e.getMessage() + "(" + e.getErrorCode() + ")");
                        }
                    }
                });
            }
        });


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



    }

//    @OnClick(R.id.btn_login)
//    public void onLoginClick(View view) {
//
//        UserModel.getInstance().login(et_username.getText().toString(), et_password.getText().toString(), new LogInListener() {
//
//            @Override
//            public void done(Object o, BmobException e) {
//                if (e == null) {
//                    //登录成功
//                    startActivity(MainActivity.class, null, true);
//                } else {
//                    toast(e.getMessage() + "(" + e.getErrorCode() + ")");
//                }
//            }
//        });
//
//        BmobUser user = new BmobUser();
//        user.setUsername(et_username.getText());
//        user.setPassword(password);
//        user.login(new SaveListener<BmobUser>() {
//            @Override
//            public void done(BmobUser user, BmobException e) {
//                if (e == null) {
//                    listener.done(getCurrentUser(), null);
//                } else {
//                    listener.done(user, e);
//                }
//            }
//        });
//    }




}

