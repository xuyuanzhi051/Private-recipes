package com.example.privaterecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterCommentList extends BaseAdapter {
    private Context mContext;
    private List<UserComment> userComments =new ArrayList<>();
    private int itemLayoutRes;

    public CustomAdapterCommentList(Context mContext, List<UserComment> userComments, int itemLayoutRes) {
        this.mContext = mContext;
        this.userComments = userComments;
        this.itemLayoutRes = itemLayoutRes;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<UserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<UserComment> userComments) {
        this.userComments = userComments;
    }

    public int getItemLayoutRes() {
        return itemLayoutRes;
    }

    public void setItemLayoutRes(int itemLayoutRes) {
        this.itemLayoutRes = itemLayoutRes;
    }

    @Override
    public int getCount() {//获取数据的条数
        if(null!=userComments){
            return userComments.size();
        }
        return  0;

    }

    @Override
    public Object getItem(int position) {//获取每个item显示的数据对象
        if(null!=userComments){
            return userComments.get(position);
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
        convertView =inflater.inflate(itemLayoutRes,null);
        TextView commentMenuID=convertView.findViewById(R.id.comment_menuId);
        TextView commettMenuComment=convertView.findViewById(R.id.comment_menuComment);
        Button commetnDelete =convertView.findViewById(R.id.btn_deleteComment);
      //  commentMenuID.setText(userComments.get(position).getMenuId()+"");
     //   commettMenuComment.setText(userComments.get(position).getMenuComment());
        commentMenuID.setText("aaa");
        return convertView;
    }
}
