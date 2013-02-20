package com.exercise.AndroidViewPager;

import java.util.ArrayList;
import java.util.List;

import com.exercise.AndroidViewPager.MyFragmentA.EfficientAdapter.ViewHolder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

	private EfficientAdapter adap;
	private static String[] data = new String[] {"0","1","2","3","4","5","6","7","8","9","10"};
	int mCurCheckPosition = 0;
	private static LayoutInflater mInflater;
	ListView lv;

	public static Fragment newInstance(Context context) {
		MyFragmentA f = new MyFragmentA();
		return f;
	}

	ListView mylistview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.fragment_a, container,
				false);

		A_input = (EditText) myFragmentView.findViewById(R.id.a_input);
		A_enter = (Button) myFragmentView.findViewById(R.id.a_enter);
		mylistview=(ListView) myFragmentView.findViewById(R.id.list);
		A_enter.setOnClickListener(A_enterOnClickListener);

		List<Restaurants> list = new ArrayList<Restaurants>();

		for (int i = 1; i <= 10; i++) {
			Restaurants rest = new Restaurants();
			rest.setREST_ID(i);
			rest.setREST_IMAGE_NAME("IMAGE_NAME" + Integer.toString(i));
			rest.setREST_EMAIL("EMAIL" + Integer.toString(i) + "@xx.com");
			rest.setREST_NAME("NAME" + Integer.toString(i));

			rest.setREST_PATH("PATH" + Integer.toString(i));
			rest.setREST_WEBSITE("WEBSITE" + Integer.toString(i));
			list.add(rest);

		}

		adap = new EfficientAdapter(this.getActivity(), list);
		setListAdapter(adap);
		Log.d("MylistSize=", Integer.toString(list.size()));
		Log.d("Mylistadap=", Integer.toString(adap.getCount()));
		// Log.d("MygetREST_NAME=" ,list.get(5).getREST_NAME());

		return myFragmentView;

	}

	OnClickListener A_enterOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			/*
			 * public void onItemSelected(int position) { }
			 */

			String textPassToB = A_input.getText().toString();

			String TabOfFragmentB = ((AndroidViewPagerActivity) getActivity())
					.getTabFragmentB();

			MyFragmentB fragmentB = (MyFragmentB) getActivity()
					.getSupportFragmentManager().findFragmentByTag(
							TabOfFragmentB);

			fragmentB.b_updateText(textPassToB);

			Toast.makeText(getActivity(),
					"text sent to Fragment B:\n " + TabOfFragmentB,
					Toast.LENGTH_LONG).show();
			
			int cntChoice = mylistview.getCount();

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
			    			

			            }
			
			/*ViewHolder vh = null;
			if (vh.mycheckbox.isChecked())
			{
				
				Toast.makeText(getActivity(),
						"text sent to Fragment B:\n " + TabOfFragmentB,
						Toast.LENGTH_LONG).show();
			}
			else {
				Toast.makeText(getActivity(),
						"Please check the item first:\n " + TabOfFragmentB,
						Toast.LENGTH_LONG).show();
		
			}*/
			
		}
	};

	private Restaurants get(String s) {
		return new Restaurants();
	}

	public static class EfficientAdapter extends ArrayAdapter<Restaurants> {

		private final List<Restaurants> locallist;
		private final Activity context;

		public EfficientAdapter(Activity context, List<Restaurants> list) {

			super(context, R.layout.adaptor_content, list);
			this.context = context;
			this.locallist = list;
			mInflater = LayoutInflater.from(context);

			// TODO Auto-generated constructor stub
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			// A ViewHolder keeps references to children views to avoid
			// unneccessary calls
			// to findViewById() on each row.
			final ViewHolder holder;

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
								Restaurants element = (Restaurants) holder.mycheckbox
										.getTag();
								element.setSelected(buttonView.isChecked());
								if (element.isSelected() == true) {
									String TabOfFragmentB = ((AndroidViewPagerActivity) context)
									.getTabFragmentB();
									/*MyFragmentB fragmentB = (MyFragmentB) ((FragmentActivity) context//getActivity())
									).getSupportFragmentManager()
									.findFragmentByTag(TabOfFragmentB);
									fragmentB.displayListView(element);*/
								
									/* 		List<Restaurants> l=	fragmentB.displayListView(element);

							ArrayAdapter<Restaurants> adapter = new ArrayAdapter<Restaurants>(context, android.R.layout.simple_list_item_1, l);
					       ((ListView) l).setAdapter(adapter);     */   

									//EfficientAdapter adaps = new EfficientAdapter(context, element);
									//fragmentB.lv_received
									//setAdapter(adaps);
									//fragmentB.b_received
									//element.	
									
				/*	String textPassToB = A_input.getText()
							.toString();

					String TabOfFragmentB = ((AndroidViewPagerActivity) getActivity())
							.getTabFragmentB();

					MyFragmentB fragmentB = (MyFragmentB) getActivity()
							.getSupportFragmentManager()
							.findFragmentByTag(TabOfFragmentB);

					fragmentB.b_updateText(textPassToB);

					Toast.makeText(
							getActivity(),
							"text sent to Fragment B:\n "
									+ TabOfFragmentB,
							Toast.LENGTH_LONG).show();*/

									Toast.makeText(
											context,
											"CheckBox element position ="
													+ element.getREST_ID()
													+ " Is checked",
											Toast.LENGTH_SHORT).show();
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
			Myholder.textLine.setText(locallist.get(position).getREST_EMAIL());
			Myholder.textLine2.setText(locallist.get(position)
					.getREST_WEBSITE());
			Myholder.mycheckbox
					.setChecked(locallist.get(position).isSelected());

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
