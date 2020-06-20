package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MenuDetailsActivity extends AppCompatActivity {
    private ImageView detailsMenuImg;
    private TextView detailsMenuName;
    private TextView detailsMenuType;
    private TextView detailsMenuLikeNumber;
    private TextView detailsMenuMaterial;
    private TextView detailsMenuSteps;
    private TextView detailsMenuComments;
    private EditText detailsPersonalComments;
    private Button detailsBtnComment;
    private String menuId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        //获取对应图片控件
        getViews();
        Intent intent=getIntent();
         menuId=intent.getStringExtra("Id");
        //向服务器发出请求
        DetailsAsyncTask detailsAsyncTask=new DetailsAsyncTask();
        detailsAsyncTask.execute(menuId);
       if(menuId!=null){
           Log.e("菜谱详情页的id是",menuId);
           System.out.println("用户登录的电话是是"+InfoUtil.userTel);
           //获取服务器上的菜谱详情信息并显示到UI界面
       }
       //为按钮设置点击事件
        detailsBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UpMenuComment upMenuComment=new UpMenuComment();
               upMenuComment.execute();
            }
        });
    }

    /**
     * 获取对应的图片控件
     */
    private void getViews() {
        detailsMenuImg=findViewById(R.id.details_menuImg);
        detailsMenuName=findViewById(R.id.details_menuName);
        detailsMenuType=findViewById(R.id.details_menuType);
        detailsMenuLikeNumber=findViewById(R.id.details_menuLikeNumber);
        detailsMenuMaterial=findViewById(R.id.details_menuMaterial);
        detailsMenuSteps=findViewById(R.id.details_menuSteps);
        detailsMenuComments=findViewById(R.id.details_menuComments);
        detailsPersonalComments=findViewById(R.id.details_personalComments);
        detailsBtnComment =findViewById(R.id.details_btn_comment);

    }

    /**
     * 异步任务类
     * 得到菜单的详细信息
     */
    class  DetailsAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                String menuId=objects[0].toString();
                System.out.println("id是"+menuId);
                URL url=new URL(ConfigUtil.URL+"ShowMenuDetailsServlet");
                System.out.println("url是"+ConfigUtil.URL+"ShowMenuDetailsServlet");
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                OutputStream out=httpURLConnection.getOutputStream();

                out.write(menuId.getBytes());
                InputStream in=httpURLConnection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(in,"utf-8"));
                String str="";
                str+=reader.readLine();
                System.out.println(str);
                String img[]=str.split("&&&");
                //获取服务器上的图片
                URL urlImg=new URL(ConfigUtil.URL+img[0]);
                InputStream in1=urlImg.openStream();
                Bitmap bitmap= BitmapFactory.decodeStream(in1);

                publishProgress(str,bitmap);
                in.close();
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
             String str=values[0].toString();
             Bitmap bitmap= (Bitmap) values[1];
             detailsMenuImg.setImageBitmap(bitmap);
             String []info=str.split("&&&");
             detailsMenuName.setText(info[1]);
             detailsMenuType.setText(info[2]);
             detailsMenuLikeNumber.setText(info[3]);
             detailsMenuMaterial.setText(info[4]);
             detailsMenuSteps.setText(info[5]);
        }
    }

    /**
     * 异步任务类
     * 向菜单中增加评论
     */
    class UpMenuComment extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                URL url = new URL(ConfigUtil.URL + "ReceiveCommentServlet");

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //拼接字符串
                @SuppressLint("WrongThread") String str = InfoUtil.userTel + "&&&" + menuId + "&&&" + detailsPersonalComments.getText().toString();
                System.out.println("jjj"+str);
                OutputStream out = httpURLConnection.getOutputStream();
                out.write(str.getBytes());
                InputStream in = httpURLConnection.getInputStream();

                out.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
