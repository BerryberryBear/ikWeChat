package com.example.ikwechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity_re extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_re);

        int str1= (int) (Math.random()*1000);
        int str2= (int) (Math.random()*100);
        Intent intent=getIntent();
        intent.putExtra("like","点赞数： "+str1);
        intent.putExtra("collection","收藏数： "+str2);
        setResult(25,intent);
        finish();
    }
}