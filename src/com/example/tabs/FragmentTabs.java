package com.example.tabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.CatActivity;

/**
 * This demonstrates the use of action bar tabs and how they interact
 * with other action bar features.
 */
public class FragmentTabs extends Activity {
	
	private static Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

   
        bar.addTab(bar.newTab()
                .setText("Simple")
                .setTabListener(new TabListener()));
        bar.addTab(bar.newTab()
                .setText("Contacts")
                .setTabListener(new TabListener()));
        bar.addTab(bar.newTab()
                .setText("Apps")
                .setTabListener(new TabListener()));
        bar.addTab(bar.newTab()
                .setText("Throttle")
                .setTabListener(new TabListener()));
        
        if (savedInstanceState != null) {
            bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

    public static class TabListener implements ActionBar.TabListener {

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
            Toast.makeText(context, "Reselected!", Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
            Toast.makeText(context, "Selected!", Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            Toast.makeText(context, "Unselected!", Toast.LENGTH_SHORT).show();

		}
   
    }   
}