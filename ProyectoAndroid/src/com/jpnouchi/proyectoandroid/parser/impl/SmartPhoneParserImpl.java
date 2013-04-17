package com.jpnouchi.proyectoandroid.parser.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.text.TextUtils;
import android.util.Log;

import com.jpnouchi.proyectoandroid.model.SmartPhone;
import com.jpnouchi.proyectoandroid.parser.ParserManager;
import com.jpnouchi.proyectoandroid.parser.SmartPhoneParser;
import com.jpnouchi.proyectoandroid.utilitario.Constantes;
import com.jpnouchi.proyectoandroid.utilitario.Util;

public class SmartPhoneParserImpl implements SmartPhoneParser {

	private URL url;
	private XmlPullParser parser;
	private final String tag = "SmartPhoneParser";


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
	
	public SmartPhoneParserImpl(XmlPullParser xmlPullParser) {
		// TODO Auto-generated constructor stub
			this.parser=xmlPullParser;
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
					        
							int size =parser.getAttributeCount();
							Log.d(tag, "number of attributes "+size);
							if(size>0){
								for(int x=0;x<size;x++){
									Log.d(tag,"\t["+parser.getAttributeName(x)+"]=" +
						                    "["+parser.getAttributeValue(x)+"]");
									if(parser.getAttributeName(x).equals(Constantes.TAG_VERSION)){
										smartPhone.setOsVersion(parser.getAttributeValue(x));
									}
								}
							}else{
								Log.d(tag, "no attributes ");
							}
							smartPhone.setOs(parser.nextText());
							
						}else if (etiqueta.equals(Constantes.TAG_PROCESSOR)){
							smartPhone.setProcessor(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_MEMORY)){
							smartPhone.setMemory(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_STORAGE)){
							smartPhone.setStorage(parser.nextText());
						}else if (etiqueta.equals(Constantes.TAG_WEIGHT)){
							smartPhone.setWeight(parser.nextText());
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
