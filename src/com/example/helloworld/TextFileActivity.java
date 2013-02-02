package com.example.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextFileActivity extends Activity {

	private EditText editor;
	private Button button;
	private Context context;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textfile);
		editor = (EditText) findViewById(R.id.editText_FileExample);
		button = (Button) findViewById(R.id.button_FileExample);
		button.setOnClickListener(new WriteToFileListener());

		try {
			// insert text file in the assets folder
			// you can't write to the assests folder, it is read-only
			//InputStream in = this.getAssets().open("readme.txt");
			
			// but you can write to the local filesystem
			InputStream in = openFileInput("readme.txt");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String str;
			while ((str = reader.readLine()) != null) {
				editor.append(str + "\n");
			}
			in.close();
			
			/*
			 * another idiom for doing the same thing
			Scanner scanner = new Scanner(openFileInput("readme.txt"));
			while(scanner.hasNextLine()) {
				editor.append(scanner.nextLine());
			}
			scanner.close();
			*/
			
			// there is also the
			// deleteFile()  and fileList() methods to use for file i/o
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class WriteToFileListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			try {
				OutputStream out = openFileOutput("readme.txt", MODE_APPEND);
				OutputStreamWriter writer = new OutputStreamWriter(out);
				writer.write(editor.getText().toString());
				writer.close();
			} catch (Exception e) {

			}
		}
	}
}
