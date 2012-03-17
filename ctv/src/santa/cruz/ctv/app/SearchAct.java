package santa.cruz.ctv.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class SearchAct extends Activity {
	
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search);
        setContentView(R.layout.searchview);
//        setContentView(R.layout.ctv1stream);
        Bundle bundle = getIntent().getExtras();
		String searchstring = bundle.getString("santa.cruz.ctv.app.stream_data");
        handleIntent(getIntent(),searchstring);
    }

	private void doAnotherSearch(String query) {
		// TODO Auto-generated method stub
    	final TextView textViewToChange = (TextView)findViewById(R.id.searchwindow);
    	String another = query;
       	textViewToChange.setText(another);
/*		EditText cinput;      
		String input;  
		TextView result;

      cinput = (EditText)findViewById(R.id.search1box);
      input = cinput.getText().toString();
      result = (TextView)findViewById(R.id.searchwindow);
      result.setText(input);

	   AlertDialog.Builder builder = new AlertDialog.Builder(this);
	   builder.setMessage(query)
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
		ListAdapter adapter = new SimpleCursorAdapter(
                this, // Context.
                android.R.layout.two_line_list_item,  // Specify
                mCursor,                                              // Pass in the cursor to bind to.
                new String[] {People.NAME, People.COMPANY},           // Array of cursor columns to bind to.
                new int[] {android.R.id.text1});  // Parallel array of which template objects to bind to those columns.

        // Bind to our new adapter.
        setListAdapter(adapter);
*/	}

	private void doMySearch(String query) {
		// TODO Auto-generated method stub
/*		ListAdapter adapter = new SimpleCursorAdapter(
                this, // Context.
                android.R.layout.two_line_list_item,  // Specify
                mCursor,                                              // Pass in the cursor to bind to.
                new String[] {People.NAME, People.COMPANY},           // Array of cursor columns to bind to.
                new int[] {android.R.id.text1});  // Parallel array of which template objects to bind to those columns.

        // Bind to our new adapter.
        setListAdapter(adapter);
*/	}
	private void handleIntent(Intent intent, String searchstring) {
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
		     String query = intent.getStringExtra(SearchManager.QUERY);
	      doMySearch(query);
        }else {
   	       	doAnotherSearch(searchstring);       	
        }
	}
}