package com.service.pacear.servicio;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootBroadcast extends BroadcastReceiver {

    public BootBroadcast(){}

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "HOLAAAAA", Toast.LENGTH_SHORT).show();
        final String action = intent.getAction();
        Toast.makeText(context, "ACTION: "+action, Toast.LENGTH_SHORT).show();
        /*if (action.equals(BluetoothDevice.ACTION_ACL_CONNECTED)) {
            Toast.makeText(context, "ACTION OK!: "+ action, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "ACTION: "+action, Toast.LENGTH_SHORT).show();
        }*/
        //context.startService(new Intent(context, ServicioMusica.class));
    }
}
