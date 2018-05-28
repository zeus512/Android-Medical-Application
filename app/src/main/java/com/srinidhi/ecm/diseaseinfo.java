package com.srinidhi.ecm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class diseaseinfo extends Activity {
	String s1="",s2="",s3="";
	TextView tv,tv1;
	DBHandandler myDbHelper;
	SQLiteDatabase Mydatabase;
	String stattionlist;
	public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
    	try {
			FetchingData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        setContentView(R.layout.information);
        tv=(TextView)findViewById(R.id.TextView02);
        tv1=(TextView)findViewById(R.id.TextView01);
        Bundle b=getIntent().getExtras();
        tv1.setText("Disease Information");
        if(b!=null)
        {
        	s1=b.getString("name");
        	//System.out.print("hey..."+s1);
        	//Toast.makeText(getApplicationContext(),"hai"+s1,100).show();
        	
        }
      
        stattionlist=this.myDbHelper.getInfo(Mydatabase,s1);
        
        tv.setText(stattionlist);

	}
	private void FetchingData() throws SQLException {
		// TODO Auto-generated method stub
		
		 try {  
   			 
	        	myDbHelper.onCreateDataBase();
	        	       	
	        	
	 	} catch (IOException ioe) {
	 
	 		throw new Error("Unable to create database");
	 
	 	} 
	 	myDbHelper.openDataBase();
		Mydatabase = myDbHelper.getWritableDatabase();
		System.out.println("executed");
 
	}

	
}
	