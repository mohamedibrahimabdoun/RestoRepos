package com.resto.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter {

	//private Context mContext;
	private SQLiteDatabase mDb;
	private DbHelper mDbHelper;

	public DbAdapter(Context context) {
		mDbHelper = new DbHelper(context);
	}
	
	public DbAdapter(Context context, String[] SQL) 
	{
		mDbHelper = new DbHelper(context,SQL);
	}
	
	public void open() throws SQLException {
		mDb = mDbHelper.getWritableDatabase();
	}


	public void close() {
		mDbHelper.close();
	}


	public long insert( List<InsertionClass> tempinsertlist,String TABLE_NAME) {
		return mDb.insert(TABLE_NAME, null, createContentValues(tempinsertlist));
	}

	private ContentValues createContentValues(List<InsertionClass> insertlist){
		ContentValues cv = new ContentValues();
		for (int i=0;i<insertlist.size();i++){
			InsertionClass insertobj=new InsertionClass();
			insertobj=insertlist.get(i);
			if (insertobj.isbyte){
				cv.put(insertobj.getCol_name(), insertobj.getArraybyte());
			}else
			{
				cv.put(insertobj.getCol_name(), insertobj.getCol_value());	
			}
		}
		
		return cv;
	}

	public Cursor getAllRows(String Table_Name) {
		String SQLQuery = "SELECT * FROM " + Table_Name;
		mDb = mDbHelper.getReadableDatabase();
		Cursor c = mDb.rawQuery(SQLQuery, null);
		return c;
	}
	public int getCountRow(String Table_Name) {
		String SQLQuery = "SELECT * FROM " + Table_Name;
		mDb = mDbHelper.getReadableDatabase();
		Cursor cur = mDb.rawQuery(SQLQuery, null);
		return cur.getCount();
	}

	public int DeleteRow(String Table_Name, String key_col, int ID) {
		int i = mDb.delete(Table_Name, key_col + "=" + ID, null);	
		return i;
	}

	public String CreateTable(String Table_Name, HashMap hm) {

		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE IF NOT EXISTS" + Table_Name + " (");
		Set s = hm.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			sb.append(" " + me.getKey() + " " + me.getValue() + ",");
		}
		sb.append(")");
		String SQL = sb.toString();
		String R_SQL = SQL.replace(",)", ");");
		return R_SQL;

	}
	
	/*public byte[] fetchSingle(int id) {
		Cursor queryCursor = mDb.query(TABLE_NAME, PROJECTION_ALL, COL_ID
				+ " = " + id, null, null, null, null);
		if (queryCursor == null) {
			return null;
		}
		byte[] image = null;
		if (queryCursor.moveToFirst()) {
			image = queryCursor.getBlob(queryCursor
					.getColumnIndexOrThrow(COL_FRONTIMAGE));
		}
		queryCursor.close();

		return image;

	}*/

}
