package com.jpnouchi.proyectoandroid.utilitario;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.widget.Toast;

public class Util {

	public static void message(Context context, String msg){
		int duracion = Toast.LENGTH_LONG;
		Toast toast =  Toast.makeText(context, msg, duracion);
		toast.show();
	}
	
	public static  InputStream getInputStream( URL noticiaUrl) {
		// TODO Auto-generated method stub
		try{
		return noticiaUrl.openConnection().getInputStream();
		}catch (IOException e){
		throw new RuntimeException(e);
		}
	}

}
