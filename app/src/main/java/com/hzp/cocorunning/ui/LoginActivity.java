package com.hzp.cocorunning.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.model.entity.userBean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity{
    private Button btn_login;
    private EditText et_lName,et_lPass;
    private TextView tv_etpass,tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
