package com.android.rex.argoo_main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Argoo_mainActivity extends Activity {
    /** Called when the activity is first created. */


	
	// used for get current locaton
	private LocationManager lm;
	private LocationListener ll = new MyLocationListener();
	private boolean gps_enable = false;
	private boolean network_enable = false;
	
	// used for store current or converted coordinate from input
	private String londitude; 
	private String latitude;
	double dlonditude;
	double dlatitude;

	// used for user credit point
	private ProgressBar bar;
	final public static int MAXPOINT = 100;//progress bar max value;
	static int currentpoint = 0; //progress current point;
	private TextView tv; // to display text info about user credit point.
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lm = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        AutoCompleteTextView autoCompView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        autoCompView.setAdapter(new PlacesAutoCompleteAdapter(this, R.layout.autocomplete_textview));

        
    }
    
    public void onClickSearchButton(View view){
    	
    	/** ----- here to get input address 
    	
    	EditText et = (EditText)findViewById(R.id.editText1);
    	
    	CharSequence address = et.getText();
    	**/
    	
    	/** -- convert to adress to coordinate
    	getLatLong(getLocationInfo(address.toString()));
    	londitude = Double.toString(dlonditude);
    	latitude = Double.toString(dlatitude) ;
    	setTitle("Longitude: "+ londitude+" Latitude: "+ latitude);
    	*/
    	
    	/** --- detect the user points
    	bar = (ProgressBar)findViewById(R.id.progressBar1);
    	bar.setMax(MAXPOINT);
    	bar.setProgress(currentpoint++);
    	
    	tv = (TextView)findViewById(R.id.textView1);
    	tv.setText(String.valueOf(currentpoint)+ " of 100");
    	*/

    	/** when click on the button, switch to ArgooLister view*/
    	Intent intent = new Intent();
    	intent.setClass(this, ArgooListerActivity.class);
    	startActivity(intent);
    }
    
    
    /** -- get current location from network or GPS provider*/
    public void onClickCurrentLocation(View view){
    	
    	/*
    	try{
    		gps_enable = lm.isProviderEnabled(lm.GPS_PROVIDER);
    	}catch(Exception ex){
    	}

    	try{
    		network_enable = lm.isProviderEnabled(lm.NETWORK_PROVIDER);
    	}catch(Exception ex){
    	}
    	
    	if(!gps_enable && !network_enable){
    		AlertDialog.Builder builder = new Builder(this);
    		builder.setTitle("Attention!");
    		builder.setMessage("Sorry, location is not determined. Please enable location providers");

    		builder.setPositiveButton("OK", (OnClickListener) this);   		
    		builder.setNeutralButton("Cancel", (OnClickListener) this);
    		builder.create().show();
    		
    	}
    	if (gps_enable) {
    		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
    		}
    		if (network_enable) {
    		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
    		}
    		*/
    	/*--- a test clause */
    	/*
    		setTitle(londitude+"  "+ latitude);
    		*/
    	
    	
    	/** when click on the button, switch to ArgooLister view*/
    	Intent intent = new Intent();
    	intent.setClass(this, ArgooListerActivity.class);
    	startActivity(intent);    	
    }
    public class MyLocationListener implements LocationListener {

    	public void onLocationChanged(Location location) {
    		// TODO Auto-generated method stub
    		if (location != null) {
    			// This needs to stop getting the location data and save the battery power.
    			lm.removeUpdates(ll);
    		
    			londitude = "Longitude: " + location.getLongitude();
    			latitude = "Latitude: " + location.getLatitude();
//    			String altitiude = "Altitiude: " + location.getAltitude();
//    			String accuracy = "Accuracy: " + location.getAccuracy();
//    			String time = "Time: " + location.getTime();
    			
//    			editTextShowLocation.setText(londitude + "\n" + latitude + "\n" + altitiude + "\n" + accuracy + "\n" + time);

    			}
    	}

    	public void onProviderDisabled(String arg0) {
    		// TODO Auto-generated method stub

    	}

    	public void onProviderEnabled(String arg0) {
    		// TODO Auto-generated method stub

    	}

    	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
    		// TODO Auto-generated method stub

    	}

    }    
    
    public JSONObject getLocationInfo(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        try {

        address = address.replaceAll(" ","%20");    

        HttpPost httppost = new HttpPost("http://maps.google.com/maps/api/geocode/json?address=" + address + "&sensor=false");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        stringBuilder = new StringBuilder();


            response = client.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(stringBuilder.toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonObject;
    }
    
    public boolean getLatLong(JSONObject jsonObject) {

        try {

        	dlonditude = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location")
                .getDouble("lng");

            dlatitude = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location")
                .getDouble("lat");

        } catch (JSONException e) {
            return false;

        }

        return true;
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
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.home_item:
	        	return super.onOptionsItemSelected(item);
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