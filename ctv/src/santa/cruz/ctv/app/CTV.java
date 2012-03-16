package santa.cruz.ctv.app;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CTV extends Activity {
	TextView text;
	URL one;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
			one = new URL("http://www.google.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        text = (TextView) findViewById(R.id.simpleText);
        text.setText(one.getHost());
    }
    
}