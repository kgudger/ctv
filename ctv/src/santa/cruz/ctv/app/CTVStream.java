package santa.cruz.ctv.app;

import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

/** Wrapper class to allow for multiple stream activities to be created from one stream object
 *  The streaming in this case is entirely a text box, so the application assumes that the user has
 *  flash installed, which is not installed on the emulator.
 * 
 * @author James Koenig
 * @version 1.0
 */
public class CTVStream extends Activity 
{
	//local data
	private String information = "";
	private WebDownloadTask task = null ;

	//methods
    @Override
    public void onCreate(Bundle savedInstanceState) {          

        super.onCreate(savedInstanceState);    
        setContentView(R.layout.ctv1stream);
		
		//code to parse the Bundle here
		Bundle bundle = getIntent().getExtras();
		int i = bundle.getInt("santa.cruz.ctv.app.stream_data");
		setInformation(i);
		
		//TextView viewText = (TextView) findViewById(R.id.debugText);
		//viewText.setText(""+bundle.getInt("santa.cruz.ctv.app.stream_data"));
	} //end onCreate
	
	private void setInformation(int x)
	{
		String result = "file:///android_asset/wrapper";
		switch(x)
		{
			case 1:
				result += ".html";
				break;
			case 2:
				result += "2.html";
				break;
			default:
				result += "3.html";
				break;
		} //end switch
		information = result;
	} //end setInformation 

	private class WebDownloadTask extends AsyncTask<String,Void,Long>{
		protected Long doInBackground(String... urls) {
			WebView web = (WebView) null ;
			long totalSize = 1 ;
			//--set up the web view component
			web = (WebView) findViewById(R.id.webView);
			//enable javascript, but don't allow it to open windows
			web.getSettings().setJavaScriptEnabled(true);
			web.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
			//enable plugins so people can use flash
			web.getSettings().setPluginsEnabled(true);
			//don't support multiple windows in the webview
			web.getSettings().setSupportMultipleWindows(false);
			//don't allow zooming
			web.getSettings().setSupportZoom(false);
			//don't allow either scrollbar
			web.setVerticalScrollBarEnabled(false);
			web.setHorizontalScrollBarEnabled(false);
			
			web.loadUrl(information);
			return totalSize;
		}
		protected void onCancelled(boolean mayInterruptRunning) {
			WebView web = (WebView) null ;
		}
	}
/*	@Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
		//load the web view component
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
//        web.stopLoading ();
    	task.cancel(true);
    }*/
	
	@Override
    protected void onStart() {
        super.onStart();
        // Another activity is taking focus (this activity is about to be "paused").
    	task = new WebDownloadTask();
    	task.execute(information);
    }
    @Override
    protected void onStop() {
        super.onStop();
        // Another activity is taking focus (this activity is about to be "paused").
//        web.stopLoading ();
//        web = (WebView) null ;
    	task.cancel(true);
    	task = null ;
    	     }
} //end CTVStream
