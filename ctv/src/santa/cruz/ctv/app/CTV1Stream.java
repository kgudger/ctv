package santa.cruz.ctv.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CTV1Stream extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {          

        super.onCreate(savedInstanceState);    
        setContentView(R.layout.ctv1stream);
          
            WebView web = (WebView) findViewById(R.id.webView);
            web.getSettings().setJavaScriptEnabled(true); 
            web.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
            web.getSettings().setPluginsEnabled(true);
            web.getSettings().setSupportMultipleWindows(false);
            web.getSettings().setSupportZoom(false);
            web.setVerticalScrollBarEnabled(false);
            web.setHorizontalScrollBarEnabled(false);
     
            //Our application's main page will be loaded
            web.loadUrl("file:///android_asset/wrapper.html");
     
            web.setWebViewClient(new WebViewClient() 
            	{
                	@Override public boolean shouldOverrideUrlLoading(WebView view, String url) 
                	{
                    return false;
                	}
            	}
            	);
        }
}
