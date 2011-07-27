package edu.brandeis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MatchMusicActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "MatchMusicActivity";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Setup click listeners for the buttons
        View easybutton = findViewById(R.id.easybutton);
        easybutton.setOnClickListener(this);
        
        View hardbutton = findViewById(R.id.hardbutton);
        hardbutton.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, GamePlay.class);
		switch(v.getId()){
		case R.id.easybutton:
			Log.i(TAG, "easybutton pressed");
			i.putExtra("level", 1);
			startActivity(i);
			break;
		case R.id.hardbutton:
			Log.i(TAG, "hardbutton pressed");
			i.putExtra("level", 2);
			startActivity(i);
			break;
		}
		
		
	}
}