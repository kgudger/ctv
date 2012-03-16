package utility.classes;

/** Utilitarian interface to specify explicitly the usages for the streamer
 * object class, all public classes are defiend here.  Used simply for 
 * design purposes, not actually required 
 * @author James Koenig
 * @version Preliminary.
 * @category code outlining
 */

public interface streamerInterface {
	/** Method which plays a file as set up by the class
	 * @return true or false, depending on whether playing starts or is possible
	 */
	public boolean play();
	
	/** Method to open a specific address given by a string
	 * @param String object of what to open
	 */
	public void open(String filename);
	
	/** Method to pause, the viewing of a stream, where it can be resumed
	 * later
	 */
	 public void pause();
	 
	/** Method to stop playback, not sure if it'll actually be needed
	 */
	 public void stop();
}
