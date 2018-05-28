package com.srinidhi.ecm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class next extends Activity {
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
        
        if(b!=null)
        {
        	s1=b.getString("name");
        	//System.out.print("hey..."+s1);
        	//Toast.makeText(getApplicationContext(),"hai"+s1,100).show();
        	
        }
        tv1.setText(s1 +""+ " Symptoms");
        stattionlist=this.myDbHelper.getsInfo(Mydatabase,s1);
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
	