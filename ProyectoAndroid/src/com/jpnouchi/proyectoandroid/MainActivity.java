package com.jpnouchi.proyectoandroid;

import java.lang.annotation.ElementType;
import java.util.List;

import android.content.ContentValues;
import android.net.Uri;
import android.widget.Toast;
import com.jpnouchi.proyectoandroid.model.SmartPhone;
import com.jpnouchi.proyectoandroid.parser.SmartPhoneParser;
import com.jpnouchi.proyectoandroid.parser.impl.SmartPhoneParserImpl;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.jpnouchi.proyectoandroid.utilitario.Constantes;

public class MainActivity extends Activity {

	private TextView txtviewSmartphonesResult;
	private XmlResourceParser rscParser;
	private SmartPhoneParser smartPhoneParserImpl;
    private   List <SmartPhone> listSmartPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtviewSmartphonesResult=(TextView)findViewById(R.id.textView_smartphonesResult);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
        int main = Log.d("main", "onclickGrabarContentProvider " + listSmartPhone);

        ContentValues values;
        for(SmartPhone smartPhone:listSmartPhone){
            values=phone2ContentValues(smartPhone);
            Uri uri = getContentResolver().insert(Uri.parse(Constantes.PROVIDER_NAME),values);
            Toast.makeText(getBaseContext(), uri.toString(),Toast.LENGTH_LONG).show();
        }

    }

    private ContentValues phone2ContentValues(SmartPhone beanSmartPhone){
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
    
    
}
