package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.example.helloworld.CatActivity;
import com.example.helloworld.R;

/*
 * Example from
 * http://developer.android.com/guide/topics/ui/layout/tabs.html
 *   
 */
public class TabHostActivity extends Activity {

	private TabHost tabHost;
	private Intent intent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		intent = new Intent().setClass(this, CatActivity.class);
		setContentView(R.layout.activity_tabhost);
		tabHost = (TabHost) findViewById(R.id.tabHost);
		tabHost.setup();
		TabSpec spec1 = tabHost.newTabSpec("First Tab");
		spec1.setIndicator("First Tab");
		spec1.setContent(R.id.tab1);
		
		TabSpec spec2 = tabHost.newTabSpec("Second Tab");
		spec2.setIndicator("Second Tab");
		spec2.setContent(R.id.tab2);
		
		TabSpec spec3 = tabHost.newTabSpec("Third Tab");
		spec3.setIndicator("Third Tab");
		spec3.setContent(R.id.tab3);
		
		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		
	}

}