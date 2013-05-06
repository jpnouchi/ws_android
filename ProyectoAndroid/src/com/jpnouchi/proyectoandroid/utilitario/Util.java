package com.jpnouchi.proyectoandroid.utilitario;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.jpnouchi.proyectoandroid.model.SmartPhone;

public class Util {
	
	private static SimpleDateFormat dateFormatRest ;
	private static SimpleDateFormat dateFormat ;
	
	static{
		dateFormatRest =new SimpleDateFormat(Constantes.FORMAT_DATE_REST);
		dateFormat =new SimpleDateFormat(Constantes.FORMAT_DATE);
	}
	

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

    public static  ContentValues phone2ContentValues(SmartPhone beanSmartPhone){
        ContentValues values = new ContentValues();
        values.put(Constantes.COL_MANUFACTURER,beanSmartPhone.getManufacturer());
        values.put(Constantes.COL_BRAND,beanSmartPhone.getBrand());
        values.put(Constantes.COL_MODEL,beanSmartPhone.getModel());
        values.put(Constantes.COL_RELEASE,beanSmartPhone.getRelease());
        values.put(Constantes.COL_OS,beanSmartPhone.getOs());
        values.put(Constantes.COL_VERSION,beanSmartPhone.getOsVersion());
        values.put(Constantes.COL_PROCESSOR,beanSmartPhone.getProcessor());
        values.put(Constantes.COL_MEMORY,beanSmartPhone.getMemory());
        values.put(Constantes.COL_STORAGE,beanSmartPhone.getStorage());
        values.put(Constantes.COL_WEIGHT,beanSmartPhone.getWeight());
        return values;
    }

    public static Uri getUriPhone(String _id){

        if(TextUtils.isEmpty(_id))
            return Constantes.CONTENT_URI;
         else
            return Uri.parse("content://"+ Constantes.PROVIDER_NAME + "/phones"+"/"+_id);
    }
    
    public static String getDateFormat(String date) throws ParseException{
    	return dateFormat.format(dateFormatRest.parse(date));
    }
    

}
