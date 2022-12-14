package com.example.ikwechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private View view;
    private Context context;
    private List<String> list;
    private List<String> listr;


    public MyAdapter(Context context,List<String> list,List<String> listr) {
        this.context = context;
        this.list = list;
        this.listr = listr;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.re3x,parent,false);
        MyHolder myHolder;
        myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(list.get(position));
        String str=list.get(position);
        MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.jini);
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "播放",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        }
        );
        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "停止",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
            }
        });
        holder.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listr.add(str);
                Intent intent=new Intent(context,MainActivity_music.class);
                intent.putExtra("music",str);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView img1,img2,img3;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.re3text);
            img1=itemView.findViewById(R.id.re3image1);
            img2=itemView.findViewById(R.id.re3image2);
            img3=itemView.findViewById(R.id.re3image3);
        }
    }
}