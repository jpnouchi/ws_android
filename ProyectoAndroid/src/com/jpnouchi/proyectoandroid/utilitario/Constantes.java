package com.jpnouchi.proyectoandroid.utilitario;

import android.net.Uri;

public class Constantes {

	public static final String SMARTPHONE_INIT ="smartphone";
	public static final String TAG_MANUFACTURER ="manufacturer";
	public static final String TAG_BRAND ="brand";
	public static final String TAG_MODEL ="model";
	public static final String TAG_RELEASE ="release";
	public static final String TAG_OS ="os";
	public static final String TAG_VERSION ="version";
	public static final String TAG_PROCESSOR ="processor";
	public static final String TAG_MEMORY ="memory";
	public static final String TAG_STORAGE ="storage";
	public static final String TAG_WEIGHT ="weight";

    public static final String COL_MANUFACTURER ="manufacturer";
    public static final String COL_BRAND ="brand";
    public static final String COL_MODEL ="model";
    public static final String COL_RELEASE ="release";
    public static final String COL_OS ="os";
    public static final String COL_VERSION ="osVersion";
    public static final String COL_PROCESSOR ="processor";
    public static final String COL_MEMORY ="memory";
    public static final String COL_STORAGE ="storage";
    public static final String COL_WEIGHT ="weight";


    public static final int PHONES = 1;
    public static final int PHONE_ID = 2;
    public static final String PROVIDER_NAME ="com.jpnouchi.provider.Phones";
    public static final Uri CONTENT_URI =Uri.parse("content://"+ PROVIDER_NAME + "/phones");
	
	
	
	
}
