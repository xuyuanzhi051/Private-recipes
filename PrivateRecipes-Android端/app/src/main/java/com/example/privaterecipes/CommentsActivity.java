package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CommentsActivity extends AppCompatActivity {
    private List<UserComment> userComments=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        //准备数据
        initDate();
        //定义item布局文件
        //创建Adapter,绑定Adapter
        CustomAdapterCommentList customAdapterCommentList=new CustomAdapterCommentList(this,userComments,R.layout.comment_list_item);
        ListView commentListView=findViewById(R.id.lv_commentlist);
        commentListView.setAdapter(customAdapterCommentList);

    }

    /**
     * 向数据库获取评论信息
     */
    private void initDate() {
        Intent intent=getIntent();
        String userTel=intent.getStringExtra("userTel");
        System.out.println(userTel);
        if(userComments.size()==0||userComments==null){
            GetMyComment getMyComment=new GetMyComment();
            getMyComment.execute(userTel);
        }else{

        }

    }

    /**
     * 网络流得到自己的评论
     */
    class GetMyComment extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                String userTel=objects[0].toString();
                URL url=new URL(ConfigUtil.URL+"ShowCommentServlet");
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                OutputStream out=httpURLConnection.getOutputStream();
                out.write(userTel.getBytes());
                InputStream in=httpURLConnection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(in,"utf-8"));
                String str=reader.readLine();
                System.out.println("str="+str);
                publishProgress(str);
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
            if(values[0]!=null){
                String str=values[0].toString();
                String strs[]=str.split("&&&");
                for(int i=0;i<strs.length;i++){
                    String info[]=strs[i].split("!!!");
                    UserComment userComment=new UserComment();
                    userComment.setUserId(Integer.parseInt(info[0]));
                    userComment.setMenuId(Integer.parseInt(info[1]));
                    userComment.setMenuComment(info[2]);
                    System.out.println("用户评论"+info[2]);
                    userComments.add(userComment);
                }
                super.onProgressUpdate(values);
            }

        }
    }
}
