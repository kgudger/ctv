package utility.classes;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

/** Object that will handle or encapsulate the streaming requirements 
 * of the application
 * 
 * TODO 3/15/2012: fix error in play, replace synchronous UI with asynchronous calls to smooth application performance
 * 					and finish the rest of the local methods ~jk
 * 
 * @author James Koenig
 * @version 0.0.c
 * @category wrapper objects
 */

public class Streamer implements streamerInterface 
{
	//local variables
	private MediaPlayer player;	//this is the player object that this class wraps around
	private Context source;		//this class does not implement the Context interface, so it needs one from a parent
	
	//constructors
	public Streamer(Context origin, String target_url)
	{
		source = origin;
		Uri fileStreamUri = Uri.parse(target_url);			//using uri to avoid having to catch errors
		player = MediaPlayer.create(source, fileStreamUri);
	} //end constructor
	
	@Override
	public boolean play() 
	{
		if(player.getAudioSessionId() != 0)  //the documentation clearly states getAudioSessionId exists, probably a version difference issue
		{
			player.start();
			return true;
		}
		else return false;
	} //end play

	@Override
	public void open(String filename) //redefine the contents
	{
		Uri fileStreamUri = Uri.parse(filename);
		player = MediaPlayer.create(source, fileStreamUri);
	} //end open

	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub

	} //end pause

	@Override
	public void stop()
	{
		//TODO method stub
	}// end stop
} //end Streamer
