package com.example.u16394.snacktime.activities;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.u16394.snacktime.R;


public class SplashActivity extends AppCompatActivity  {
    private VideoView slogan;
    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String uriPath = "android.resource://"+  getPackageName() + "/raw/slogan";
        String uriImgPath = "android.resource://"+  getPackageName() + "/drawable/empresa";
        final Uri uri = Uri.parse(uriPath);
        final Uri uriImg = Uri.parse(uriImgPath);
        slogan = (VideoView)findViewById(R.id.videoView);
        slogan.setVideoURI(uri);
        slogan.requestFocus();
        slogan.start();
        new Handler().postDelayed(new Runnable() {
           @Override
           public void run(){
               logo = (ImageView)findViewById(R.id.imageView3);
               logo.setImageURI(uriImg);
               Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
               logo.startAnimation(animation);
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       chamaMain();
                   }
               },2500);
           }
       },30);
    }
    @Override
    protected void onStart() {
    super.onStart();
    }
    protected void onResume(){
        super.onResume();
    }

    protected void onRestart(){
        super.onRestart();
        chamaMain();
    }

    public void chamaMain(){
        Intent it = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(it);
    }
}
