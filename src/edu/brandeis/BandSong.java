package edu.brandeis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * Creates the backend of the game.
 * Connecting Songs and bands
 * @author Jackie
 *
 */
public class BandSong {
	HashMap<String, String> bandsong;
	
	/**
	 * Constructor instantiates the HashMap of bands to songs
	 */
	public BandSong(){
		bandsong = new HashMap<String,String>();
	}
	
	
	/**
	 * Populates the game (the strings) based on easy or hard level
	 * @param level
	 */
	public void populate(int level){
		bandsong.clear();
		
		if(level==1){
			easyput();
		}else if (level == 2){
			hardput();
		}
	}
	
	
	/**
	 * Easyput is the easy game.  Mainly oldies and top40s
	 */
	public void easyput(){
		bandsong.put("Beach Boys", "Good Vibrations");
		bandsong.put("The Who", "Pinball Wizard");
		bandsong.put("The Beatles", "A Hard Day's Night");
		bandsong.put("The Four Seasons", "Oh What A Night");
		bandsong.put("The Temptations", "My Girl");
		bandsong.put("Katy Perry", "Firework");
		bandsong.put("Lady Gaga", "Just Dance");
		bandsong.put("Kermit", "It's not easy being green");
		bandsong.put("Nirvana", "Smells Like Teen Spirit");
	}
	
	
	/**
	 * Hardput is the harder game, indie stuff
	 */
	public void hardput(){
		bandsong.put("Future Islands", "An Apology");
		bandsong.put("Surfer Blood", "Swim");
		bandsong.put("Twin Shadow", "Castle in the Snow");
		bandsong.put("Yeasayer", "Ambling Alp");
		bandsong.put("Givers", "Saw You First");
		bandsong.put("Two Door Cinema Club", "Undercover Martyn");
		bandsong.put("The Antlers", "Sylvia");
		bandsong.put("Darwin Deez", "Up in the Clouds");
		bandsong.put("Titus Andronicus", "No Future Part III");
	}
	
	
	/**
	 * Gets the Set of band strings
	 * Shuffles them as well
	 * 
	 * @return ArrayList of randomized bands
	 */
	public ArrayList<String> getBands(){
		ArrayList<String> bands = new ArrayList<String>();
		bands.addAll(bandsong.keySet());
		Collections.shuffle(bands);
		return bands;
	}
	
	
	/**
	 * Gets the collection of song strings
	 * Shuffle them, as well.
	 * 
	 * @return ArrayList of randomized songs
	 */
	public ArrayList<String> getSongs(){
		ArrayList<String> songs = new ArrayList<String>();
		songs.addAll(bandsong.values());
		Collections.shuffle(songs);
		return songs;
	}
	
	
	/**
	 * Checks to see if a band and a song are 'partners'
	 * 
	 * @param band
	 * @param song
	 * @return
	 */
	public boolean isPartner(String band, String song){
		if(bandsong.get(band).equals(song)){
			return true;
		}else{
			return false;
		}
	}

}
