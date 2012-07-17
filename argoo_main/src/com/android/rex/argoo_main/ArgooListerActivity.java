package com.android.rex.argoo_main;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ArgooListerActivity extends TabActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        
        TabHost tabHost = getTabHost();
        
        TabSpec listspec = tabHost.newTabSpec("list");
        listspec.setIndicator("list", getResources().getDrawable(R.drawable.ic_launcher));
        
        Intent listIntent = new Intent(this, Lister.class);
        listspec.setContent(listIntent);

        
        TabSpec mapspec = tabHost.newTabSpec("map");
        mapspec.setIndicator("map", getResources().getDrawable(R.drawable.ic_launcher));
        
        Intent mapIntent = new Intent(this, ArgooMap.class);
        mapspec.setContent(mapIntent);
        
        
        tabHost.addTab(listspec); // Adding photos tab;
        tabHost.addTab(mapspec); // Adding photos tab;
        
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
