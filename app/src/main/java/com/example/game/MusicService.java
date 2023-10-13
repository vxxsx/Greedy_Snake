package com.example.game;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


public class MusicService extends Service {
    private MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent_music){
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mp = new MediaPlayer();
        mp = MediaPlayer.create(MusicService.this,R.raw.bgm1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent,flags,startId);
        mp.setLooping(true);    //循环播放
        mp.start();
        return START_NOT_STICKY;
    }

    /*@Override
    public void onStartCommand(Intent intent, int startId){
        super.onStart(intent,startId);
        mp.setLooping(true);    //循环播放
        mp.start();
    }*/

    @Override
    public void onDestroy(){
        super.onDestroy();
        mp.stop();
        mp.release();
    }
}
