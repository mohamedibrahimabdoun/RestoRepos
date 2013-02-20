package com.resto.pkh;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragmentB extends ListFragment {

	TextView b_received;
	ListView lv_CheckItem;
	List<Restaurants> list;
	List<Restaurants> Glob_List;
	int countr;
	private EffictiveAdpterb adapb;
	private static LayoutInflater mInflater;
	Button A_orderreset;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.fragment_b, container, false);
		
		b_received = (TextView)myFragmentView.findViewById(R.id.b_received);
		A_orderreset = (Button)myFragmentView.findViewById(R.id.orderreset);
		A_orderreset.setOnClickListener(A_orderresetOnClickListener);
		String myTag = getTag();
		// + Glob_List.size()
		((RestoV2Activity)getActivity()).setTabFragmentB(myTag);
		Toast.makeText(getActivity(), 
				"MyFragmentB. Binding_List : ", 
				Toast.LENGTH_LONG).show();
		
		//List<Restaurants> Binding_List=new ArrayList<Restaurants>();
		//Binding_List=Glob_List;
	
		//adapb = new EffictiveAdpterb(this.getActivity(), Binding_List);
		
		//setListAdapter(adapb);
		
		return myFragmentView;
		
	}
	
	OnClickListener A_orderresetOnClickListener
	= new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			/*list.clear();
			adap = new EfficientAdapter(getActivity(), list);
			setListAdapter(adap);*/
			
		 /*List<Restaurants> emptylist=new ArrayList<Restaurants>();
			 Restaurants temprest=new Restaurants();
			 emptylist.add(temprest)
		
			 fragmentB.b_updatList(Selected_Glob_List);;*/
			Glob_List.clear();
			adapb = new EffictiveAdpterb(getActivity(), Glob_List);
			
			setListAdapter(adapb);
			
		}
		};

	
	public void b_updateText(String t){
		b_received.setText(t);
	}
	
	
	public void b_updatList(List<Restaurants> l){
		countr=l.size();
		
	}
	
	
	public void b_setSelectedList(List<Restaurants> l){
		Glob_List=new ArrayList<Restaurants>();
		Glob_List=l;
		b_received.setText(Integer.toString(Glob_List.size()));
		adapb = new EffictiveAdpterb(getActivity(), Glob_List);
		
			setListAdapter(adapb);
		
	}
	
	
	public static class EffictiveAdpterb extends ArrayAdapter<Restaurants>{



		private final List<Restaurants> locallist;
		private final Activity context;

		public EffictiveAdpterb(Activity context, List<Restaurants> lst) {

			super(context, R.layout.adaptor_content, lst);
			this.context = context;
			this.locallist = lst;
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
				convertView = mInflater.inflate(R.layout.adaptor_contentb, null);

				// Creates a ViewHolder and store references to the two children
				// views
				// we want to bind data to.
				holder = new ViewHolder();
				holder.textLine = (TextView) convertView
						.findViewById(R.id.textLine);
				holder.textLine2 = (TextView) convertView
						.findViewById(R.id.textLine2);
				/*holder.buttonLine = (Button) convertView
						.findViewById(R.id.buttonLine);
				holder.editline = (EditText) convertView
						.findViewById(R.id.editLine);
				holder.mycheckbox = (CheckBox) convertView
						.findViewById(R.id.checkBox1);*/

				convertView.setTag(holder);
				holder.textLine.setTag(locallist.get(position));
				holder.textLine2.setTag(locallist.get(position));
			//	holder.mycheckbox.setTag(locallist.get(position));

				

			} else {
			//	holder = (ViewHolder) convertView.getTag();
			//	((ViewHolder) convertView.getTag()).mycheckbox.setTag(locallist
			//			.get(position));
				// ((ViewHolder) view.getTag()).text.setTag(list.get(position));
			}

			ViewHolder Myholder = (ViewHolder) convertView.getTag();
			Myholder.textLine.setText(locallist.get(position).getREST_EMAIL());
			Myholder.textLine2.setText(locallist.get(position)
					.getREST_WEBSITE());
			/*Myholder.mycheckbox
					.setChecked(locallist.get(position).isSelected());*/

			return convertView;

		}

		static class ViewHolder {
			TextView textLine;
			TextView textLine2;
			ImageView iconLine;
			//Button buttonLine;
			//EditText editline;
			//CheckBox mycheckbox;
		}
	}
}
// http://stackoverflow.com/questions/6955863/get-index-if-checked-rows-in-this-customized-listview?rq=1
//http://android-codes-examples.blogspot.com/search/label/onListItemClick
