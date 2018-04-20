package com.hzp.cocorunning.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hzp.cocorunning.R;
import com.hzp.cocorunning.model.entity.userBean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends Activity {

    private Button btn_register;
    private EditText et_name,et_pass,et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register=(Button) findViewById(R.id.btn_register);
        et_name=(EditText) findViewById(R.id.et_name);
        et_pass=(EditText) findViewById(R.id.et_pass);
        et_email=(EditText) findViewById(R.id.et_email);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser bu=new BmobUser();
                bu.setUsername(et_name.getText().toString());
                bu.setPassword(et_pass.getText().toString());
                bu.setEmail(et_email.getText().toString());

                bu.signUp(new SaveListener<userBean>() {
                    @Override
                    public void done(userBean user, BmobException e) {
                        if(e==null){
                            Toast.makeText(RegisterActivity.this,"注册成功,请前往邮箱验证",Toast.LENGTH_LONG).show();
                        }else {
                            //e=202 用户已经存在
                            Log.e("注册失败","原因",e);
                            Toast.makeText(RegisterActivity.this,"注册shibai",Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });
    }
}
