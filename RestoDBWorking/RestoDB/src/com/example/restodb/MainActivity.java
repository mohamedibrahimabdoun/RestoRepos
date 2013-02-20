package com.example.restodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
byte[] arraybyte;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		arraybyte= MyCustom.getBytes(BitmapFactory.decodeResource(
                getResources(), R.drawable.ic_launcher));
		List<InsertionClass> insertionlst =new ArrayList<InsertionClass>();
		
		for (int i=0;i<2;i++){
			InsertionClass insertionobject=new InsertionClass();
			if (i==0){
			insertionobject.setCol_name("Name");
			insertionobject.setCol_value("value"+i);
			insertionobject.setIsbyte(false);
			}else {
				insertionobject.setCol_name("BACK_IMAGE");
				insertionobject.setArraybyte(arraybyte);
				insertionobject.setIsbyte(true);
				
			}
			insertionlst.add(insertionobject);
			insertionobject=null;
			
			
			
			
			// ================= Creating SQLite Tables
			HashMap Resto_Structure = new HashMap();
			//HashMap Reg_Data = new HashMap();
			Resto_Structure.put("_id", "integer primary key");
			Resto_Structure.put("NAME", "varchar2");
			Resto_Structure.put("BACK_IMAGE", "blob");
			String Create_SQL = CreateTable("RESTO", Resto_Structure);
			try {
			String[] Commands = new String[1];
			Commands[0] = Create_SQL;
			ImageDbAdapter  adpt=new ImageDbAdapter(this,Commands);
			adpt.open();
			adpt.insert(insertionlst,"RESTO");
			} catch (Exception e) {
			Toast.makeText(
			getBaseContext(),
			e.getMessage()
			+ "Error SQLite"
			+ e.getClass().getName(), Toast.LENGTH_LONG)
			.show();
			} // =================End Of Creating Tables On SQLite
		}
		
	}

	public String CreateTable(String Table_Name, HashMap hm) {

		StringBuffer sb = new StringBuffer();
		sb.append("create table if not exists " + Table_Name + " (");
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

}
