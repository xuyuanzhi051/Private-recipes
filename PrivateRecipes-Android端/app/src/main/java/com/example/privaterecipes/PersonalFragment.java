package com.example.privaterecipes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PersonalFragment extends Fragment {
    private View root;
    private Button btn_edit;
    private ImageView personal1_head;//用户头像
    private TextView user_name;
    private TextView user_sex;
    private TextView user_hobby;
    private String userTel;
    private Button btnMyComments;
    private Button btnMyLikes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root =inflater.inflate(R.layout.fragment_personal,container,false);
        getViews();
        //给控件设置点击事件
        setOnclickListener();
        //获取MainFragment界面提交的用户手机号
        Intent intent=getActivity().getIntent();
        userTel=intent.getStringExtra("usertel");
        Log.e("MainFragmentAcitiv的手机号是",userTel);
        //向服务器发出请求，获取用户个人信息并更新用户的个人信息;
        showUserInfomations();
        return root;
    }

    /**
     * 通过向服务器发出请求
     * 获取用户个人信息
     * 并显示在用户界面上
     */
    private void showUserInfomations() {
        MyAsyncTask1 myAsyncTask1=new MyAsyncTask1();
        myAsyncTask1.execute(ConfigUtil.URL+"ShowUserInfomationServlet");
    }


    private void setOnclickListener() {
        /**
         * 给编辑资料设置点击事件
         */
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮后跳转到编辑资料activity并携带数据并且需要接收返回数据
                Intent intent=new Intent();
                intent.putExtra("userName",user_name.getText().toString());
                intent.putExtra("userSex",user_sex.getText().toString());
                intent.putExtra("userHobby",user_hobby.getText().toString());
                intent.setClass(getActivity(),EditPersonalInfomationActivity.class);
                startActivityForResult(intent,100);
            }
        });
        /**
         * 给我的评论按钮设置点击事件
         */
        btnMyComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取此时用户的账号
                Intent intent=new Intent();
                intent.putExtra("userTel",userTel);
                intent.setClass(getActivity(),CommentsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 获取图片控件
     */
    private void getViews() {
        btn_edit=root.findViewById(R.id.btn_edit);
        Drawable editImg=getResources().getDrawable(R.drawable.edit);
        //设置图片的大小
        editImg.setBounds(5,5,50,50);
        btn_edit.setCompoundDrawables(editImg,null,null,null);
        personal1_head=root.findViewById(R.id.personal_head);
        user_name=root.findViewById(R.id.user_name);
        user_sex=root.findViewById(R.id.user_sex);
        user_hobby=root.findViewById(R.id.user_hobby);
        btnMyComments=root.findViewById(R.id.btn_myComments);
        btnMyLikes=root.findViewById(R.id.btn_myLikes);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100&&resultCode==200){
            UserInfomation userInfomation= (UserInfomation) data.getSerializableExtra("userinfo");
            //设置对应的控件属性
           user_name.setText(userInfomation.getUserName());
           user_sex.setText(userInfomation.getUserSex());
           user_hobby.setText(userInfomation.getAllHobbys());
           //将修改后的个人信息上传到服务器保存到数据库
            //拼接信息字符串用&&&分割开
            String infomation=userTel+"&&&"+userInfomation.getUserName()+"&&&"+userInfomation.getUserSex()+"&&&"+userInfomation.getAllHobbys();
            MyAsncTask  myAsncTask=new MyAsncTask();
            myAsncTask.execute(ConfigUtil.URL+"UpdateUserInfomationServlet",infomation);

        }
    }

    /**
     * 异步任务类用来请求服务器的用户信息数据
     * 并更新到用户UI界面
     */
    class MyAsyncTask1 extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            String url=objects[0].toString();
            try {
                URL url1=new URL(url);
                HttpURLConnection urlConnection= (HttpURLConnection) url1.openConnection();
                urlConnection .setRequestMethod("POST");
                Log.e("tel",userTel);
                OutputStream out=urlConnection .getOutputStream();
                out.write(userTel.getBytes());//向服务器发送用户电话号
                InputStream in=urlConnection .getInputStream();
                //读取数据库中存储的用户信息
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                String userinfomation=reader.readLine();
                if(userinfomation!=null){
                    System.out.println("用户的信息是"+userinfomation);
                    //将接收到的信息拼接成一个userinfomation对象，并把信息显示到UI界面
                    String []infomation=userinfomation.split("&&&");
                    UserInfomation userInfomation=new UserInfomation();
                    userInfomation.setUserTel(infomation[0]);
                    userInfomation.setUserName(infomation[1]);
                    userInfomation.setUserImg(infomation[2]);
                    userInfomation.setUserSex(infomation[3]);
                    //获取网络中的用户头像
                    try {
                        URL urlImg=new URL(ConfigUtil.URL+userInfomation.getUserImg());
                        Log.e("img",ConfigUtil.URL+userInfomation.getUserImg());


                        InputStream in1=urlImg.openStream();
                        Bitmap bitmap= BitmapFactory.decodeStream(in1);
                        publishProgress(userInfomation,infomation[4],bitmap);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                //关闭流
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
            //接受服务器传递的数据并显示到UI界面
            UserInfomation userInfomation= (UserInfomation) values[0];
            String hobbys=values[1].toString();
            Bitmap bitmap= (Bitmap) values[2];
            user_name.setText(userInfomation.getUserName() );
            user_sex.setText(userInfomation.getUserSex());
            user_hobby.setText(hobbys);
           //修改用户的头像
            personal1_head.setImageBitmap(bitmap);


            super.onProgressUpdate(values);
        }
    }

    /**
     * 异步任务类修改用户数据
     */
    class MyAsncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            String url=objects[0].toString();
            String infomation=objects[1].toString();
            try {
                //获取网络输出流
                URL url1=new URL(url);
                Log.e("url:",url);
                HttpURLConnection urlConnection= (HttpURLConnection) url1.openConnection();

                urlConnection.setRequestMethod("POST");
                OutputStream out=urlConnection.getOutputStream();
                out.write(infomation.getBytes());
                InputStream in=urlConnection.getInputStream();
                //关闭流
                out.close();
                in.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
