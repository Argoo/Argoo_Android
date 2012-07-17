package com.android.rex.argoo_main;

import java.util.ArrayList;
import java.util.HashMap;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InListerAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList <HashMap<String, String>> data;
	private static LayoutInflater inflater =null;
	
	public InListerAdapter(Activity a, ArrayList<HashMap<String, String>> d){
		activity = a;
		data = d;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
		//return 0;
	}

	public int getViewTypeCount (){
		
		return 2;
	}
	public int getItemViewType(int position){
		if(data.get(position).get("view_type").equals("item"))
			return 0;
		return 1;
	}
	
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		
		return arg0;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View vi = convertView;
		int type = getItemViewType(position);
//		System.out.println("getView " + position+ " type = " + type+ " convertView = " + convertView);
		switch(type){
		case 0:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.in_list_row, null);
			}
			
			TextView info = (TextView)vi.findViewById(R.id.icon_info);		
			ImageView icon = (ImageView)vi.findViewById(R.id.icon_type);
	
			//public school
			if(data.get(position).get("cell_type").equals("1"))
			{
				info.setText("Pulic School");
				icon.setImageResource(R.drawable.public_school);
				break;
			}
			
			//catholic school
			if(data.get(position).get("cell_type").equals("2"))
			{
				info.setText("Catholic School");
				icon.setImageResource(R.drawable.catholic_school);
				break;
			}
			
			if(data.get(position).get("cell_type").equals("3"))
			{
				info.setText("Full-time Kindergarten");
				icon.setImageResource(R.drawable.fulltime_daycare);
				break;
			}
			
			if(data.get(position).get("cell_type").equals("4"))
			{
				info.setText("Junior Kindergarten to Grade six");
				icon.setImageResource(R.drawable.jk6);
				break;
			}

			if(data.get(position).get("cell_type").equals("5"))
			{
				info.setText("Junior Kindergarten to Grade eight");
				icon.setImageResource(R.drawable.jk78);
				break;
			}

			if(data.get(position).get("cell_type").equals("6"))
			{
				info.setText("Grade one to Grade eight");
				icon.setImageResource(R.drawable.jk9_12);
				break;
			}

			if(data.get(position).get("cell_type").equals("7"))
			{
				info.setText("School Ranking");
				icon.setImageResource(R.drawable.checkbox_tick);
				break;
			}
			
			if(data.get(position).get("cell_type").equals("8"))
			{
				info.setText("Rate the app");
				icon.setImageResource(R.drawable.checkbox_tick);
				break;
			}
			if(data.get(position).get("cell_type").equals("9"))
			{
				info.setText("Share with friends");
				icon.setImageResource(R.drawable.checkbox_tick);
				break;
			}
			if(data.get(position).get("cell_type").equals("10"))
			{
				info.setText("Contact us");
				icon.setImageResource(R.drawable.checkbox_tick);
				break;
			}
			if(data.get(position).get("cell_type").equals("11"))
			{
				info.setText("Legal");
				icon.setImageResource(R.drawable.checkbox_tick);
				break;
			}
			

			
			break;
		case 1:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.in_sectionheader, null);
			}
			if(data.get(position).get("cell_type").equals("1"))
			{
				TextView headerinfo = (TextView)vi.findViewById(R.id.in_sectionheader);	
				headerinfo.setText("Symbols interpretion");			
				break;
			}
			if(data.get(position).get("cell_type").equals("2"))
			{
				TextView headerinfo = (TextView)vi.findViewById(R.id.in_sectionheader);	
				headerinfo.setText(" ");
				break;
			}
			
		}
		return vi;

	}


}
