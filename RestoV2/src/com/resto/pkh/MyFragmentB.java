package com.resto.pkh;

import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MyFragmentB extends Fragment {

	TextView b_received;
	ListView lv_CheckItem;
	List<Restaurants> list;
	List<Restaurants> Glob_List;
	int countr;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.fragment_b, container, false);
		
		b_received = (TextView)myFragmentView.findViewById(R.id.b_received);
		String myTag = getTag();
		
		((RestoV2Activity)getActivity()).setTabFragmentB(myTag);
		
		Toast.makeText(getActivity(), 
				"MyFragmentB.onCreateView(): " + countr, 
				Toast.LENGTH_LONG).show();

       /* SparseBooleanArray a = lv_CheckItem.getCheckedItemPositions();

        for(int i = 0; i < lv_CheckItem ; i++)
        {
        	
        }*/

		
		/* lv_received.setOnItemClickListener(new OnItemClickListener()
	        {

				@Override
				public void onItemClick(AdapterView<?> a, View v, int pos,
						long id) {
					// TODO Auto-generated method stub
					Object o = lv_received.getItemAtPosition(pos);
					Restaurants obj_itemRest = (Restaurants)o;
	        		Toast.makeText(getActivity(), "You have chosen : " + " " + obj_itemRest.getREST_NAME(), Toast.LENGTH_LONG).show();
	       
				}
	        	
	        });*/

		
		return myFragmentView;
	}
	
	public void b_updateText(String t){
		b_received.setText(t);
	}
	
	
	public void b_updatList(List<Restaurants> l){
		countr=l.size();
		b_received.setText(Integer.toString(l.size()));
	}

}

// http://stackoverflow.com/questions/6955863/get-index-if-checked-rows-in-this-customized-listview?rq=1


//http://android-codes-examples.blogspot.com/search/label/onListItemClick
