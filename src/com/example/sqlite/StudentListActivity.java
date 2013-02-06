package com.example.sqlite;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.helloworld.R;

public class StudentListActivity extends ListActivity {

	private StudentDatabase database;
	private SimpleCursorAdapter cursorAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentdb);

		Button button = (Button) findViewById(R.id.buttonDB);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateDatabase(0, true);
			}
		});
		database = new StudentDatabase(this);
		database.open();

		Cursor cursor = database.queryAll();
		startManagingCursor(cursor);

		String[] from = new String[] { StudentDatabase.KEY_NAME,
				StudentDatabase.KEY_SSN };
		int[] to = new int[] { R.id.rowtext, R.id.rowtext2 };
		cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_row,
				cursor, from, to);

		setListAdapter(cursorAdapter);
		registerForContextMenu(getListView());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		database.close();
	}

	public void remove(long rowId) {
		database.deleteRow(rowId);
		cursorAdapter.getCursor().requery();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long rowId) {
		super.onListItemClick(l, v, position, rowId);
		updateDatabase(rowId, false);
	}

	public void updateDatabase(long rowId, boolean create) {
		Intent intent = new Intent(this, StudentUpdateActivity.class);
		if (!create) {
			intent.putExtra("rowID", rowId);
		}
		startActivity(intent);
	}
}
