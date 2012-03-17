package santa.cruz.ctv.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class CTV extends Activity 
	implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        View ctv1Button = findViewById(R.id.ctv1Button);
        ctv1Button.setOnClickListener(this);
    }
    
    public void onClick(View v) {
	
	   if(v.getId() == R.id.ctv1Button)
	   {
		   //
		   AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
		   alert.show();
	   }
	}
}