package santa.cruz.ctv.virtual;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class HTMLParserSearch {
	public ArrayList<String> data;
	public int resultsFound;
	public ArrayList<Channels> channels;
	public HTMLParserSearch(String url) {
		data = new ArrayList<String>();
		channels = new ArrayList<Channels>();
		try {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
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
    
    public void parseData() {
    	String buffer = "";
    	String name = "";
    	String time = "";
    	int i = 0;
    	while(!data.get(i).contains("</table>"))
    		i++;
    	while(!data.get(i).contains("Found") && !data.get(i).contains("No results."))
    		i++;
    	if(data.get(i).contains("No results."))
    		return;
    	else
    	{
    		StringTokenizer test = new StringTokenizer(data.get(i), ">");
    		buffer = "";
    		if(test.hasMoreTokens())
    			buffer = test.nextToken();
    		if(test.hasMoreTokens())
    			buffer = test.nextToken();
    		test = new StringTokenizer(buffer, "<");
    		if(test.hasMoreTokens())
    			buffer = test.nextToken();
    		test = new StringTokenizer(buffer, " ");
    		if(test.hasMoreTokens())
    			buffer = test.nextToken();
    		if(test.hasMoreTokens())
    			resultsFound = Integer.parseInt(test.nextToken());
    	}
    	for(i = i+5; i < data.size(); i+=2)
    	{
    		if(data.get(i).contains("</table>"))
    			break;
    		buffer = "";
    		StringTokenizer dataGetter1;
    		StringTokenizer dataGetter2;
    		dataGetter1 = new StringTokenizer(data.get(i), "\"");
    		if(dataGetter1.hasMoreTokens())
    			dataGetter1.nextToken();
    		if(dataGetter1.hasMoreTokens())
    			dataGetter1.nextToken();
    		if(dataGetter1.hasMoreTokens())
    			dataGetter1.nextToken(">");
    		if(dataGetter1.hasMoreTokens())
    			buffer = dataGetter1.nextToken(">");
    		dataGetter2 = new StringTokenizer(buffer, "<");
    		if(dataGetter2.hasMoreTokens())
    			buffer = dataGetter2.nextToken();
    		name = buffer;
    		for(int j = 0; j < 4; j++)
    			if(dataGetter1.hasMoreTokens())
    				dataGetter1.nextToken();
    		if(dataGetter1.hasMoreTokens())
				buffer = dataGetter1.nextToken();
    		dataGetter2 = new StringTokenizer(buffer, "<");
    		if(dataGetter2.hasMoreTokens())
    			buffer = dataGetter2.nextToken();
    		time = buffer;
    		channels.add(new Channels(name, time));
    	}
    }
    
    public ArrayList<Channels> getData() {
    	return channels;
    }
    
    public ArrayList<String> getStuff() {
    	return data;
    }
    
    public int getResultsFound() {
    	return resultsFound;
    }
}