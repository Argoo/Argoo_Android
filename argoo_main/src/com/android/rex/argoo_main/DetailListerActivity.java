package com.android.rex.argoo_main;

import java.util.ArrayList;
import java.util.HashMap;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DetailListerActivity extends Activity {
	ListView list;
	DetailListAdapter adapter;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_main);

        
        ArrayList<HashMap<String, String>> source_data = new ArrayList<HashMap<String, String>> ();     
        
 
        	HashMap<String, String> map1 = new HashMap<String, String>();
        	map1.put("view_type","item1");

            source_data.add(map1);
            

            HashMap<String, String> map2 = new HashMap<String, String>();
            map2.put("view_type","section_header");
            source_data.add(map2);                 	
 
            HashMap<String, String> map3 = new HashMap<String, String>();
            map3.put("view_type","item2");
            source_data.add(map3);                 	
        

        list = (ListView)findViewById(R.id.ds_listview1);
        //list = getListView();
        
        adapter=new DetailListAdapter(this, source_data);
        list.setAdapter(adapter);
        

        
     // Click event for single list row

        list.setOnItemClickListener(new OnItemClickListener() {
        	
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        		setTitle("");
            	
             }
        });

    }
    
    public void onBookmarkClick(View view){
    	//add current school information here;
    	HashMap<String, String> map1 = new HashMap<String, String>();
    	map1.put("view_type","item");
        map1.put("school_type","type1");
        map1.put("grade_type","7_8");
        map1.put("school_type","type1");
        
        map1.put("school_name","test school 1");
        map1.put("distance","2.3 km");
        map1.put("rank","25/223");
        
        ///make sure no repeated school information!
        BookmarkListerActivity.bookmarked_school_data.add(map1);    	
    }    
           
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_main, menu);
	    return true;
	}    
	public void info_lister(){
		Intent intent = new Intent();
		intent.setClass(this, InfoListerActivity.class);
		startActivity(intent);
	}
	public void bk_lister(){
		Intent intent = new Intent();
		intent.setClass(this, BookmarkListerActivity.class);
		startActivity(intent);
		
	}
	
	public void home_clicked(){
		Intent intent = new Intent();
		intent.setClass(this, Argoo_mainActivity.class);
		startActivity(intent);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.home_item:
	        	home_clicked();
	        	return true;
	        case R.id.bookmark_item:
	        	bk_lister();
	        	return true;
	        case R.id.info_item:
	        	info_lister();
	            return true;        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    

	}		
}
