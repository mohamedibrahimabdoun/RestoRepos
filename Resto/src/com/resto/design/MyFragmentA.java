package com.resto.design;

import java.util.ArrayList;
import java.util.List;

import com.resto.data.Restaurants;
import com.resto.design.MyFragmentB.EffictiveAdpterb;
import com.resto.pkh.R;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragmentA extends ListFragment {
	
	EditText A_input;
	Button A_enter;
	static String TabOfFragmentB;
	static MyFragmentB fragmentB;
	List<Restaurants> list;
	static List<Restaurants> Temp_Glob_List;
	static List<Restaurants> Selected_Glob_List;

	private EfficientAdapter adap;
	private static String[] data = new String[10]; 
	//{"0","1","2","3","4","5","6","7","8","9","10"};
	int mCurCheckPosition = 0;
	private static LayoutInflater mInflater;

	public static Fragment newInstance(Context context) {
		MyFragmentA f = new MyFragmentA();
		return f;
	}

	ListView mylistview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.fragment_a, container, false);
		
		A_input = (EditText)myFragmentView.findViewById(R.id.a_input);
		A_enter = (Button)myFragmentView.findViewById(R.id.orderreview);
		
		//mylistview=(ListView) myFragmentView.findViewById(R.id.list);

		A_enter.setOnClickListener(A_enterOnClickListener);
	
		
		
		 TabOfFragmentB = ((RestoV2Activity)getActivity()).getTabFragmentB();
		
		 fragmentB = (MyFragmentB)getActivity().getSupportFragmentManager().findFragmentByTag(TabOfFragmentB);
				
		list = new ArrayList<Restaurants>();

		for (int i = 1; i <= 10; i++) {
			Restaurants rest = new Restaurants();
			rest.setRestaurant_ID(i);
			rest.setRestaurant_IMAGE_NAME("NAME" + Integer.toString(i));
			rest.setRestaurant_EMAIL("EMAIL" + Integer.toString(i) + "@x.com");
			//rest.setREST_PATH("PATH" + Integer.toString(i));
			rest.setRestaurant_WEBSITE("WEBSITE" + Integer.toString(i));
			rest.setRestaurant_NAME("NAME" + Integer.toString(i));
			list.add(rest);

		}

		adap = new EfficientAdapter(this.getActivity(), list);
		setListAdapter(adap);
		Log.d("MylistSize=", Integer.toString(list.size()));
		Log.d("Mylistadap=", Integer.toString(adap.getCount()));
		// Log.d("MygetREST_NAME=" ,list.get(5).getREST_NAME());
		return myFragmentView;

	}

	/*OnClickListener A_orderresetOnClickListener
	= new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			/*list.clear();
			adap = new EfficientAdapter(getActivity(), list);
			setListAdapter(adap);*/
			
		 /*List<Restaurants> emptylist=new ArrayList<Restaurants>();
			 Restaurants temprest=new Restaurants();
			 emptylist.add(temprest)
		
			 fragmentB.b_updatList(Selected_Glob_List);;
			 

		//	
			//fragmentB.b_setSelectedList(emptylist);
			
		}
		};*/
	
	OnClickListener A_enterOnClickListener
	= new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			
			String textPassToB = A_input.getText().toString();
			
			String TabOfFragmentB = ((RestoV2Activity)getActivity()).getTabFragmentB();
			
			MyFragmentB fragmentB = (MyFragmentB)getActivity()
					.getSupportFragmentManager()
					.findFragmentByTag(TabOfFragmentB);

			//fragmentB.b_updateText(textPassToB);
			//fragmentB.b_updatList(Selected_Glob_List);
			fragmentB.b_setSelectedList(Selected_Glob_List);
			
			
			
			Toast.makeText(getActivity(), 
					"text sent to Fragment B:\n " + TabOfFragmentB, 
					Toast.LENGTH_LONG).show();
			/*int cntChoice = mylistview.getCount();

			String checked = "";

			            String unchecked = "";
			            SparseBooleanArray sparseBooleanArray = mylistview.getCheckedItemPositions();

			            for(int i = 0; i < cntChoice; i++)
			            {

			                if(sparseBooleanArray.get(i) == true) 
			                {
			                    checked += mylistview.getItemAtPosition(i).toString() + "\n";
			                }
			                else  if(sparseBooleanArray.get(i) == false) 
			                {
			                    unchecked+= mylistview.getItemAtPosition(i).toString() + "\n";
			                }
			                Toast.makeText(getActivity(),
			    					"Check item sent to Fragment B:\n " + TabOfFragmentB,
			    					Toast.LENGTH_LONG).show();
			    			

			            }*/

			
		}};

		
		private Restaurants get(String s) {
			return new Restaurants();
		}


		public static class EfficientAdapter extends ArrayAdapter<Restaurants>  {


			private final List<Restaurants> locallist;
			private final Activity context;

			public EfficientAdapter(Activity context, List<Restaurants> list) {

				super(context, R.layout.adaptor_content, list);
				this.context = context;
				this.locallist = list;
				mInflater = LayoutInflater.from(context);

				// TODO Auto-generated constructor stub
			}
			public List<Restaurants>  addRest(List<Restaurants> restlist,Restaurants resobj) {
				List<Restaurants>  templist=null;
				
				templist=(List<Restaurants>)restlist;
				templist.add(resobj);
				
				return templist;
			}
			
			public View getView(int position, View convertView, ViewGroup parent) {
				// A ViewHolder keeps references to children views to avoid
				// unneccessary calls
				// to findViewById() on each row.
				final ViewHolder holder;
				Selected_Glob_List=new ArrayList<Restaurants>();

				// When convertView is not null, we can reuse it directly, there is
				// no need
				// to reinflate it. We only inflate a new View when the convertView
				// supplied
				// by ListView is null.
				if (convertView == null) {
					convertView = mInflater.inflate(R.layout.adaptor_content, null);

					// Creates a ViewHolder and store references to the two children
					// views
					// we want to bind data to.
					holder = new ViewHolder();
					holder.textLine = (TextView) convertView
							.findViewById(R.id.textLine);
					holder.textLine2 = (TextView) convertView
							.findViewById(R.id.textLine2);
					holder.buttonLine = (Button) convertView
							.findViewById(R.id.buttonLine);
					holder.editline = (EditText) convertView
							.findViewById(R.id.editLine);
					holder.mycheckbox = (CheckBox) convertView
							.findViewById(R.id.checkBox1);

					convertView.setTag(holder);
					holder.textLine.setTag(locallist.get(position));
					holder.textLine2.setTag(locallist.get(position));
					holder.mycheckbox.setTag(locallist.get(position));

					holder.mycheckbox
							.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

								public void onCheckedChanged(
										CompoundButton buttonView, boolean isChecked) {
									// TODO Auto-generated method stub
									if (isChecked){
									Restaurants element = (Restaurants) holder.mycheckbox
											.getTag();
									//element.setSelected(buttonView.isChecked());
							/*	if (element.isSelected() == true) {
										String textPassToB = Integer.toString(element.getRestaurant_ID());
										Log.d("before","before");
										Temp_Glob_List=locallist;
										Log.d("After","After");
										
										List<Restaurants> selectedtemp=new ArrayList<Restaurants>();
										Log.d("selectedtemp count",Integer.toString(selectedtemp.size()) );
										
										
										if (Selected_Glob_List.size()==0){
									Selected_Glob_List=addRest(selectedtemp, element);
										}else 
										{
											
											Selected_Glob_List=addRest(Selected_Glob_List, element);
										}
										
										Log.d("selectedtemp count",Integer.toString(Selected_Glob_List.size()) );
										
										Toast.makeText(
												context,
												"CheckBox element position ="
														+ textPassToB
														+ " Is checked",
												Toast.LENGTH_SHORT).show();
									}*/
									
								}

								}
							});

				} else {
					holder = (ViewHolder) convertView.getTag();
					((ViewHolder) convertView.getTag()).mycheckbox.setTag(locallist
							.get(position));
					// ((ViewHolder) view.getTag()).text.setTag(list.get(position));
				}

				ViewHolder Myholder = (ViewHolder) convertView.getTag();
				Myholder.textLine.setText(locallist.get(position).getRestaurant_EMAIL());
				Myholder.textLine2.setText(locallist.get(position)
						.getRestaurant_WEBSITE());
				/*Myholder.mycheckbox
						.setChecked(locallist.get(position).isSelected());*/

				return convertView;

			}

			static class ViewHolder {
				TextView textLine;
				TextView textLine2;
				ImageView iconLine;
				Button buttonLine;
				EditText editline;
				CheckBox mycheckbox;
			}



		}



	
		
		

}
//http://stackoverflow.com/questions/8726272/get-checked-items-from-listview-in-android
//

//http://stackoverflow.com/questions/4831918/how-to-get-all-checked-items-from-a-listview
//http://stackoverflow.com/questions/4590856/how-to-get-selected-items-from-multi-select-list-view