package com.example.ikwechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment fragment1,fragment2,fragment3,fragment4;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1=findViewById(R.id.Linear1);
        linearLayout2=findViewById(R.id.Linear2);
        linearLayout3=findViewById(R.id.Linear3);
        linearLayout4=findViewById(R.id.Linear4);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction()
                .add(R.id.FrameLayout,fragment1)
                .add(R.id.FrameLayout,fragment2)
                .add(R.id.FrameLayout,fragment3)
                .add(R.id.FrameLayout,fragment4);
        transaction.commit();
        hidden();
        showfragment(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

        Log.d("yun", "onCreate:MainActivity");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Linear1:select(1);
                break;
            case R.id.Linear2:select(2);
                break;
            case R.id.Linear3:select(3);
                break;
            case R.id.Linear4:select(4);
                break;
        }
    }

    private void select(int i) {
        hidden();
        switch (i){
            case 1:showfragment(fragment1);
                break;
            case 2:showfragment(fragment2);
                break;
            case 3:showfragment(fragment3);
                break;
            case 4:showfragment(fragment4);
                break;
        }
    }

    private void showfragment(Fragment fragment) {
        transaction.show(fragment);
    }

    private void hidden() {
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("yun","Onstart:MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("yun","Onrestart:MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("yun","Onresume:MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("yun","Ondestroy:MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("yun","Onpause:MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("yun","Onstop:MainActivity");
    }
}