package com.example.privaterecipes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class RankFragment extends Fragment {
    private View root;
    private List<RankList> rankLists=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_rank,container,false);
        //准备数据
        initDate();
        //定义item布局文件
        //创建Adapter,绑定Adapter
        CustomAdapterRankList customAdapterRankList=new CustomAdapterRankList(this.getActivity(),rankLists,R.layout.rank_list_item);
        ListView rankListView =root.findViewById(R.id.lv_ranklist);
        rankListView.setAdapter(customAdapterRankList);

        return root;
    }

    private void initDate() {
        if(rankLists.size()==0||rankLists==null){
            AsyncTaskRank asyncTaskRank=new AsyncTaskRank();
            asyncTaskRank.execute();
        }

    }
    class AsyncTaskRank extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            //获取网络上的数据，封装成对象，
            try {
                URL url=new URL(ConfigUtil.URL+"ShowRankListServlet");
                URLConnection urlConnection=url.openConnection();
                InputStream in=urlConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in,"utf-8"));
                String str=bufferedReader.readLine();
                Log.e("接收到的列表信息为",str);
                publishProgress(str);
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
            String Rank=values[0].toString();
            String[] list=Rank.split("&&&");
            for(int i=0;i<list.length;i++){
                String[] info=list[i].split("!!!");
                RankList rankList=new RankList(Integer.valueOf(info[0]),info[1],info[2],info[3],info[4]);
                rankLists.add(rankList);
            }
        }
    }
}
