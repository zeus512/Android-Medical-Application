package com.srinidhi.ecm;

import android.app.Activity;

	
	import java.io.IOException;
	import java.util.ArrayList;



	
	import android.app.Activity;
	import android.app.ListActivity;
	import android.content.Intent;
	import android.database.SQLException;
	import android.database.sqlite.SQLiteDatabase;
	import android.nfc.Tag;
	import android.os.Bundle;
	import android.util.Log;
	import android.util.SparseBooleanArray;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.AdapterView;
	import android.widget.AdapterView.OnItemClickListener;
	import android.widget.AdapterView.OnItemSelectedListener;
	import android.widget.ArrayAdapter;
	import android.widget.Button;
	import android.widget.ListAdapter;
	import android.widget.ListView;
	import android.widget.Spinner;
import android.widget.Toast;


public class second extends Activity{
		Button b1;
		
		 String s="",s1;
		int count=0;
		 DBHandandler myDbHelper;
			SQLiteDatabase Mydatabase;
			ArrayList<String> stattionlist,sw;
			
			  public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		    setContentView(R.layout.symptoms);
		        b1=(Button)findViewById(R.id.button1);
		      
		           this.myDbHelper = new DBHandandler(this);
		    	FetchingData();
		    	
		    	stattionlist=this.myDbHelper.getsymptoms(Mydatabase);
		    	final ListView lv=(ListView)findViewById(R.id.listView1);
		    	ArrayAdapter<String> lv1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_multiple_choice,stattionlist);
		    	lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		    	lv.setAdapter(lv1);
		    	
 

		    	lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

	            	    				
		    	public void onItemClick(AdapterView<?> adapter, View arg1, int arg2, long arg3)
		        {

		    			
		    				SparseBooleanArray sp=lv.getCheckedItemPositions();
		    				String[] selectionArgs = stattionlist.toArray(new String[stattionlist.size()]);

		      //inst x1=sp.indexOfValue(true);
		     
		   //    Toast.makeText(getApplicationContext()," "+sw,100).show();
		    				
		       
		       
		    	   if(lv.isItemChecked(arg2))
		    	   {
		    		   s=s+(String)lv.getItemAtPosition(arg2)+",";
		    		  Log.e("xxxx1",s);
		    		  
		    		  Toast.makeText(getApplicationContext(),""+s,Toast.LENGTH_SHORT).show();
		    	   }
		    		   
		           
		          
		       
		     
		        
		       /* for(int i=0;i<=stattionlist.size();i++)
		        {
		        	if(lv.isItemChecked(i))

		            s=s+(String)lv.getItemAtPosition(i).toString()+",";

		            
		        }*/
		        
		        
		    		
		        }
		    	
		    	
		  }	);	
		    	  b1.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i=new Intent(second.this,intermediate.class);
							 i.putExtra("value",s);
				
							 startActivity(i);
						}
					});
		    	 
		  }
		       
		  
		 				
		       
		       
		     
		  
		 
		
		public void FetchingData() {
	  		
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



