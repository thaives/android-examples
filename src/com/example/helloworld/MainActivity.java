package com.example.helloworld;

import com.example.customview.CustomViewActivity;
import com.example.multitouch.TouchActivity;
import com.example.sqlite.StudentListActivity;
import com.example.tabs.FragmentTabs;
import com.example.tabs.TabHostActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button10;
	private Button button11;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		MyOnClickListener listener = new MyOnClickListener();
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(listener);
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(listener);
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(listener);
		button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(listener);
		button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(listener);
		button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(listener);
		button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(listener);
		button8 = (Button) findViewById(R.id.button8);
		button8.setOnClickListener(listener);
		button9 = (Button) findViewById(R.id.button9);
		button9.setOnClickListener(listener);
		button10 = (Button) findViewById(R.id.button10);
		button10.setOnClickListener(listener);
		button11 = (Button) findViewById(R.id.button11);
		button11.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public class MyOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View arg0) {
			if (arg0.getId() == R.id.button1) {
				Intent intent = new Intent(context, CatActivity.class);
				startActivity(intent);
			} else if (arg0.getId() == R.id.button2) {
				startActivity(new Intent(context, PreferenceActivity.class));
			} else if (arg0.getId() == R.id.button3) {
				startActivity(new Intent(context, TextFileActivity.class));
			} else if (arg0.getId() == R.id.button4) {
				startActivity(new Intent(context, AnimationActivity.class));
			} else if (arg0.getId() == R.id.button5) {
				startActivity(new Intent(context, AudioActivity.class));
			} else if (arg0.getId() == R.id.button6) {
				startActivity(new Intent(context, WebActivity.class));
			} else if (arg0.getId() == R.id.button7) {
				startActivity(new Intent(context, StudentListActivity.class));
			} else if (arg0.getId() == R.id.button8) {
				startActivity(new Intent(context, CustomViewActivity.class));
			} else if (arg0.getId() == R.id.button9) {
				startActivity(new Intent(context, TabHostActivity.class));
			} else if (arg0.getId() == R.id.button10) {
				startActivity(new Intent(context, FragmentTabs.class));
			} else if (arg0.getId() == R.id.button11) {
				startActivity(new Intent(context, TouchActivity.class));
			}
		}
	}

}
