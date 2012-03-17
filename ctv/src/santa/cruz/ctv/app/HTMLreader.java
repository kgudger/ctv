package santa.cruz.ctv.app;

//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;

//import android.content.Context;
//import android.net.http.AndroidHttpClient;


public class HTMLreader {
	
//	private  String resultString = null; 
	
	public static String readStream(InputStream in) throws IOException 
	  { 
	        StringBuilder sb = new StringBuilder(); 
	        BufferedReader r = new BufferedReader(new InputStreamReader(in), 
	1000); 
	        for (String line = r.readLine(); line != null; line = r.readLine()) 
	        { 
	                sb.append(line).append("\n"); 
	        } 
	        in.close(); 
	        return sb.toString(); 
	  } 

	public HTMLreader(String target_url) throws IOException
	{

		URL url = new URL(target_url);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		try {
//			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//			resultString = readStream(in);
		}
		finally {
	    	urlConnection.disconnect();
		}
	 }
}
