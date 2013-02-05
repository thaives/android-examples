package com.example.helloworld;

import java.util.Random;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebActivity extends Activity {

	private Button button;
	private WebView webView;
	private ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		button = (Button) findViewById(R.id.buttonWebReload);
		// need to add internet user permission for this to work
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(WebActivity.this, description,
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				if (progress != null && progress.isShowing())
					progress.dismiss();
			}

		});

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				progress = ProgressDialog.show(WebActivity.this, "Progress", "Loading...", true, true);
				Random r = new Random();
				int num = r.nextInt(3);
				if (num == 0) {
					webView.loadUrl("http://www.cnn.com");
				} else if (num == 1) {
					webView.loadUrl("http://www.guardian.co.uk");
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
