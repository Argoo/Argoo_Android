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

public class DetailListAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList <HashMap<String, String>> data;
	private static LayoutInflater inflater =null;
	
	public DetailListAdapter(Activity a, ArrayList<HashMap<String, String>> d){
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
		
		return 3;
	}
	public int getItemViewType(int position){
		
		
		if(data.get(position).get("view_type").equals("item1"))
			return 0;

		if(data.get(position).get("view_type").equals("item2"))
			return 1;

		return 2;
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
//		System.out.println("getView " + position+ " type = " + type+ " convertView = " + convertView);
		switch(type){
		case 0:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.sd_list_row_school_info, null);
			}
			

			TextView school_name = (TextView)vi.findViewById(R.id.sd_title); 
			
			
			ImageView school_icon = (ImageView)vi.findViewById(R.id.sd_school_icon);
			ImageView grade_icon = (ImageView)vi.findViewById(R.id.sd_grade_icon);
			ImageView daycare_icon = (ImageView)vi.findViewById(R.id.sd_daycare_icon);
			
			TextView enrollment = (TextView)vi.findViewById(R.id.sd_enrollment);
			TextView sd_address = (TextView)vi.findViewById(R.id.sd_address);
			
			TextView telephone = (TextView)vi.findViewById(R.id.sd_telephone);
			
			/**-------change the icon, text etc according the real info*/
			
				
			break;
		case 1:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.sd_list_row_rank_info, null);
			}
			
			TextView rating_now = (TextView)vi.findViewById(R.id.sd_rating_now); 
			TextView rating_number = (TextView)vi.findViewById(R.id.sd_rating_number); 
			TextView rank_now = (TextView)vi.findViewById(R.id.sd_rank_now); 
			TextView rank_number = (TextView)vi.findViewById(R.id.sd_rank_number); 
			TextView rank_p5 = (TextView)vi.findViewById(R.id.sd_rank_p5); 
			TextView rank_number_p5 = (TextView)vi.findViewById(R.id.sd_rank_number_p5); 
			
			/**-------change the icon, text etc according the real info*/
			break;
		default:
			if(convertView ==null){
				vi=inflater.inflate(R.layout.sd_sectionheader, null);
			}
			
			break;
			
		}
		return vi;

	}

}
