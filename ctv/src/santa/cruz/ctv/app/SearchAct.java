package santa.cruz.ctv.app;

import java.util.ArrayList;

import santa.cruz.ctv.virtual.Channels;
import santa.cruz.ctv.virtual.HTMLParserSearch;

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
        setContentView(R.layout.searchview);
//        setContentView(R.layout.search);
//        setContentView(R.layout.ctv1stream);
		final Intent queryIntent = getIntent();
		final String queryAction = queryIntent.getAction();
		if (Intent.ACTION_SEARCH.equals(queryAction)) {
			//here
			String searchKeywords = queryIntent.getStringExtra(SearchManager.QUERY);
	        doAnotherSearch(searchKeywords);
		}else {
	        Bundle bundle = getIntent().getExtras();
			String searchstring = bundle.getString("santa.cruz.ctv.app.stream_data");
		       	doAnotherSearch(searchstring);      	
			}
    }

	private void doAnotherSearch(String query) {
		// TODO Auto-generated method stub
    	final TextView textViewToChange = (TextView)findViewById(R.id.searchwindow);
    	String another = query;
    	if(query.equals("") || query == null)
    	{
    		textViewToChange.setText("no results");
    		return;
    	}
    	String foundQuery = query.replaceAll(" ", "%20");
    	foundQuery = foundQuery.replace("\"", "&quote;");
    	foundQuery = foundQuery.replace("&", "&amp;");
    	HTMLParserSearch subject1 = new HTMLParserSearch("http://63.249.112.96/cablecast/public/Search.aspx?ChannelID=1&SimpleSearch="+foundQuery);
    	HTMLParserSearch subject2 = new HTMLParserSearch("http://63.249.112.96/cablecast/public/Search.aspx?ChannelID=2&SimpleSearch="+foundQuery);
    	HTMLParserSearch subject3 = new HTMLParserSearch("http://63.249.112.96/cablecast/public/Search.aspx?ChannelID=3&SimpleSearch="+foundQuery);
    	subject1.parseData();
    	subject2.parseData();
    	subject3.parseData();
    	
    	ArrayList<Channels> channels1 = subject1.getData();
    	ArrayList<Channels> channels2 = subject2.getData();
    	ArrayList<Channels> channels3 = subject3.getData();
    	int results = subject1.getResultsFound()+subject2.getResultsFound()+subject3.getResultsFound();
    	if(results != 0)
    	{
    		another = results+" Results Found:";
    		for(int i = 0; i < channels1.size(); i++)
        	{
        		another += ("channel 1: "+channels1.get(i).getName()+" "+channels1.get(i).getTime()+"\n\n");
        	}
        	for(int i = 0; i < channels2.size(); i++)
        	{
        		another += ("channel 2: "+channels2.get(i).getName()+" "+channels2.get(i).getTime()+"\n\n");
        	}
        	for(int i = 0; i < channels3.size(); i++)
        	{
        		another += ("channel 3: "+channels3.get(i).getName()+" "+channels3.get(i).getTime()+"\n\n");
        	}
    	}
    	else
    		another = "No results Found";
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

/*	private void doMySearch(String query) {
		// TODO Auto-generated method stub
/*		ListAdapter adapter = new SimpleCursorAdapter(
                this, // Context.
                android.R.layout.two_line_list_item,  // Specify
                mCursor,                                              // Pass in the cursor to bind to.
                new String[] {People.NAME, People.COMPANY},           // Array of cursor columns to bind to.
                new int[] {android.R.id.text1});  // Parallel array of which template objects to bind to those columns.

        // Bind to our new adapter.
        setListAdapter(adapter);
*///	} 
}