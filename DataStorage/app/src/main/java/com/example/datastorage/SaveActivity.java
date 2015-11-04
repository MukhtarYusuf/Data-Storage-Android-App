package com.example.datastorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class SaveActivity extends Activity {
	
	Intent intent;
	String firstName;
	String lastName;
	String address;
	String creditDetails;
	
	static final String PERSONAL_DETAILS = "com.mukhtaryusuf.save.PERSONAL_DETAILS";
	static final String FIRST_NAME = "com.mukhtaryusuf.save.FIRST_NAME";
	static final String LAST_NAME = "com.mukhtaryusuf.save.LAST_NAME";
	static final String ADDRESS = "com.mukhtaryusuf.save.ADDRESS";
	static final String CREDIT_DETAILS = "com.mukhtaryusuf.save.CREDIT_DETAILS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save);
		
		//Retrieve the Intent
		intent = getIntent();
		firstName = intent.getStringExtra(MainActivity.FIRST_NAME);
		lastName = intent.getStringExtra(MainActivity.LAST_NAME);
		address = intent.getStringExtra(MainActivity.ADDRESS);
		creditDetails = intent.getStringExtra(MainActivity.CREDIT_DETAILS);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.save, menu);
		return true;	
	}
	
	//Method to Save by Preferences
	public void saveByPreference(View view){
		//Get Shared Preference
		Context saveContext = getApplicationContext();
		SharedPreferences pref = saveContext.getSharedPreferences(PERSONAL_DETAILS, MODE_PRIVATE);
		
		//Create Editor
		Editor editor = pref.edit();
		
		//Add values to Shared Preferences File
		editor.putString(FIRST_NAME, firstName);
		editor.putString(LAST_NAME, lastName);
		editor.putString(ADDRESS, address);
		editor.putString(CREDIT_DETAILS, creditDetails);
		editor.commit();
	}
	
	//Method to Save by SQLite
	public void saveBySQL(View view){
		Helper db = new Helper(this);
		Customer customer = new Customer(firstName,lastName,address,creditDetails);
		db.addCustomer(customer);
	}
}
