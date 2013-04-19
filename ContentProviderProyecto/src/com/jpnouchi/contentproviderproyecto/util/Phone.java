package com.jpnouchi.contentproviderproyecto.util;

public class Phone {
	
	static final String DATABASE_NAME = "PROYECTO";
	static final String DATABASE_TABLE = "SMARTPHONE";
	static final int DATABASE_VERSION = 1;
	static final String DATABASE_CREATE =
		"create table " + DATABASE_TABLE +
		" (_id integer primary key autoincrement, "+
		 "manufacturer text not null, brand text not null"+
		 "model text not null, release text not null"+
		 "os text not null, osVersion text not null"+
		 "processor text , memory text "+
	    "storage text , weight text );";
	
	

}
