package com.wunkoteam.testing.testproj;


import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

public class TestActivity extends PreferenceActivity {
	
	Button btn_Test;
	TextView tv_StatusView;
	Intent mIntent;
	Context context;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // making a simple toast to see this this commit thing does a good job
        Toast.makeText(this, "this is a small toast thing",Toast.LENGTH_LONG);
        try{
        setContentView(R.layout.main);
        }catch(Exception e){
        	Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT ).show();
        }
        Button editPrefs = (Button) findViewById(R.id.prefButton);
        editPrefs.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent myIntent = new Intent(getApplicationContext(), SetPrefs.class);
                   startActivityForResult(myIntent, 0);
               }

       });
       Button showPrefs = (Button) findViewById(R.id.showButton);
       showPrefs.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent myIntent = new Intent(getApplicationContext(), ShowPrefs.class);
                   startActivityForResult(myIntent, 0);
               }

       });
        
 
    }
    
    
    
    

    
}