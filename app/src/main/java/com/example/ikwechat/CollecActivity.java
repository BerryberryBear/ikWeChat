package com.example.ikwechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CollecActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collec);

        recyclerView=findViewById(R.id.recollec);
        List<String> collection= new ArrayList();
        List<String> ret=new ArrayList<>();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras().getBundle("collection");
        collection=bundle.getStringArrayList("music");
        MyAdapter adapter=new MyAdapter(this,collection,ret);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Log.d("yun","onCreate: CollecActivity");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("yun","Onstart:CollecActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("yun","Onrestart:CollecActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("yun","Onresume:CollecActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("yun","Ondestroy:CollecActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("yun","Onpause:CollecActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("yun","Onstop:CollecActivity");
    }
}