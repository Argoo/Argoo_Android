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

public class LazyAdapter extends BaseAdapter {
	private Activity activity;
	private ArrayList <HashMap<String, String>> data;
	private static LayoutInflater inflater =null;
	
	public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d){
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
		HashMap<String, String> school_data = new HashMap<String, String>();
		school_data = data.get(position);
		int type = getItemViewType(position);

		switch(type){
		case 0:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.list_row, null);
			}
			
			TextView rank1 = (TextView)vi.findViewById(R.id.rank);
			TextView school_name = (TextView)vi.findViewById(R.id.title); 
			TextView distance = (TextView)vi.findViewById(R.id.distance);
			
			ImageView school_icon = (ImageView)vi.findViewById(R.id.school_icon);
			ImageView grade_icon = (ImageView)vi.findViewById(R.id.grade_icon);
			ImageView daycare_icon = (ImageView)vi.findViewById(R.id.daycare_icon);
			
			school_name.setText(school_data.get("school_name"));
			distance.setText(school_data.get("distance"));
			rank1.setText(school_data.get("rank"));
			
			if(school_data.get("school_type").equals("type1")){
				school_icon.setImageResource(R.drawable.catholic_school);
			}else{
				school_icon.setImageResource(R.drawable.public_school);
			}
			
			if(school_data.get("grade_type").equals("7_8")){
				grade_icon.setImageResource(R.drawable.jk78);
			}else{
				grade_icon.setImageResource(R.drawable.jk6);
			}			
			break;
		case 1:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.sectionheader, null);
			}
			break;
			
		}
		return vi;

	}

}
