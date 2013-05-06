package com.jpnouchi.proyectoandroid.utilitario;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Jose
 * Date: 05/05/13
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class VibradorTelefono extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //To change body of implemented methods use File | Settings | File Templates.
        Util.message(context, "La vibracion comenzara ");

        //DEFINIR LA VIBRACION
        Vibrator vibrador = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrador.vibrate(2000);
    }
}
