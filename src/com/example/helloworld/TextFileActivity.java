package com.example.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class TextFileActivity extends Activity {

	private EditText editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textfile);
		editor = (EditText) findViewById(R.id.editText1);

		try {
			// insert text file in the assets folder
			InputStream in = this.getAssets().open("readme.txt");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String str;
			while ((str = reader.readLine()) != null) {
				editor.append(str + "\n");
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
