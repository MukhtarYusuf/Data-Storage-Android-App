package com.example.datastorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public final static String FIRST_NAME = "com.mukhtaryusuf.FIRST_NAME";
	public final static String LAST_NAME = "com.mukhtaryusuf.LAST_NAME";
	public final static String ADDRESS = "com.mukhtaryusuf.ADDRESS";
	public final static String CREDIT_DETAILS = "com.mukhtaryusuf.CREDIT_DETAILS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Method to Save Data
	public void save(View view){
		Intent saveIntent = new Intent(this, SaveActivity.class);
		//First Name
		EditText firstName = (EditText) findViewById(R.id.first_name_edit);
    	String sFirstName = firstName.getText().toString();
    	
    	//Last Name
    	EditText lastName = (EditText) findViewById(R.id.last_name_edit);
    	String sLastName = lastName.getText().toString();
    	
    	//Address
    	EditText address = (EditText) findViewById(R.id.address_edit);
    	String sAddress = address.getText().toString();
    	
    	//Credit Details
    	EditText creditDetails = (EditText) findViewById(R.id.credit_details_edit);
    	String sCreditDetails = creditDetails.getText().toString();
    	
    	//Attach Strings to Intent
    	saveIntent.putExtra(FIRST_NAME, sFirstName);
    	saveIntent.putExtra(LAST_NAME, sLastName);
    	saveIntent.putExtra(ADDRESS, sAddress);
    	saveIntent.putExtra(CREDIT_DETAILS, sCreditDetails);
    	
    	//Start Activity
    	startActivity(saveIntent);
	}
	
	//Method to Process Data
	public void process(View view){
		Intent processIntent = new Intent(this, Process.class);
		startActivity(processIntent);
	}
	
	//Method to Report Data
	public void reportData(View view){
		Intent reportIntent = new Intent(this, ReportActivity.class);
		startActivity(reportIntent);
	}
	
	//Method to Close Application
	public void close(View view){
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}
