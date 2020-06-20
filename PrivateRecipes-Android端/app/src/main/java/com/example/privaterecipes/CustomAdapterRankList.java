package com.example.privaterecipes;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Adapter类型
 */
public class CustomAdapterRankList extends BaseAdapter {
    private Context mContext;
    private List<RankList> ranklists=new ArrayList<>();
    private int itemLayoutRes;

    public CustomAdapterRankList(Context mContext, List<RankList> ranklists, int itemLayoutRes) {
        this.mContext = mContext;
        this.ranklists = ranklists;
        this.itemLayoutRes = itemLayoutRes;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<RankList> getRanklists() {
        return ranklists;
    }

    public void setRanklists(List<RankList> ranklists) {
        this.ranklists = ranklists;
    }

    public int getItemLayoutRes() {
        return itemLayoutRes;
    }

    public void setItemLayoutRes(int itemLayoutRes) {
        this.itemLayoutRes = itemLayoutRes;
    }

    @Override
    public int getCount() {//获取数据的条数
        if(null!=ranklists){
            return ranklists.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {//获取每个item显示的数据对象
        if(null!=ranklists){
            return ranklists.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载item布局文件
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(itemLayoutRes,null);
        //获取item控件的引用
        TextView rankNum=convertView.findViewById(R.id.rank_num);
        ImageView menuImg=convertView.findViewById(R.id.rank_menu_img);
        TextView menuName=convertView.findViewById(R.id.rank_menu_name);
        TextView menuType=convertView.findViewById(R.id.rank_menu_type);
        TextView menuLikes=convertView.findViewById(R.id.rank_menu_likes);
        //设置图片控件的内容
     RankAsycTask rankAsycTask=new RankAsycTask();
      rankAsycTask.execute(ranklists.get(position).getMenuImg(),menuImg);

       rankNum.setText(ranklists.get(position).getRankNum()+" ");
       menuName.setText(ranklists.get(position).getMenuName());
        menuType.setText(ranklists.get(position).getMenuType());
       menuLikes.setText(ranklists.get(position).getLikenumber());


        return convertView;
    }
    class RankAsycTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            String img=objects[0].toString();
            ImageView menuImg= (ImageView) objects[1];
            try {
                URL url = new URL(ConfigUtil.URL +img);

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
            ImageView menuImg1= (ImageView) values[1];
            menuImg1.setImageBitmap(bitmap);

            super.onProgressUpdate(values);
        }
    }

}


