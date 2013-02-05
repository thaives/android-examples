package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDatabase {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "studentdb";
	public static final String DATABASE_TABLE = "student";

	public static final String KEY_ROWID = "_id";
	public static final int INDEX_ROWID = 0;
	public static final String KEY_NAME = "name";
	public static final int INDEX_NAME = 1;
	public static final String KEY_SSN = "ssn";
	public static final int INDEX_SNN = 2;

	public static final String[] KEYS_ALL = { StudentDatabase.KEY_ROWID,
			StudentDatabase.KEY_NAME, StudentDatabase.KEY_SSN };

	private Context context;
	private SQLiteDatabase database;
	private StudentDatabaseHelper helper;

	public StudentDatabase(Context context) {
		this.context = context;
	}

	public void open() throws SQLException {
		helper = new StudentDatabaseHelper(context);
		database = helper.getWritableDatabase();
	}

	public void close() {
		helper.close();
		helper = null;
		database = null;
	}

	public long createRow(ContentValues values) {
		return database.insert(DATABASE_TABLE, null, values);
	}

	public boolean updateRow(long rowId, ContentValues values) {
		return database.update(DATABASE_TABLE, values,
				StudentDatabase.KEY_ROWID + "=" + rowId, null) > 0;
	}

	public boolean deleteRow(long rowId) {
		return database.delete(DATABASE_TABLE, StudentDatabase.KEY_ROWID + "="
				+ rowId, null) > 0;
	}
	
	

	private static class StudentDatabaseHelper extends SQLiteOpenHelper {

		private static final String DATABASE_CREATE = "create table "
				+ DATABASE_TABLE + " (" + StudentDatabase.KEY_ROWID
				+ " integer primary key autoincrement, "
				+ StudentDatabase.KEY_NAME + " text not null, "
				+ StudentDatabase.KEY_SSN + " integer " + ");";

		public StudentDatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

		}

	}

}
