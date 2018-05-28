package com.srinidhi.ecm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.srinidhi.ecm.DBHandandler;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class diseaselist extends ListActivity{
	DBHandandler myDbHelper;
	SQLiteDatabase Mydatabase;
	ArrayList<String> stattionlist;
	String[] abc;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
	    	FetchingData();
	    	stattionlist=this.myDbHelper.getNames(Mydatabase);
	    	final ListView lv=getListView();
	    	ArrayAdapter<String> lv1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stattionlist);
	    	lv.setAdapter(lv1);
	    	lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
				
	            private View view;
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
	              // When clicked, show a toast with the TextView text
				
				
					String s1=stattionlist.get(position);
				Toast.makeText(getApplicationContext(),
						"You selected " + s1 +" disease", Toast.LENGTH_LONG)
						.show();
				Intent myIntent = new Intent(getApplicationContext(), tab.class);
		           myIntent.putExtra("name",s1);
					startActivity(myIntent);
					
					
					
				}
	            
	    	
	    	
	          });
	}
	    	
	

	private void FetchingData() {
		// TODO Auto-generated method stub
		
		 try {  
   			 
	        	myDbHelper.onCreateDataBase();
	        	       	
	        	
	 	} catch (IOException ioe) {
	 
	 		throw new Error("Unable to create database");
	 
	 	} 
	 	try {
	 
	 		myDbHelper.openDataBase();
	 		Mydatabase = myDbHelper.getWritableDatabase();
			System.out.println("executed");
	 	
	 	}catch(SQLException sqle){
	 
	 		throw sqle;
	 
	 	}
 
	}
}


