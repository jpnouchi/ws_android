package com.jpnouchi.proyectoandroid;

import java.lang.annotation.ElementType;
import java.util.List;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.jpnouchi.proyectoandroid.model.SmartPhone;
import com.jpnouchi.proyectoandroid.parser.SmartPhoneParser;
import com.jpnouchi.proyectoandroid.parser.impl.SmartPhoneParserImpl;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.jpnouchi.proyectoandroid.utilitario.Constantes;
import com.jpnouchi.proyectoandroid.utilitario.Util;

import static com.jpnouchi.proyectoandroid.utilitario.Constantes.CONTENT_URI;

public class MainActivity extends Activity {

	private TextView txtviewSmartphonesResult;
	private XmlResourceParser rscParser;
	private SmartPhoneParser smartPhoneParserImpl;
    private   List <SmartPhone> listSmartPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy =
		    new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
        txtviewSmartphonesResult=(TextView)findViewById(R.id.textView_smartphonesResult);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
	public void onClickLeerXmlInternet(View v) {

	}
	
	public void onClickLeerXmlLocal(View v) {
		Log.d("main", "view "+ v.getContext().toString());
//		txtviewSmartphonesResult.setText("");
        rscParser =this.getResources().getXml(R.xml.phone_android);
		smartPhoneParserImpl = new SmartPhoneParserImpl(rscParser);
        listSmartPhone=smartPhoneParserImpl.parse();
		
		if(listSmartPhone!=null){
			StringBuilder text=new StringBuilder();
			for(SmartPhone smartPhone:listSmartPhone){
				text.append("");
				text.append(smartPhone.getBrand());
				text.append(" ");
				text.append(smartPhone.getModel());
				text.append("\n");
			}
			txtviewSmartphonesResult.setText(text.toString());
		}

	}


    public void onclickGrabarContentProvider(View v){
        Log.d("main", "onclickGrabarContentProvider " + listSmartPhone);

        ContentValues values;
        try {
             for(SmartPhone smartPhone:listSmartPhone){
                values= Util.phone2ContentValues(smartPhone);
                Uri uri = getContentResolver().insert(CONTENT_URI,values);
                Util.message(getBaseContext(), uri.toString());
            }
            Intent intent = new Intent(this,JsonActivity.class);
            startActivity(intent);
        }catch(Exception e){
            Log.e("main", "Exception onclickGrabarContentProvider " + e.getMessage());
        }
    }


    
    
}
