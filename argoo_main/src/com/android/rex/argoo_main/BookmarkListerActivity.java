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

public class BookmarkListerActivity extends Activity {

	ListView list;
	BookmarkListAdapter adapter;	
    public static 
            ArrayList<HashMap<String, String>> bookmarked_school_data = new ArrayList<HashMap<String, String>> ();     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bk_list_layout);
/*        
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
        }
        
*/
        list = (ListView)findViewById(R.id.bookmark_list);

        
        adapter=new BookmarkListAdapter(this, bookmarked_school_data);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {
        	
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        		//setTitle("");
                Intent intent = new Intent();
                intent.setClass(view.getContext(), DetailListerActivity.class);
                startActivity(intent);        		
            	
             }
        });        
        
     // Click event for single list row


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
