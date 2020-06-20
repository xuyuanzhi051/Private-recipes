package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class EditPersonalInfomationActivity extends AppCompatActivity {
    private EditText edit_user_name;
    private RadioButton sex_male;
    private RadioButton sex_famale;
    private CheckBox menu_chuan;
    private CheckBox menu_yue;
    private CheckBox menu_lu;
    private CheckBox menu_su;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_infomation);
        //获取布局文件的空间对象
        getViews();
        //为布局文件设置监听器
        setListener();
    }

    private void setListener() {
        MyListener listener=new MyListener();
        btn_save.setOnClickListener(listener);
        Log.e("tag","设置了监听器事件");
        sex_male.setOnClickListener(listener);
    }

    private void getViews() {
        edit_user_name=findViewById(R.id.edit_user_name);
        sex_male=findViewById(R.id.sex_male);
        sex_famale=findViewById(R.id.sex_famale);
        menu_chuan=findViewById(R.id.menu_chuan);
        menu_yue=findViewById(R.id.menu_yue);
        menu_lu=findViewById(R.id.menu_lu);
        menu_su=findViewById(R.id.menu_su);
        btn_save=findViewById(R.id.btn_save);
    }
    /**
     * 自定义监听器类
     */
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.btn_save://点击了保存按钮
                    //构造一个用户信息对象
                    Log.e("b",v.getId()+"");
                    UserInfomation userInfomation=new UserInfomation();
                    userInfomation.setUserName(edit_user_name.getText().toString());
                    Log.e("tag","点击了保存按钮");
                    if(sex_male.isChecked()){
                        userInfomation.setUserSex("男");
                    }else if(sex_famale.isChecked()){
                        userInfomation.setUserSex("女");
                    }
                    if(menu_chuan.isChecked()){
                        userInfomation.getHobbys().add("川菜");
                    }
                    if(menu_yue.isChecked()){
                        userInfomation.getHobbys().add("粤菜");
                    }
                    if(menu_lu.isChecked()){
                        userInfomation.getHobbys().add("鲁菜");
                    }
                    if(menu_su.isChecked()){
                        userInfomation.getHobbys().add("苏菜");
                    }
                    Log.e("a",userInfomation.toString());
                    Intent intent=new Intent();
                    intent.putExtra("userinfo",userInfomation);
                    setResult(200,intent);
                    finish();//结束当前activity
                    break;

            }
        }
    }
}
