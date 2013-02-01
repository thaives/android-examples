package com.example.helloworld;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class AudioActivity extends Activity implements OnClickListener {

	private MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audio);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		findViewById(R.id.buttonAudio1).setOnClickListener(this);
		findViewById(R.id.buttonAudio2).setOnClickListener(this);
		findViewById(R.id.buttonAudio3).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id;
		if (v.getId() == R.id.buttonAudio1) {
			id = R.raw.champion;
		} else if (v.getId() == R.id.buttonAudio2) {
			id = R.raw.eum;
		} else  { //if (v.getId() == R.id.buttonAudio3) {
			id = R.raw.mburger;
		}
		if(mp != null) {
			mp.release();
		}
		mp = MediaPlayer.create(this,id);
		mp.start();
	}

}
