package com.example.ikwechat;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity_music extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_music);

        textView=findViewById(R.id.music_textView);
        button=findViewById(R.id.button_update);
        Intent intent=getIntent();
        String str=intent.getExtras().getString("music");
        textView.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re_intent=new Intent(MainActivity_music.this,MainActivity_re.class);
                test.launch(re_intent);
            }
        });
    }
    public ActivityResultLauncher test= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==25){

                        TextView textView_like=findViewById(R.id.textView_like);
                        textView_like.setText(result.getData().getStringExtra("like"));
                        TextView textView_collection=findViewById(R.id.textView_collect);
                        textView_collection.setText(result.getData().getStringExtra("collection"));
                    };

                }
            }
    );

}