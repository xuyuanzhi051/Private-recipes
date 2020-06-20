package com.example.privaterecipes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 自定义Adapter类型
 */
public class CustomAdapterMenuList extends BaseAdapter {


    private Context mContext;
    private List<MenuList> menuLists=new ArrayList<>();
    private int itemLayoutRes;

    public CustomAdapterMenuList(Context mContext, List<MenuList> menuLists, int itemLayoutRes) {
        this.mContext = mContext;
        this.menuLists = menuLists;
        this.itemLayoutRes = itemLayoutRes;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<MenuList> getMenuLists() {
        return menuLists;
    }

    public void setMenuLists(List<MenuList> menuLists) {
        this.menuLists = menuLists;
    }

    public int getItemLayoutRes() {
        return itemLayoutRes;
    }

    public void setItemLayoutRes(int itemLayoutRes) {
        this.itemLayoutRes = itemLayoutRes;
    }

    @Override
    public int getCount() {//获取数据的条数
        if(null!=menuLists){
            return menuLists.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {//获取每个item显示的数据对象
        if(null!=menuLists){
            return menuLists.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //获取item对象
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       //加载item布局文件
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView =inflater.inflate(itemLayoutRes,null);
        //获取item控件的引用
            ImageView menuImg=convertView.findViewById(R.id.menu_img);
        TextView menuName=convertView.findViewById(R.id.menu_name);
        TextView menuType= convertView.findViewById(R.id.menu_type);
        Button btnDetails=convertView.findViewById(R.id.btn_details);
        TextView menuLikeNumber=convertView.findViewById(R.id.menu_likenumber);
        Button btnFlaglike=convertView.findViewById(R.id.btn_flaglike);
        //设置控件内
        //获取网络中的图片



        MyAsycTask myAsycTask=new MyAsycTask();
        myAsycTask.execute(menuLists.get(position).getMenuImg(),menuImg);


        menuName.setText(menuLists.get(position).getMenuName());
        menuType.setText(menuLists.get(position).getMenuType());

        menuLikeNumber.setText(menuLists.get(position).getMenuLikes()+" ");
        btnFlaglike.setText("点赞标志");
        //为详情按钮设置点击事件监听器
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到菜谱详情Activity并携带当前菜的Id

                Intent intent=new Intent();
                intent.putExtra("Id",menuLists.get(position).getMenuId()+"");
                intent.setClass(mContext,MenuDetailsActivity.class);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    class MyAsycTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            String img=objects[0].toString();
            ImageView menuImg= (ImageView) objects[1];
            try {
                URL url = new URL(ConfigUtil.URL +img);
                Log.e("图片", ConfigUtil.URL +img);
                InputStream in = url.openStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                publishProgress(bitmap,menuImg);
                in.close();
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
            ImageView menuImg= (ImageView) values[1];
            Log.e("bitmap", String.valueOf(bitmap));
            menuImg.setImageBitmap(bitmap);
            super.onProgressUpdate(values);
        }


    }

}


