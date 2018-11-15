package com.example.edu.viewpostactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar progressBarPost;
    private static int mProgressBarStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        progressBarPost=findViewById(R.id.progressBarPost);
    }


    public void onClick(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressBarStatus < 100){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mProgressBarStatus ++;

                    progressBarPost.post(new Runnable() {

                        @Override

                        public void run() {
                            progressBarPost.setProgress(mProgressBarStatus);
                        }
                    });
                }
            }
        }).start();


}}
