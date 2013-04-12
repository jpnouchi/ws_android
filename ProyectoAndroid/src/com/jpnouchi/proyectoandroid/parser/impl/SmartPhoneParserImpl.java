package com.jpnouchi.proyectoandroid.parser.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.jpnouchi.proyectoandroid.model.SmartPhone;
import com.jpnouchi.proyectoandroid.parser.ParserManager;
import com.jpnouchi.proyectoandroid.parser.SmartPhoneParser;
import com.jpnouchi.proyectoandroid.utilitario.Constantes;
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
		List<SmartPhone> listaSmartPhone = null;
		try {
			//XML PULL maneja eventos que son valores enteros 
			int evento = parser.getEventType();
			SmartPhone smartPhone = null;
			
			//Mientras que no termine el documento entra
			while (evento != XmlPullParser.END_DOCUMENT){
				String etiqueta = null;
				//comenzaremos a recorrer las etiquetas
				switch (evento) {
				
				case XmlPullParser.START_DOCUMENT:
					listaSmartPhone = new ArrayList<SmartPhone>();
					break;
					
				case XmlPullParser.START_TAG:
					etiqueta = parser.getName();

					if (etiqueta.equals(Constantes.SMARTPHONE_INIT)){
						smartPhone = new SmartPhone();
					}
					else{ 
						if (smartPhone != null){
						//analizar las demas etiquetas
						if (etiqueta.equals(Constantes.TAG_MANUFACTURER)){
							smartPhone.setManufacturer(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_BRAND)){
							smartPhone.setBrand(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_MODEL)){
							smartPhone.setModel(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_RELEASE)){
							smartPhone.setRelease(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_OS)){
							smartPhone.setOs(parser.nextText());
						}
						
						}
					}

					
				break;
				//FIN DE LAS ETIQUETAS
				case XmlPullParser.END_TAG:
					etiqueta = parser.getName();
					//SIEMPRE Y CUANDO LA ETIQUETA DE CIERRE ES "ITEM" Y EL MODELO NOTICIA ES DIFERENTE DE NULL(ESTA LLENO)
					if (etiqueta.equals(Constantes.SMARTPHONE_INIT) && smartPhone != null){
						listaSmartPhone.add(smartPhone);
					}
				break;
	
				}
				evento = parser.next();
				}

			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaSmartPhone;
	}

}
