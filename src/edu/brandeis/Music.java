package edu.brandeis;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
   private static MediaPlayer mp = null;
   private static MediaPlayer mpsingle = null;

   
   /** Stop old song and start new one */
   public static void play(Context context, int resource) {
      stop(context);

         mp = MediaPlayer.create(context, resource);
         mp.setLooping(true);
         mp.start();
   }
   
   /** Stop old song and start new one - Music Does not loop*/
   public static void playMe(Context context, int resource) {
	   stop(context);
         mpsingle = MediaPlayer.create(context, resource);
         mpsingle.setLooping(false);
         mpsingle.start();
   }
   

   /** Stop the music */
   public static void stop(Context context) { 
      if (mp != null) {
         mp.stop();
         mp.release();      
         mp = null;
      }
      if (mpsingle != null){
    	  mpsingle.stop();
    	  mpsingle.release();
    	  mpsingle = null;
      }
   }
}