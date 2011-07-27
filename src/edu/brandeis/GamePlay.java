package edu.brandeis;
import java.util.ArrayList;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class GamePlay extends Activity implements OnClickListener {
	private static final String TAG = "GamePlay";
	private ArrayList<String> bands, songs;
	private BandSong bs;
	private int bandselected = -1, songselected = -1;
	
	private MediaPlayer mp;
	
	private static final int[] BANDBUTTON = {
		R.id.b1,
		R.id.b2,
		R.id.b3,
		R.id.b4,
		R.id.b5,
		R.id.b6,
		R.id.b7,
		R.id.b8,
		R.id.b9
	};
	
	private static final int[] SONGBUTTON = {
		R.id.s1,
		R.id.s2,
		R.id.s3,
		R.id.s4,
		R.id.s5,
		R.id.s6,
		R.id.s7,
		R.id.s8,
		R.id.s9
	};
	
	private View[] songviews;
	private View[] bandviews;
	

	@Override
	protected void onCreate(Bundle savedInstanceState){
		Log.i(TAG, "created GamePlay");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamemode);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		//Get the level given by the starting intent
		Bundle extras = getIntent().getExtras();
		int level = 1;
		if(extras != null){
			level = extras.getInt("level");
		}
		
		//Create a new BandSong object
		bs = new BandSong();
		bs.populate(level); //populate the hashmap with the easy level.
		bands = bs.getBands();
		songs = bs.getSongs();
		Log.i(TAG, "bands/songs gotten");
		
		
		//Set up all the buttons
		songviews = new View[9];
		bandviews = new View[9];
		buttonSetUp();
	}
	
	private void buttonSetUp(){
		Log.i(TAG, "button set up started");
		Button temp;
		
		for (int i = 0; i < BANDBUTTON.length; i++){
			bandviews[i] = findViewById(BANDBUTTON[i]);
			bandviews[i].setOnClickListener(this);
			
			
			songviews[i] = findViewById(SONGBUTTON[i]);
			songviews[i].setOnClickListener(this);
			
		}
		
		
		Log.i(TAG, "button set up ended");
	}

	@Override
	public void onClick(View v) {
		
		//Select a band
		for(int i = 0; i < BANDBUTTON.length ; i++){
			if(BANDBUTTON[i] == v.getId()){
				if(bandselected == -1){
					Button temp = (Button) bandviews[i];
					temp.setText(bands.get(i));
					bandselected = i;
				}
			}
		}
		
		//Select a song
		for(int i = 0; i < SONGBUTTON.length ; i++){
			if(SONGBUTTON[i] == v.getId()){
				if(songselected == -1){
					Button temp = (Button) songviews[i];
					temp.setText(songs.get(i));
					songselected = i;
				}
			}
		}
		
		
		
		//check match
		if(songselected!=-1 && bandselected!=-1){
			
			//if a match, make buttons invisible and restart selection
			if(bs.isPartner(bands.get(bandselected), songs.get(songselected))){
				bandviews[bandselected].setVisibility(View.INVISIBLE);
				songviews[songselected].setVisibility(View.INVISIBLE);
				Toast.makeText(getBaseContext(), bands.get(bandselected)+" did sing "+songs.get(songselected), Toast.LENGTH_LONG).show();
				bandselected = -1;
				songselected = -1;
				
			}
			//otherwise, just restart selection
			else{
				Button temp = (Button) bandviews[bandselected];
				temp.setText(" ");
				temp = (Button) songviews[songselected];
				temp.setText(" ");
				Toast.makeText(getBaseContext(), bands.get(bandselected)+" did not sing "+songs.get(songselected), Toast.LENGTH_LONG).show();
				bandselected = -1;
				songselected = -1;
			}
		}
		
	}
	
	
	@Override
	protected void onResume(){
		super.onResume();
		Music.play(this, R.raw.ofashiftingvariety);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		Music.stop(this);
	}
}
