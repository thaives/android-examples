package com.example.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class CustomViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View customView = new CustomView(this);
		setContentView(customView);
	}
}
