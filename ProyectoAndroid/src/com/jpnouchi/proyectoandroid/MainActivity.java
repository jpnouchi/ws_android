package com.jpnouchi.proyectoandroid;

import java.util.List;

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

public class MainActivity extends Activity {

	private TextView txtviewSmartphonesResult;
	private XmlResourceParser rscParser;
	private SmartPhoneParser smartPhoneParserImpl;
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
        List <SmartPhone> listaSmartPhone=smartPhoneParserImpl.parse();
		
		if(listaSmartPhone!=null){
			StringBuilder texto=new StringBuilder();
			for(SmartPhone smartPhone:listaSmartPhone){
				texto.append("");
				texto.append(smartPhone.getBrand());
				texto.append(" ");
				texto.append(smartPhone.getModel());
				texto.append("\n");
			}
			txtviewSmartphonesResult.setText(texto.toString());
		}
		
		

	}
    
    
    
}
