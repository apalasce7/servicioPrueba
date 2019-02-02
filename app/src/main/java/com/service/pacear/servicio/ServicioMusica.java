package com.service.pacear.servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class ServicioMusica extends Service{

    MediaPlayer miReproductor;

    @Override
    public void onCreate() {
        super.onCreate();
        miReproductor = MediaPlayer.create(this, R.raw.despacito);
        miReproductor.setLooping(true);
        miReproductor.setVolume(100,100);
    }

    public int onStartCommand(Intent intent, int flags, int startId){

        miReproductor.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(miReproductor.isPlaying()) miReproductor.stop();

        //Liberamos recursos
        miReproductor.release();
        miReproductor = null;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
