package com.exercise.AndroidViewPager;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MyFragmentB extends ListFragment {

	TextView b_received;
	ListView lv_received;
	List<Restaurants> list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.fragment_b, container, false);
		
		b_received = (TextView)myFragmentView.findViewById(R.id.b_received);
		//lv_received = (ListView)myFragmentView.findViewById(R.id.android_receivelist);
	/*	List<Restaurants> list = new ArrayList<Restaurants>();

		for (int i = 1; i <= 10; i++) {
			Restaurants rest;
			rest = new Restaurants();
			rest.setREST_ID(i);
			rest.setREST_IMAGE_NAME("Image Name" + Integer.toString(i));
			rest.setREST_EMAIL("Email" + Integer.toString(i) + "@xx.com");
			rest.setREST_NAME("Name" + Integer.toString(i));
			rest.setREST_PATH("Path" + Integer.toString(i));
			rest.setREST_WEBSITE("Web Site" + Integer.toString(i));
			list.add(rest);
		}


		//List<Restaurants> displayListView(Restaurants rest)
		ArrayAdapter<Restaurants> adapter = new ArrayAdapter<Restaurants>(getActivity(), android.R.layout.simple_list_item_1, list);
		//lv_received.setAdapter(adapter);
		setListAdapter(adapter);*/

		String myTag = getTag();
		
		((AndroidViewPagerActivity)getActivity()).setTabFragmentB(myTag);
		
		Toast.makeText(getActivity(), 
				"MyFragmentB.onCreateView(): " + myTag, 
				Toast.LENGTH_LONG).show();
		//List<Restaurants> displayListView(Restaurants rest)
		//ArrayAdapter<Restaurants> adapter = new ArrayAdapter<Restaurants>(getActivity(), android.R.layout.simple_list_item_1, list);
		//lv_received.setAdapter(adapter);        

		return myFragmentView;
	}
	
	public void b_updateText(String t){
		b_received.setText(t);
	}
	
	public  List<Restaurants> displayListView(Restaurants rest) {

		    //Array list of countries
	        ArrayList<Restaurants> countryList = new ArrayList<Restaurants>();
	        Restaurants country = new Restaurants();
	       /* countryList.add(country);
	        country = new Restaurants("ALB","Albania","Europe","Southern Europe");
	        countryList.add(country);*/
	        
	        List<Restaurants> list = new ArrayList<Restaurants>();

			for (int i = 1; i <= 10; i++) {
			    rest = new Restaurants();
				rest.setREST_ID(i);
				rest.setREST_IMAGE_NAME("Image Name" + Integer.toString(i));
				rest.setREST_EMAIL("Email" + Integer.toString(i) + "@xx.com");
				rest.setREST_NAME("Name" + Integer.toString(i));
				rest.setREST_PATH("Path" + Integer.toString(i));
				rest.setREST_WEBSITE("Web Site" + Integer.toString(i));
				list.add(rest);
			}

	        lv_received.setOnItemClickListener(new OnItemClickListener()
	        {

				@Override
				public void onItemClick(AdapterView<?> a, View v, int pos,
						long id) {
					// TODO Auto-generated method stub
					Object o = lv_received.getItemAtPosition(pos);
					Restaurants obj_itemRest = (Restaurants)o;
	        		Toast.makeText(getActivity(), "You have chosen : " + " " + obj_itemRest.getREST_NAME(), Toast.LENGTH_LONG).show();
	       
				}
	        	
	        });
	    
	        
	        /*
	         * 
	        int cntChoice = myList.getCount();

String checked = "";

            String unchecked = "";
            SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();

            for(int i = 0; i < cntChoice; i++)
            {

                if(sparseBooleanArray.get(i) == true) 
                {
                    checked += myList.getItemAtPosition(i).toString() + "\n";
                }
                else  if(sparseBooleanArray.get(i) == false) 
                {
                    unchecked+= myList.getItemAtPosition(i).toString() + "\n";
                }


            }
	         */

	    
	
			return list;     
			 // create the grid item mapping
	       /* String[] from = new String[] {"rowid", "col_1", "col_2", "col_3"};
	        int[] to = new int[] { R.id.item1, R.id.item2, R.id.item3, R.id.item4 };

	        // fill in the grid_item layout
	        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.grid_item, from, to);
	        lv_received.setAdapter(adapter);*/
			
		
	  }
	
	 
}
