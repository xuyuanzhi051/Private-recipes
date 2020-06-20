package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        //为登录按钮设置点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入信息
                String userName=username.getText().toString();
                String passWord=password.getText().toString();
                String url="?username="+userName+"&password="+passWord;
                MyAsyncTask myAsyncTask=new MyAsyncTask();
                myAsyncTask.execute(ConfigUtil.URL+"LoginServlet"+url);
            }
        });
        //为注册按钮设置点击事件,点击注册按钮跳转到用户注册界面
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(MainActivity.this,RegistActivity.class);
                startActivity(intent);
            }
        });
    }
    //获取控件对象
    private void getViews() {
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.btn_login);
        regist=findViewById(R.id.btn_regist1);
    }

    //为登录按钮设置异步任务类
    class MyAsyncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            String s=objects[0].toString();
            try {
                URL url=new URL(s);
                Log.e("url:",s);
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                InputStream in=urlConnection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader((in)));

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                if(response.toString().equals("1")){
                    Log.e("1","登录成功");
                    publishProgress("1");//登录成功
                }else{
                    if(response.toString().equals("-1")){
                        Log.e("2","登录失败");
                        publishProgress("-1");//登录失败
                    }
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
            //接收异步任务传递的参数
            String flag=values[0].toString();
            if(flag.equals("1")){//表示登录成功
                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                //登录成功后跳转到程序主界面
                Intent intent=new Intent();
                intent.putExtra("usertel",username.getText().toString());
                intent.setClass(MainActivity.this,MainFragmentActivity.class);
                startActivity(intent);
            }else if(flag.equals("-1")){
                Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
