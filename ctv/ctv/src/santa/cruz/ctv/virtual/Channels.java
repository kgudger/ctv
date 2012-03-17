package santa.cruz.ctv.virtual;



public class Channels {
	private String name;
	private String time;
	
	public Channels() {
		
	}
	
	public Channels(String name, String time) {
		this.name = name;
		this.time = time;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}
