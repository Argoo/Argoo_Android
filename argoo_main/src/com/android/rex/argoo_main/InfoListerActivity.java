package com.android.rex.argoo_main;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class InfoListerActivity extends Activity {

	ListView list;
	InListerAdapter adapter;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_activity);
        
        ArrayList<HashMap<String, String>> source_data = new ArrayList<HashMap<String, String>> ();   
        
        HashMap<String, String> map0 = new HashMap<String, String>();
        map0.put("view_type","header");
        map0.put("cell_type", "1"); ///first header ("symbols interpretion");
        source_data.add(map0);
        for(int i=1; i<8; i++)
        {
	        HashMap<String, String> map1 = new HashMap<String, String>();
	    	map1.put("view_type","item");
	        map1.put("cell_type",String.valueOf(i));
	        source_data.add(map1);
        }
        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("view_type","header");
        map2.put("cell_type", "2"); ///first header ("symbols interpretion");
        source_data.add(map2);
        
        for( int j = 8; j < 12; j++)
        {
	        HashMap<String, String> map3 = new HashMap<String, String>();
	    	map3.put("view_type","item");
	        map3.put("cell_type",String.valueOf(j));
	        source_data.add(map3);
        	
        }
        
        list = (ListView)findViewById(R.id.in_listView1);
        adapter = new InListerAdapter(this, source_data);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {
        	
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
             }
        });
      
        
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
