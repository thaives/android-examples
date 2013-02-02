package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class AnimationActivity extends Activity {

	private Button animationButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		animationButton = (Button) findViewById(R.id.animationButton);
		animationButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				animate();
			}
		});

	}

	public void animate() {

		Animation animation = AnimationUtils.loadAnimation(this,
				R.animator.simple_animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationStart(Animation arg0) {
			}

		});

		animationButton.startAnimation(animation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_animation, menu);
		return true;
	}

}
