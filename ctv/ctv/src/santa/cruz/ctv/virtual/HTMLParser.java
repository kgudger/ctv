package santa.cruz.ctv.virtual;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HTMLParser {
	private ArrayList<String> data;
	private ArrayList<Channels> channels;
	public HTMLParser(String URL) {
		channels = new ArrayList<Channels>();
		data = new ArrayList<String>();
		try {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL);
		HttpResponse response = client.execute(request);

		InputStream in = response.getEntity().getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder str = new StringBuilder();
		String line = null;
		while((line = reader.readLine()) != null)
		{
		    str.append(line);
		    data.add(line);
		}
		in.close();
		}
		catch (Exception ex) { }
	}
	public ArrayList<String> getHTML() {
		return data;
	}
	
	public void parseData() {
		int i = 0;
		while(data.size() > i && !data.get(i).contains("Today's Schedule"))//Look for Today's Schedule
			i++;
		i++;
		while(i < data.size() && !data.get(i).contains("</div>"))
		{
			i++;
			while(!data.get(i).contains("</div>"))
			{
				String stuff = data.get(i);
				String name = "";
				String time = "";
				StringTokenizer test = new StringTokenizer(stuff, ">");
				StringTokenizer testThis;
				String buffer = "";
				if(test.hasMoreTokens())
					test.nextToken();
				if(test.hasMoreTokens())
					buffer = test.nextToken();
				testThis = new StringTokenizer(buffer, "<");
				if(testThis.hasMoreTokens())
					time = testThis.nextToken();
				if(test.hasMoreTokens())
					buffer = test.nextToken();
				testThis = new StringTokenizer(buffer, "<");
				if(testThis.hasMoreTokens())
					name = testThis.nextToken();
				i++;
				channels.add(new Channels(time, name));
			}
		}
	}
	
	public String getName(int i) {
		return channels.get(i).getName();
	}
	public String getTime(int i) {
		return channels.get(i).getTime();
	}
	
	public int getSize()
	{
		return channels.size();
	}
	
	public ArrayList<Channels> getChannelData() {
		return channels;
	}
}
