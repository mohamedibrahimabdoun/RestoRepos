package com.example.restodb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ImageDbHelper extends SQLiteOpenHelper {
	public static final String 	DB_NAME = "DATA_REG_DB.db";
	public static final int DB_VERSION = 1;
	public static  String[] SQLCOMMAND;


	
		//+ "SOURCE varchar2" +");";
//	private static final String SQL_DROP = "DROP TABLE IF EXISTS NTC_REGISTRATION;";

	public ImageDbHelper(Context c) {
		super(c, DB_NAME, null, DB_VERSION);
	}
	
	public ImageDbHelper(Context context,String[] SQL) 
	{
		super(context, DB_NAME, null, DB_VERSION);
		SQLCOMMAND=SQL;
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//db.execSQL(SQL_CREATE);
		for (int i = 0; i <= SQLCOMMAND.length - 1; i++) {
			db.execSQL(SQLCOMMAND[i].toString());
		}
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		for (int i = 0; i <= SQLCOMMAND.length - 1; i++) {
			db.execSQL(SQLCOMMAND[i].toString());
		}
		
		onCreate(db);
	}

	
	
	/*@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion == 1 && newVersion == 2) {
			// Upgrade the database
			Log.w(SqliteOpenhelper.class.getName(),
					"Upgrading database from version " + oldVersion + " to "
							+ newVersion + ", which will destroy all old data");
			
		}
	}*/

}
