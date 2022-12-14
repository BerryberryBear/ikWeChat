package com.example.ikwechat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    private ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.tag3, container, false);
        recyclerView=view.findViewById(R.id.re3);


        List<String> name= new ArrayList();
        List<String> collection =new ArrayList<>();
        img=view.findViewById(R.id.t3imageView);
        Bundle bundle=new Bundle();
        Add(name);
        Context context=getContext();

        MyAdapter adapter=new MyAdapter(context,name,collection);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CollecActivity.class);
                intent.putExtra("collection",bundle);
                bundle.putStringArrayList("music", (ArrayList<String>) collection);
                startActivity(intent);
            }
        });

        return view;
    }

    public void Add(List<String> name){
        for (int i=1;i<6;i++){
            name.add("降E大调第"+i+"钢琴协奏曲");
        }
        for (int i=3;i<15;i++){
            name.add("升C小调第"+i+"钢琴奏鸣曲");
        }
        for (int i=1;i<7;i++){
            name.add("F大调第"+i+"号交响曲");
        }
        for (int i=5;i<12;i++){
            name.add("D小调第"+i+"号交响曲");
        }
    }
}