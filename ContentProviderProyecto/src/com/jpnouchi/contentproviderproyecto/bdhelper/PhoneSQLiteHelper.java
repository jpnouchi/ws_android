package com.jpnouchi.contentproviderproyecto.bdhelper;

import com.jpnouchi.contentproviderproyecto.util.Phone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PhoneSQLiteHelper extends SQLiteOpenHelper {
	
	

	public PhoneSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Phone.QUERY_CREATE_T_SMARTPHONE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(Phone.QUERY_DROP_T_SMARTPHONE);
		db.execSQL(Phone.QUERY_CREATE_T_SMARTPHONE);
	}

}
