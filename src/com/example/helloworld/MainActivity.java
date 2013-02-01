package com.example.helloworld;

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
	private Button button5;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new MyOnClickListener());
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new MyOnClickListener());
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new MyOnClickListener());
		button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new MyOnClickListener());
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
			} else if (arg0.getId() == R.id.button5) {
				startActivity(new Intent(context, AudioActivity.class));
			}
		}
	}

}
