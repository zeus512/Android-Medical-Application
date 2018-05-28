package com.srinidhi.ecm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class medication extends Activity {
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

			e.printStackTrace();
		}
    	
        setContentView(R.layout.information);
        tv=(TextView)findViewById(R.id.TextView02);
        tv1=(TextView)findViewById(R.id.TextView01);
        Bundle b=getIntent().getExtras();
        tv1.setText("Prevention and Medication");
        if(b!=null)
        {
        	s1=b.getString("name");

        }
      
        stattionlist=this.myDbHelper.getmInfo(Mydatabase,s1);
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
	