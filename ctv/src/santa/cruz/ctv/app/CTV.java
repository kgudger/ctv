package santa.cruz.ctv.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class CTV extends Activity 
	implements OnClickListener 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //set up the view objects
        View stream1 = findViewById(R.id.stream1);
        View stream2 = findViewById(R.id.stream2);
        View stream3 = findViewById(R.id.stream3);
        
        View schedule1 = findViewById(R.id.schedule1);
        View schedule2 = findViewById(R.id.schedule2);
        View schedule3 = findViewById(R.id.schedule3);
        
        //set up the click listening       
        stream1.setOnClickListener(this);
        stream2.setOnClickListener(this);
        stream3.setOnClickListener(this);
        
        schedule1.setOnClickListener(this);
        schedule2.setOnClickListener(this);
        schedule3.setOnClickListener(this);
    } //end onCreate
    
    public void onClick(View v)
    {
    	int x = 0;
		switch(v.getId())
    	{
	   		case (R.id.stream1):
	   		   x = 1;
	 		   break;
	   		case (R.id.stream2):
	   		   x = 2;
	   		   break;
	   		case (R.id.stream3):
	   		   x = 3;
	   		   break;
	   		case (R.id.schedule1):
	   			x = 4;
	   			break;
	   		case (R.id.schedule2):
	   			x = 5;
	   			break;
	   		case (R.id.schedule3):
	   			x = 6;
	   			break;
	   		default:
	   			break;
    	} //end switch
    	if(x < 4)
    	{
    		Intent startNewActivityOpen = new Intent(this, CTVStream.class);
    		startNewActivityOpen.putExtra("santa.cruz.ctv.app.stream_data", x);
    		startActivity(startNewActivityOpen);
    	} //end if
    	else
    	{
    		Intent startNewActivityOpen = new Intent(this, ScheduleView.class);
    		startNewActivityOpen.putExtra("santa.cruz.ctv.app.stream_data", x);
    		startActivity(startNewActivityOpen);
    	}
	} //end onClick
} //end CTV


//---EVERYTHING BEYOND THIS LINE IS USELESS---//
// Code Junkyard
//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("file://android_asset/wrapper.html"));
//startActivity(browserIntent);
/*		   AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setMessage("Are you sure?")
       .setCancelable(false)
       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
         	  dialog.cancel();
           }
       })
       .setNegativeButton("No", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
           }
       });
AlertDialog alert = builder.create(); 
alert.show();*/