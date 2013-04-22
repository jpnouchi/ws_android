package com.jpnouchi.contentproviderproyecto.util;

public class Phone {
	
	public static final String DATABASE_NAME = "PROYECTO";
	public static final String TABLE_SMARTPHONE = "SMARTPHONE";
	public static final String _ID="_id";
	public static final String MODEL="model";
	public static final int DATABASE_VERSION = 1;
	public static final String QUERY_CREATE_T_SMARTPHONE =
		"create table " + TABLE_SMARTPHONE +
		" (_id integer primary key autoincrement, "+
		 "manufacturer text not null, brand text not null"+
		 "model text not null, release text not null"+
		 "os text not null, osVersion text not null"+
		 "processor text , memory text "+
	    "storage text , weight text );";
	
	public static final String QUERY_DROP_T_SMARTPHONE="DROP TABLE "+TABLE_SMARTPHONE;

}
