package com.service.pacear.servicio;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean encendida;
    private ImageView botonPlay;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encendida = false;
        /*botonPlay = (ImageView) findViewById(R.id.botonPlay);
        botonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(encendida) apagaMusica();
                else encicendeMusica();
            }
        });*/
        String manufacturer = "xiaomi";
        if (manufacturer.equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
            //this will open auto start screen where user can enable permission for your app
            Intent intent1 = new Intent();
            intent1.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            startActivity(intent1);
        }
        if (!isMyServiceRunning(ServicioMusica.class)){ //método que determina si el servicio ya está corriendo o no
            Intent serv = new Intent(this,ServicioMusica.class); //serv de tipo Intent
            this.startService(serv); //ctx de tipo Context
            //this.startForegroundService(serv);
        } else {
        }

    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /*public void encicendeMusica(){
        botonPlay.setImageResource(R.drawable.stop);
        Intent miReproductor = new Intent(this, ServicioMusica.class);
        this.startService(miReproductor);
        encendida = !encendida;
    }

    public void apagaMusica(){
        botonPlay.setImageResource(R.drawable.play);
        Intent miReproductor = new Intent(this, ServicioMusica.class);
        this.stopService(miReproductor);
        encendida = !encendida;
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
