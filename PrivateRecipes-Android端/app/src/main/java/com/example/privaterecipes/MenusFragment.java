package com.example.privaterecipes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class MenusFragment extends Fragment {
    private List<MenuList> menuLists = new ArrayList<>();
    private EditText menuName;//编辑框中菜谱的名字
    private Button btnSearch;//菜谱按钮
    private View root;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = inflater.inflate(R.layout.fragment_menus, container, false);
        //准备数据
        initDate();
        //定义Item布局文件（自定义）
        //创建Adapter，绑定Adapter
        CustomAdapterMenuList customAdapterMenuList = new CustomAdapterMenuList(this.getActivity(), menuLists, R.layout.menu_list_item);
        ListView menuListView = (ListView) root.findViewById(R.id.lv_menulist);
        //获取控件对象
        getViews();
        //设置按钮点击事件监听器
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("menuName",menuName.getText().toString());
                intent.setClass(getActivity(), SearchMenuActivity.class);
                startActivity(intent);
            }
        });

        menuListView.setAdapter(customAdapterMenuList);


        return root;
    }

    private void getViews() {
        menuName=root.findViewById(R.id.searchMenuByname);
        btnSearch=root.findViewById(R.id.btn_search);
    }

    private void initDate() {
        //获取服务器发送过来的菜谱数据
        //将数据库发送过来的数据显示到主界面上
        if (menuLists.size() == 0 || menuLists == null) {
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(ConfigUtil.URL + "ShowMenuListServlet");
        } else {

        }


    }

    //异步任务类获取网络中的信息
    class MyAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            String urlList = objects[0].toString();

            try {
                URL url = new URL(urlList);
                URLConnection urlConnection = url.openConnection();
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                String list = reader.readLine();
                Log.e("菜谱列表", list);
                //关闭流
                in.close();
                publishProgress(list);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            String rs = values[0].toString();
            String[] list = rs.split("&&&");
            for (int i = 0; i < list.length; i++) {
                String info[] = list[i].split("!!!");
                MenuList menuList = new MenuList(Integer.parseInt(info[0]), info[1], info[2], info[3], "菜谱详情", Integer.parseInt(info[4]));
                menuLists.add(menuList);

            }
        }
    }
}
