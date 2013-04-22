package com.jpnouchi.contentproviderproyecto.contentprovider;

import com.jpnouchi.contentproviderproyecto.bdhelper.PhoneSQLiteHelper;
import  static com.jpnouchi.contentproviderproyecto.util.Phone.TABLE_SMARTPHONE;
import  static com.jpnouchi.contentproviderproyecto.util.Phone._ID;
import  static com.jpnouchi.contentproviderproyecto.util.Phone.MODEL;
import  static com.jpnouchi.contentproviderproyecto.util.Phone.DATABASE_NAME;
import  static com.jpnouchi.contentproviderproyecto.util.Phone.DATABASE_VERSION;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class PhoneProvider extends ContentProvider {

	
	static final String PROVIDER_NAME ="com.jpnouchi.provider.Phones";
	static final Uri CONTENT_URI =Uri.parse("content://"+ PROVIDER_NAME + "/phones");
	static final int PHONES = 1;
	static final int PHONE_ID = 2;

	private static final UriMatcher uriMatcher;
	
	static{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "phones", PHONES);
		uriMatcher.addURI(PROVIDER_NAME, "phones/#", PHONE_ID);
	}
	
	
	SQLiteDatabase phonesDB;
	
	
	
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		int count=0;
		switch (uriMatcher.match(uri)){
		case PHONES:
			count = phonesDB.delete(TABLE_SMARTPHONE,selection,selectionArgs);
			break;
		case PHONE_ID:
			String id = uri.getPathSegments().get(1);
			count = phonesDB.delete(
					TABLE_SMARTPHONE,
					_ID + " = " + id +(!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""),
					selectionArgs);
			break;
		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (uriMatcher.match(uri)){
		//---get all books---
		case PHONES:
			return "vnd.android.cursor.dir/vnd.jpnouchi.phones";
			
		//---get a particular book---
		case PHONE_ID:
			return "vnd.android.cursor.item/vnd.jpnouchi.phones";
			
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		long rowID = phonesDB.insert(
				TABLE_SMARTPHONE,
				"",
				values);

		//---if added successfully---
		if (rowID>0)
		{
			Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(_uri, null);
			return _uri;
		}
		throw new SQLException("Failed to insert row into " + uri);

	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		
		PhoneSQLiteHelper dbHelper =  new PhoneSQLiteHelper(getContext(),DATABASE_NAME , null, DATABASE_VERSION);
		phonesDB = dbHelper.getWritableDatabase();
		return (phonesDB == null)? false:true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
		sqlBuilder.setTables(TABLE_SMARTPHONE);

		if (uriMatcher.match(uri) == PHONE_ID)
			sqlBuilder.appendWhere(_ID + " = " + uri.getPathSegments().get(1));

		if (sortOrder==null || sortOrder=="")
			sortOrder = MODEL;

		Cursor c = sqlBuilder.query(
			phonesDB,
			projection,
			selection,
			selectionArgs,
			null,
			null,
			sortOrder);

		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)){
		case PHONES:
			count = phonesDB.update(
					TABLE_SMARTPHONE,
					values,
					selection,
					selectionArgs);
			break;
		case PHONE_ID:
			count = phonesDB.update(
					TABLE_SMARTPHONE,
					values,
					_ID + " = " + uri.getPathSegments().get(1) +(!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""),
					selectionArgs);
			break;
		default: throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

}
