package com.example.datastorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Process extends Activity {
	TextView textViewTimer;
	RadioButton successBtn;
	RadioButton failedBtn;
	Button completeBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_process);
		//Access Widgets
		textViewTimer = (TextView) this.findViewById(R.id.text_view_timer);
		successBtn = (RadioButton) this.findViewById(R.id.success);
		failedBtn = (RadioButton) this.findViewById(R.id.failed);
		completeBtn = (Button) this.findViewById(R.id.complete);
		//Set Visibility of Some Widgets to Invisible
		successBtn.setVisibility(View.INVISIBLE);
		failedBtn.setVisibility(View.INVISIBLE);
		completeBtn.setVisibility(View.INVISIBLE);
		
		Timer timer = new Timer(20000, 1000);
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.process, menu);
		return true;
	}
	
	public void complete(View view){
		Intent completeIntent = new Intent(this,MainActivity.class);
		startActivity(completeIntent);
	}
	
	public class Timer extends CountDownTimer{
		public Timer(long timeLeft,long interval){
			super(timeLeft,interval);
		}
		
		@Override
		public void onTick(long timeLeft){
			textViewTimer.setText("Time Left: " + timeLeft/1000);
		}
		
		@Override
		public void onFinish(){
			textViewTimer.setText("Result:");
			
			//Generate Random Result
			boolean result = Math.random() > 0.4;
			
			//Check Radio Button Based on Randomly Generated Result
			if(result){
				successBtn.setChecked(result);
				failedBtn.setChecked(!result);
			}
			else{
				successBtn.setChecked(result);
				failedBtn.setChecked(!result);
			}
			//Make Widgets Visible Again
			successBtn.setVisibility(View.VISIBLE);
			failedBtn.setVisibility(View.VISIBLE);
			completeBtn.setVisibility(View.VISIBLE);
			
		}
	}
	
}
