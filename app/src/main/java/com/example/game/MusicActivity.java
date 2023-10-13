package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;


public class MusicActivity extends Activity implements OnClickListener{
    private SharedPreferences saved;
    private SharedPreferences.Editor editor;
    private CheckBox on_button;
    // 创建MusicService的Intent
    //Intent intent = new Intent(this, MusicService.class);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        saved = PreferenceManager.getDefaultSharedPreferences(this);
        on_button= (CheckBox) findViewById(R.id.button_on);
        boolean playMusic = saved.getBoolean("ifon" ,true);
        on_button.setChecked(playMusic);
        on_button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        editor=saved.edit();
        if(on_button.isChecked()){
            editor.putBoolean("ifon",true);
            startService(new Intent(this, MusicService.class));
        }
        else{
            editor.putBoolean("ifon",false);
            stopService(new Intent(this, MusicService.class));
        }
        editor.commit();
    }

}
