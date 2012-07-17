package com.android.rex.argoo_main;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Lister extends ListActivity {
	ListView list;
    LazyAdapter adapter;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        ArrayList<HashMap<String, String>> source_data = new ArrayList<HashMap<String, String>> ();     
        
        for(int i = 1; i < 10; i++){
        	HashMap<String, String> map1 = new HashMap<String, String>();
        	map1.put("view_type","item");
            map1.put("school_type","type1");
            map1.put("grade_type","7_8");
            map1.put("school_type","type1");
            
            map1.put("school_name","test school 1");
            map1.put("distance","2.3 km");
            map1.put("rank","25/223");
            source_data.add(map1);
            
            if(i%4 == 0){
                HashMap<String, String> map2 = new HashMap<String, String>();
                map2.put("view_type","section_header");
                map2.put("school_type","type2");
                map2.put("grade_type","7_9");
                
                map2.put("school_name","test school 2");
                
                map2.put("distance","3.3 km");
                map2.put("rank","40/223");
                
                source_data.add(map2);                 	
            }
        }
        

        //list = (ListView)findViewById(R.id.list);
        list = getListView();
        
        adapter=new LazyAdapter(this, source_data);
        list.setAdapter(adapter);
        
     // Click event for single list row


    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent();
        intent.setClass(this, DetailListerActivity.class);
        startActivity(intent);
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
