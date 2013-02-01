package com.example.helloworld;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class PreferenceActivity extends Activity {

	private CheckBox checkBox;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pref);
		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		checkBox.setOnCheckedChangeListener(new CheckBoxListener());
		button = (Button) findViewById(R.id.pref_button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// goes through onPause(), onStop(), onDestroy()
				finish();
			}
		});
	}

	public class CheckBoxListener implements
			CompoundButton.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (isChecked) {
				checkBox.setText("Preference checkbox: On");
			} else {
				checkBox.setText("Preference checkbox: Off");
			}
		}
	}
	
	public void onResume() {
		super.onResume();
		SharedPreferences settings = getPreferences(0);
		checkBox.setChecked(settings.getBoolean("checkBox_checked", false));
	}
	
	public void onPause() {
		super.onPause();
		SharedPreferences settings = getPreferences(0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("checkBox_checked", checkBox.isChecked());
		editor.commit();
	}
	
	
}
