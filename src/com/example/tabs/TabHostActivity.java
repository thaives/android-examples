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
 * 
 * http://developer.android.com/guide/topics/ui/layout/tabs.html
 * 
 */
public class TabHostActivity extends Activity {

	private TabHost tabHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabhost);
		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup();
		Intent intent = new Intent().setClass(this, CatActivity.class);
		TabSpec spec1 = tabHost.newTabSpec("First Tab");
		spec1.setIndicator("First Tab");
		spec1.setContent(intent);
		TabSpec spec2 = tabHost.newTabSpec("Second Tab").setContent(intent);
		//spec2.setIndicator("Second Tab");
		//spec2.setContent(R.id.tab2);
		TabSpec spec3 = tabHost.newTabSpec("Third Tab");
		spec3.setIndicator("Third Tab");
		spec3.setContent(intent);
		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);

		/*
		 * super.onCreate(savedInstanceState);
		 * setContentView(R.layout.activity_tabhost2);
		 * 
		 * Resources res = getResources(); // Resource object to get Drawables
		 * TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
		 * TabHost.TabSpec spec; // Resusable TabSpec for each tab Intent
		 * intent; // Reusable Intent for each tab
		 * 
		 * // Create an Intent to launch an Activity for the tab (to be reused)
		 * intent = new Intent().setClass(this, .class);
		 * 
		 * // Initialize a TabSpec for each tab and add it to the TabHost spec =
		 * tabHost .newTabSpec("artists") .setIndicator("Artists",
		 * res.getDrawable(R.drawable.ic_tab_artists)) .setContent(intent);
		 * tabHost.addTab(spec);
		 * 
		 * // Do the same for the other tabs intent = new
		 * Intent().setClass(this, AlbumsActivity.class); spec = tabHost
		 * .newTabSpec("albums") .setIndicator("Albums",
		 * res.getDrawable(R.drawable.ic_tab_albums)) .setContent(intent);
		 * tabHost.addTab(spec);
		 * 
		 * intent = new Intent().setClass(this, SongsActivity.class); spec =
		 * tabHost .newTabSpec("songs") .setIndicator("Songs",
		 * res.getDrawable(R.drawable.ic_tab_songs)) .setContent(intent);
		 * tabHost.addTab(spec);
		 * 
		 * tabHost.setCurrentTab(2);
		 */

	}

}