package santa.cruz.ctv.app;

import java.util.ArrayList;

import santa.cruz.ctv.virtual.Channels;
import santa.cruz.ctv.virtual.HTMLParser;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
public class ScheduleView extends Activity {
	private String url = "";
	private Handler mHandler;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.schedule);
	        
	        Bundle bundle = getIntent().getExtras();
			int i = bundle.getInt("santa.cruz.ctv.app.stream_data");
			switch(i) {
			case 4:
				url = "http://63.249.112.96/cablecast/public/Main.aspx?ChannelID=1";
				break;
			case 5:
				url = "http://63.249.112.96/cablecast/public/Main.aspx?ChannelID=2";
				break;
			case 6:
				url = "http://63.249.112.96/cablecast/public/Main.aspx?ChannelID=3";
				break;
			}
			
	        mHandler = new Handler();
	        mHandler.post(new Runnable() {
	        	public void run() {
	            	HTMLParser subject = new HTMLParser(url);
	            	subject.parseData();
	            	final TextView textViewToChange = (TextView)findViewById(R.id.text1);
	            	ArrayList<Channels> channels = subject.getChannelData();
	            	String another = "";
	            	for(Channels i : channels)
	            	{
	            		another += (i.getName()+" "+i.getTime()+"\n\n");
	            	}
	            	textViewToChange.setText(another);
	           }
	       });
	 }
}