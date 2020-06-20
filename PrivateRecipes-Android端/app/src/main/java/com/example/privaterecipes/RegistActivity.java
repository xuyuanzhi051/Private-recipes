package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Button btn_regist2;
    private Button btn_login2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        //获取控件对象
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btn_regist2=findViewById(R.id.btn_regist2);
        btn_login2=findViewById(R.id.btn_login2);
        //为注册按钮设置点击事件
        btn_regist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动异步任务类
                MyAsyncTask myAsyncTask=new MyAsyncTask();
                myAsyncTask.execute(ConfigUtil.URL+"RegistServlet");
            }
        });
        //为返回登录按钮注册点击事件
        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到登录界面
                Intent intent=new Intent();
                intent.setClass(RegistActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * 创建异步任务类
     */
    class MyAsyncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            Log.e("参数",objects[0].toString());
            try {
                String str=et_username.getText().toString()+","+et_password.getText().toString();
                URL url=new URL(objects[0].toString());
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                OutputStream out=urlConnection.getOutputStream();
                out.write(str.getBytes());
                Log.e("str",str);
                InputStream in=urlConnection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(in,"utf-8"));
                String response=reader.readLine();
                Log.e("response",response);
                out.close();
                in.close();
               if(response.equals("注册成功")){
                   publishProgress("1");//执行onProgreddUpdate方法，参数为1表示注册成功
               }else if(response.equals("注册失败")){
                   publishProgress("-1");//执行onProgreddUpdate方法，参数为-1表示注册失败
               }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
          String flag=values[0].toString();
          if(flag.equals("1")){//注册成功
              Toast.makeText(RegistActivity.this,"用户注册成功",Toast.LENGTH_SHORT).show();
          }else if(flag.equals("-1")){//注册失败
              Toast.makeText(RegistActivity.this,"用户注册失败",Toast.LENGTH_SHORT).show();
          }
        }
    }
}
