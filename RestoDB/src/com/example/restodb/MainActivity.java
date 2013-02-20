package com.example.restodb;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.Menu;

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
			ImageDbAdapter adpt=new ImageDbAdapter(this);
			adpt.open();
			adpt.insert(insertionlst);
		}
		
	}

	

}
