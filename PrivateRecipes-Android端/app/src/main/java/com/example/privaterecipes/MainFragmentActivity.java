package com.example.privaterecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        initFragmentTabHost();
        Intent request=getIntent();
        String usertel=request.getStringExtra("usertel");
        //将此用户的手机号传给personalFragment
        Bundle bundle=new Bundle();
        bundle.putString("usertel",usertel);
        PersonalFragment personalFragment=new PersonalFragment();
        personalFragment.setArguments(bundle);
        //将此用户的手机号保存到用户信息工具类中
        InfoUtil.userTel=usertel;
        Log.e("用户的手机号是:",usertel);
    }

    /**
     * 初始化fragment界面
     */
    private void initFragmentTabHost(){
        FragmentTabHost tabHost=findViewById(android.R.id.tabhost);
        tabHost.setup(MainFragmentActivity.this, getSupportFragmentManager(),
                android.R.id.tabcontent);
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator(getTabSpecView("tab1","菜谱",R.drawable.menus));
        tabHost.addTab(tab1,MenusFragment.class,null);
        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2").setIndicator(getTabSpecView("tab2","排行",R.drawable.rank));
        tabHost.addTab(tab2,RankFragment.class,null);
        TabHost.TabSpec tab3=tabHost.newTabSpec("tab3").setIndicator(getTabSpecView("tab3","我的",R.drawable.personal));
        tabHost.addTab(tab3,PersonalFragment.class,null);


    }
    /**
     * 获取每个选项卡的布局文件
     */
    public View getTabSpecView(String tag, String title, int drawable){
        View view=getLayoutInflater().inflate(R.layout.tab_spec_layout,null);
        //获取布局中对应控件的引用
        ImageView img=view.findViewById(R.id.icon);
        img.setImageResource(drawable);

        TextView title1=view.findViewById(R.id.title);
        title1.setText(title);

        return view;
    }
}
