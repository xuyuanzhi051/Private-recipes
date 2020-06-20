package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchMenuActivity extends AppCompatActivity {
    private ImageView searchMenuImg;
    private TextView searchMenuName;
    private TextView searchMenuType;
    private Button btnSearchDetails;
    private TextView searchMenuNumber;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_menu);
        //获取对应图片控件
        getViews();
        //根据菜谱名称查询菜谱
        Intent intent=getIntent();
        String menuName=intent.getStringExtra("menuName");
        SearchMenuByMenuName searchMenuByMenuName=new SearchMenuByMenuName();
        searchMenuByMenuName.execute(menuName);
    }

    /**
     * 获取对应图片控件
     */
    private void getViews() {
        searchMenuImg=findViewById(R.id.search_menuImg);
        searchMenuName=findViewById(R.id.search_menuName);
        searchMenuType=findViewById(R.id.search_menuType);
        searchMenuNumber=findViewById(R.id.search_menuNumber);
    }

    /**
     * 根据菜谱名称查询菜谱
     */
    class SearchMenuByMenuName extends AsyncTask{

        @SuppressLint("WrongThread")
        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                String menuName=objects[0].toString();
                URL url=new URL(ConfigUtil.URL+"SearchMenuListByMenuName");
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                OutputStream out=httpURLConnection.getOutputStream();
                out.write(menuName.getBytes());
                InputStream in=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in,"utf-8"));
                String str=bufferedReader.readLine();
                String strs[]=str.split("&&&");
                //得到数据库中的图片
                URL imgUrl=new URL(ConfigUtil.URL+strs[0]);
                InputStream in1=imgUrl.openStream();
                Bitmap bitmap= BitmapFactory.decodeStream(in1);
                publishProgress(bitmap,strs[1],strs[2],strs[3]);
                in1.close();
                out.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            Bitmap bitmap= (Bitmap) values[0];
            String menuName=values[1].toString();
            String menuType=values[2].toString();
            String menuLikeNumber=values[3].toString();
            //更新UI界面
            searchMenuImg.setImageBitmap(bitmap);
            searchMenuName.setText(menuName);
            searchMenuType.setText(menuType);
            searchMenuNumber.setText(menuLikeNumber);
            super.onProgressUpdate(values);
        }
    }
}
