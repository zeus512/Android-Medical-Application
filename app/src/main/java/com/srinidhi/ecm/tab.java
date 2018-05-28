package com.srinidhi.ecm;

import com.srinidhi.ecm.*;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class tab extends TabActivity{
	String s,s1;
	Resources res;
	TabHost tabhost;
	TabHost.TabSpec spec;
	Intent intent,it2,it3;
	Bundle b;
	public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.tablayout);
       
       res=getResources();
       tabhost = getTabHost(); 
      b=getIntent().getExtras();
       if(b!=null)
       {
     	  s1=b.getString("name");
     	  //s=b.getString("name");
     	  
     	
       }
    intent=new Intent().setClass(this,diseaseinfo.class);
    intent.putExtra("name",s1);
    
	//intent.putExtra("name",s);
  	
  	spec=tabhost.newTabSpec("Disease Info").setIndicator("Disease Info").setContent(intent);
  	tabhost.addTab(spec);
  	intent=new Intent().setClass(this,next.class);
		spec=tabhost.newTabSpec("Symptoms").setIndicator("Symptoms").setContent(intent);
		intent.putExtra("name",s1);
	    
		tabhost.addTab(spec);
		intent=new Intent().setClass(this,medication.class);
		spec=tabhost.newTabSpec("Medication").setIndicator("Medication").setContent(intent);
		intent.putExtra("name",s1);
	    
		tabhost.addTab(spec);
		tabhost.setCurrentTab(0);
      
     
}
}

