package com.srinidhi.ecm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.srinidhi.ecm.DBHandandler;

import android.R.integer;
import android.app.ListActivity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class intermediate extends ListActivity{
	DBHandandler myDbHelper;
	SQLiteDatabase Mydatabase;
	ArrayList<String> stattionlist,sw;
	ArrayList<String> s;
	ArrayList<String> sd;
	String s1;
	String s2="",s3="",s4="",s5="",s6="";
	String s7="",s8="",s9="",s10="",s11="";
	int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;
	//int[] s={};
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Bundle b=getIntent().getExtras();
         sw=new ArrayList<String>();
       if(b!=null)
        {
        	s1=b.getString("value");
        	 Log.e("xxxx2",s1);
       // Toast.makeText(getApplicationContext()," "+s1,100).show();
       
        }  
        String[] a=s1.split(",");
        if(a.length<6)
        {
         Toast.makeText(getApplicationContext(),"Please select minimum 6 symptoms to perform diagnosis ",1000).show();
         Intent myIntent = new Intent(intermediate.this, second.class);
           startActivity(myIntent); 
        }
        else{
        	
        
        Log.e("xxxx2",s1);
       s2=a[0];
       Log.e("xxxx2",s2);
       s3=a[1];
       Log.e("xxxx2",s3);
       s4=a[2];
       Log.e("xxxx2",s4);
       s5=a[3];
       s6=a[4];
       s7=a[5];
       Log.e("xxxx2",s5);
        Toast.makeText(getApplicationContext()," "+s2+""+s3+""+s4+""+s5,1000).show();
    
        
       
		 this.myDbHelper = new DBHandandler(this);
	    	FetchingData();
	    	s=this.myDbHelper.getdiagids(Mydatabase,s2,s3,s4,s5,s6,s7);
	    	/*int[] ret = new int[s.size()];
	        Iterator<Integer> iterator = s.iterator();
	        for (int i = 0; i < ret.length; i++)
	        {
	            ret[i] = iterator.next().intValue();
	            System.out.println("Hey...?"+ret[i]);
	        }*/
	       /* i1=ret[0];
	        i2=ret[1];
	        i3=ret[2];
	        i4=ret[3];
	        i5=ret[4];
	        i6=ret[5];
	        System.out.println("Hey...?"+i1+""+i2+""+i3+""+i4);
	        */
	    	//Iterator<String> it=s.iterator();
	    	/*String[] a1=s.split(",");
	        Log.e("xxxx3",s);
	       s7=a1[0];
	       i1=Integer.parseInt(s7);
	       System.out.println("hkhhkj"+i1);
	       Log.e("xxxx3",s7);
	       s8=a1[1];
	       i2=Integer.parseInt(s8);
	       Log.e("xxxx3",s8);
	       s9=a1[2];
	       i3=Integer.parseInt(s9);
	       Log.e("xxxx3",s9);
	       s10=a1[3];
	       i4=Integer.parseInt(s10);
	       Log.e("xxxx3",s10);*/
	     // sd=this.myDbHelper.getdiagids(Mydatabase,i1,i2,i3,i4,i5,i6);
	    	//stattionlist=this.myDbHelper.getNames(Mydatabase
	      final ListView lv;
	
	       lv=getListView();
	    	ArrayAdapter<String> lv1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,s);
	    	lv.setAdapter(lv1);
	    	lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
				
	            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
	              // When clicked, show a toast with the TextView text
	            	String s123=lv.getItemAtPosition(position).toString();
					Toast.makeText(getApplicationContext(),
							"You selected " + s123 +" disease", Toast.LENGTH_LONG)
							.show();
					Intent myIntent = new Intent(getApplicationContext(), tab.class);
			           myIntent.putExtra("name",s123);
						startActivity(myIntent);
	               //  Intent myIntent = new Intent(view.getContext(), tab.class);
	                 //startActivityForResult(myIntent, 0);

	            }

				
	          });
        }
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


