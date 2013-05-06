package com.jpnouchi.proyectoandroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.widget.Toast;
import com.google.gson.Gson;
import com.jpnouchi.proyectoandroid.model.SmartPhone;
import com.jpnouchi.proyectoandroid.parser.SmartPhoneParser;
import com.jpnouchi.proyectoandroid.parser.impl.SmartPhoneParserImpl;
import com.jpnouchi.proyectoandroid.utilitario.Constantes;
import com.jpnouchi.proyectoandroid.utilitario.Util;
import com.jpnouchi.proyectoandroid.utilitario.VibradorTelefono;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static com.jpnouchi.proyectoandroid.utilitario.Constantes.CONTENT_URI;


/**
 * Created with IntelliJ IDEA.
 * User: Jose
 * Date: 05/05/13
 * Time: 02:14 AM
 * To change this template use File | Settings | File Templates.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class JsonActivity extends ListActivity {


    private String[] listPhones;
    private SmartPhoneParser smartPhoneParserImpl;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy =
		    new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);

		}
        ListView lstView = getListView();
        //lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstView.setTextFilterEnabled(true);
        listPhones=getPhonesContentProvider();
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, listPhones));
        smartPhoneParserImpl = new SmartPhoneParserImpl();

    }

    private String[] getPhonesContentProvider(){
        List<String> lista = null;
        Cursor c;
        if (android.os.Build.VERSION.SDK_INT <11) {
            //---before Honeycomb---
            c = managedQuery(CONTENT_URI, null, null, null,
                    "_id asc");
        } else {
            //---Honeycomb and later---
            CursorLoader cursorLoader = new CursorLoader(
                    this,
                    CONTENT_URI, null, null, null,
                    "_id asc");
            c = cursorLoader.loadInBackground();
        }

        if (c.moveToFirst()) {
            lista=new ArrayList<String>();

            do{
                lista.add(c.getString(c.getColumnIndex(Constantes.COL_ID)).trim()+"-"+c.getString(c.getColumnIndex(Constantes.COL_MODEL)).trim());
                //Toast.makeText(this,c.getString(c.getColumnIndex(Constantes.COL_ID))+"-"+c.getString(c.getColumnIndex(Constantes.COL_MODEL)),Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }

       return ((lista!=null)? lista.toArray(new String[lista.size()]) : null);
    }

    public void onListItemClick( ListView parent, View v, int position, long id)
    {
//        Toast.makeText(this,"Ha seleccionado " + listPhones[position],Toast.LENGTH_SHORT).show();
        String pos=""+(position+1);
        Uri uri=Util.getUriPhone(pos);
        Cursor c;
        String respuesta = null;
        try {
            if (android.os.Build.VERSION.SDK_INT <11) {
                c = managedQuery(uri, null, null, null,"_id asc");
            } else {
                CursorLoader cursorLoader = new CursorLoader(this,uri, null, null, null,"_id desc");
                c = cursorLoader.loadInBackground();
            }
            if (c.moveToFirst()) {
                String brand=c.getString(c.getColumnIndex(Constantes.COL_BRAND));
                String model=c.getString(c.getColumnIndex(Constantes.COL_MODEL));
                respuesta = smartPhoneParserImpl.getJsonData("http://10.0.2.2:8080/AppEnterprise/ServletPhone?brand="+ URLEncoder.encode(brand, "UTF-8")+"&model="+ URLEncoder.encode(model, "UTF-8"));
            }
            SmartPhone smartPhone = null;
            String mensaje=null;
            Log.d("json", "respuesta restfull " + respuesta);
            if(!TextUtils.isEmpty(respuesta)){
            	smartPhone=new Gson().fromJson(respuesta, SmartPhone.class);
            	Log.d("json", smartPhone.toString());
            	mensaje="El Smartphone con ID "+pos+
            			"\n fue registrado por "+smartPhone.getUserCreate()+
            			"\n con fecha registro "+Util.getDateFormat(smartPhone.getDateCreate());
                comenzarAlarma(v);
            }else{
            	mensaje="El Smartphone con ID "+pos+
            			"\n no esta registrado en el sistema Web";
            			
            }
            	Util.message(getBaseContext(),mensaje);
        }
        catch (URISyntaxException e) {
        	Log.e("json", "URISyntaxException  " + e.getMessage());
            Util.message(this,"Error URI Sintax: "+e.getMessage());
        } catch (IOException e) {
        	Log.e("json", "IOException " + e.getMessage());
            Util.message(this,"Error IO: "+e.getMessage());
        } catch (Exception e) {
        	Log.e("json", "Exception " + e.getMessage());
             Util.message(this, "Error : " + e.getMessage());
         }
    }

    public void comenzarAlarma(View view) {
        int i =3;
        Intent intent = new Intent(this, VibradorTelefono.class);
        PendingIntent pedIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 123456, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pedIntent);
        Util.message(this, "La alarma se activara en " + i);

    }

    }