package com.jpnouchi.proyectoandroid.parser;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class ParserManager {
	

	private static ParserManager instance;
	private  XmlPullParser parserXmlPull ;
	
	private ParserManager() {
		// TODO Auto-generated constructor stub
		instanceParserXmlPull();
	}

	private XmlPullParser instanceParserXmlPull(){
		this.parserXmlPull=Xml.newPullParser();
		return this.parserXmlPull;
	}
	public static ParserManager getInstance(){
	      if(instance == null) 
	          instance = new ParserManager();
	       
	      return instance;
	}
	
	public  XmlPullParser getXmlPullParser(){
		
		return (parserXmlPull==null  ? instanceParserXmlPull():this.parserXmlPull);
	}

}
