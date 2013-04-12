package com.jpnouchi.proyectoandroid.parser.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.jpnouchi.proyectoandroid.model.SmartPhone;
import com.jpnouchi.proyectoandroid.parser.ParserManager;
import com.jpnouchi.proyectoandroid.parser.SmartPhoneParser;
import com.jpnouchi.proyectoandroid.utilitario.Util;

public class SmartPhoneParserImpl implements SmartPhoneParser {

	private URL url;
	private XmlPullParser parser;


	public SmartPhoneParserImpl(String stringUrl) {
		// TODO Auto-generated constructor stub
			
			try{
				this.url = new URL(stringUrl);
				this.parser=ParserManager.getInstance().getXmlPullParser();
				this.parser.setInput(Util.getInputStream(url), null);
			}catch (MalformedURLException e){
				throw new RuntimeException(e);
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
	
	}
	
	public SmartPhoneParserImpl(String stringUrl, XmlPullParser xmlPullParser) {
		// TODO Auto-generated constructor stub
		try{
			this.url = new URL(stringUrl);
			this.parser=xmlPullParser;
		}catch (MalformedURLException e){
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<SmartPhone> parse() {
		// TODO Auto-generated method stub
		List<SmartPhone> listSmartPhone = null;
		try {
			//XML PULL maneja eventos que son valores enteros 
			int evento = parser.getEventType();
			SmartPhone smartPhone = null;

			//Mientras que no termine el documento entra
			while (evento != XmlPullParser.END_DOCUMENT){
				String etiqueta = null;
				//comenzaremos a recorrer las etiquetas
//				
				
//Ir al sigueinte evento 
				evento = parser.next();
				}

			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listSmartPhone;
	}

}
