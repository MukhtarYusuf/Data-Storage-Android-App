package com.example.datastorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ReportActivity extends Activity {

	TextView test;
	TextView displaySql;
	String testString = "First Name: ";
	String sqlResult = "";
	String defaultString = "Default Value";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
		test = (TextView) this.findViewById(R.id.hello_world);
		displaySql = (TextView) this.findViewById(R.id.display_sql_result);
		
		Context saveContext = getApplicationContext();
		SharedPreferences pref = saveContext.getSharedPreferences(SaveActivity.PERSONAL_DETAILS, MODE_PRIVATE);
		testString += pref.getString(SaveActivity.FIRST_NAME, defaultString) + "\n";
		testString += "Last Name: " + pref.getString(SaveActivity.LAST_NAME, defaultString) + "\n";
		testString += "Address: " + pref.getString(SaveActivity.ADDRESS, defaultString) + "\n";
		testString += "Credit Details: " + pref.getString(SaveActivity.CREDIT_DETAILS, defaultString);
		
		test.setText(testString);
		
		//SQLite Code
		Helper helper = new Helper(this);
		SQLiteDatabase db = helper.getReadableDatabase();
		String query = "SELECT * FROM contacts";
		Cursor c = db.rawQuery(query, null);
		c.moveToFirst();
		int counter = 1;
		do{
			sqlResult += "Record No: " + counter + "\n";
			sqlResult += "First Name: " + c.getString(1) + "\n";
			sqlResult += "Last Name: " + c.getString(2) + "\n";
			sqlResult += "Address:" + c.getString(3) + "\n";
			sqlResult += "Credit Details: " + c.getString(4) + "\n\n";
			
			counter++;
		}while(c.moveToNext());
	
		displaySql.setText(sqlResult);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
		return true;
	}
	
	public void done(View view){
		Intent completeIntent = new Intent(this,MainActivity.class);
		startActivity(completeIntent);
	}

	
}
