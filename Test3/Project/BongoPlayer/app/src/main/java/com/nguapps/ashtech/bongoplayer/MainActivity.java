package com.nguapps.ashtech.bongoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private ImageButton open, play, forward, rewind;
    private VideoView videoView;
    private boolean playing;
    private Uri resource;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusBar));

        open = findViewById(R.id.open);
        play = findViewById(R.id.play);
        rewind = findViewById(R.id.rewind);
        forward = findViewById(R.id.forward);
        videoView = findViewById(R.id.video);
        playing = false;
        position = 1;


        play.setEnabled(false);
        rewind.setEnabled(false);
        forward.setEnabled(false);
        play.setImageAlpha(0x3F);
        rewind.setImageAlpha(0x3F);
        forward.setImageAlpha(0x3F);


        open.setOnClickListener(e ->{
           Intent intent = new Intent(Intent.ACTION_PICK,
                   android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
           startActivityForResult(intent,10);
        });

        play.setOnClickListener(e ->{
            if(!playing){
                videoView.setVideoURI(resource);
                videoView.seekTo(position);
                play.setImageDrawable(getDrawable(R.drawable.ic_stop_black_24dp));
                playing =true;
            }
            else{
                videoView.pause();
                position = videoView.getCurrentPosition();
                videoView.suspend();
                play.setImageDrawable(getDrawable(R.drawable.play));
                playing = false;
            }
        });

        forward.setOnClickListener(e -> {
            if(videoView.canSeekForward()){
                if(playing){
                    position = videoView.getCurrentPosition();
                    videoView.stopPlayback();
                }else{
                    position = position + 5000;
                }
                videoView.setVideoURI(resource);
                videoView.requestFocus(VideoView.FOCUS_FORWARD);
                videoView.seekTo(position+5000);

            }
        });
        rewind.setOnClickListener(e -> {
            if(videoView.canSeekBackward()){
                if(playing){
                   position = videoView.getCurrentPosition();
                   videoView.stopPlayback();
                   }else{
                    position = position - 5000;
                }
                videoView.setVideoURI(resource);
                videoView.requestFocus(VideoView.FOCUS_FORWARD);
                videoView.seekTo(position-5000);
            }
        });

        videoView.setOnPreparedListener(mp -> {if(playing)videoView.start();});
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data) {

        if (resultCode == RESULT_OK && requestCode == 10) {
            resource = data.getData();
            videoView.setVideoURI(resource);

            playing=true;
            play.setImageDrawable(getDrawable(R.drawable.ic_stop_black_24dp));

            play.setEnabled(true);
            forward.setEnabled(true);
            rewind.setEnabled(true);
            play.setImageAlpha(0xFF);
            rewind.setImageAlpha(0xFF);
            forward.setImageAlpha(0xFF);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
