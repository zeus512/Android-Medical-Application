package com.srinidhi.ecm;

import java.util.ArrayList;

import com.srinidhi.ecm.*;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class MedicalproActivity extends Activity {
	Button b1,b2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b1=(Button)findViewById(R.id.button1);
         b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MedicalproActivity.this,diseaselist.class);
				startActivity(i);
			}
		});
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent it=new Intent(MedicalproActivity.this,second.class);
				startActivity(it);
			}
    });
}
}