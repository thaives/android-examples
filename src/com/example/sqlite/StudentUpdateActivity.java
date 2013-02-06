package com.example.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.helloworld.R;

public class StudentUpdateActivity extends Activity {

	private StudentDatabase database;
	private Long rowID;

	private EditText editTextName;
	private EditText editTextSSN;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		setContentView(R.layout.activity_updatedb);

		editTextName = (EditText) findViewById(R.id.editTextName);
		editTextSSN = (EditText) findViewById(R.id.editTextSSN);

		rowID = null;

		if (bundle == null) {
			Bundle extras = getIntent().getExtras();
			if (extras != null && extras.containsKey("rowID")) {
				rowID = extras.getLong("rowID");
			}
		} else {
			rowID = bundle.getLong(SAVE_ROW);
		}

		database = new StudentDatabase(this);
		database.open();

		databaseToUI();

		Button button = (Button) findViewById(R.id.buttonSaveDB);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		database.close();
	}

	private void databaseToUI() {
		if (rowID != null) {
			Cursor cursor = database.query(rowID);
			// cursor.getColumnIndex(columnName);
			editTextName.setText(cursor.getString(StudentDatabase.INDEX_NAME));
			editTextSSN.setText(cursor.getString(StudentDatabase.INDEX_SSN));
			cursor.close();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		save();
	}

	private void save() {
		String name = editTextName.getText().toString();
		String ssn = editTextSSN.getText().toString();

		if (rowID != null) {
			database.updateRow(rowID, database.createContentValues(name, ssn));
		} else {
			rowID = database.createRow(database.createContentValues(name, ssn));
		}
	}

	public static final String SAVE_ROW = "saverow";

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putLong(SAVE_ROW, rowID);
	}
}
