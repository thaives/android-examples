package com.example.helloworld;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class WebActivity extends Activity {

	private Button button;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		button = (Button) findViewById(R.id.buttonWebReload);
		// need to add internet user permission for this to work
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(WebActivity.this, description,
						Toast.LENGTH_SHORT).show();
			}
		});

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Random r = new Random();
				int num = r.nextInt(3);
				if (num == 0) {
					webView.loadUrl("http://reddit.com");
				} else if (num == 1) {
					webView.loadUrl("http://reddit.com/r/programming");
				} else {
					webView.loadData("<p><b>Not a website!</b>", "text/html",
							"UTF-8");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_web, menu);
		return true;
	}

}
