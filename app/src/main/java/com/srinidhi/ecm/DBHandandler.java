
package com.srinidhi.ecm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import android.widget.Toast;

public class DBHandandler extends SQLiteOpenHelper{
	private static String DB_PATH = "/data/data/com.srinidhi.ecm/databases/";
	  private static String DB_NAME = "medicalinfo.sqlite";
	   private static String TABLENAME = "diseasetable";
	   private SQLiteDatabase myDataBase;   
	   private final Context myContext;
	   ArrayList<String> sw;
	   String s="";
	public DBHandandler(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
		  this.myContext = context;
	}
	public int onCreateDataBase() throws IOException
	{
		boolean dbExist=checkDatabase();
		if(dbExist){
   		 return 0;
   	}else{
   		 System.out.println("onCreateDataBase method execution starts");
   	
       	this.getReadableDatabase();

       	

   			copyDataBase();
   			return 1;	
   		
   	}
	}
	private boolean checkDatabase() {
		// TODO Auto-generated method stub
		SQLiteDatabase checkDB=null;
		try
		{

			String myPath = DB_PATH + DB_NAME;
			
			checkDB=SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(checkDB != null){
			 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true: false ;
		
	
	}
	private void copyDataBase() throws IOException{
		
		InputStream myInput=myContext.getAssets().open(DB_NAME);
		
		
		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		//Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		//transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer))>0){
			myOutput.write(buffer, 0, length);
			
		
		}

		//Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
		
		}
		
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	 public void openDataBase() throws SQLException{
    	 
	    	//Open the database
	        String myPath = DB_PATH + DB_NAME;
	    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	    
	    }
	public ArrayList<String> getNames(SQLiteDatabase db) {
		 ArrayList<String> list=new ArrayList<String>();
		 list.add("Select Disease Name");
		 String P_query123="SELECT distinct dname FROM diseasetable";
		 Cursor c=db.rawQuery(P_query123, null); 
		 if(c!=null)  
		{  
			 c.moveToFirst();
				do{ 	   
				list.add(c.getString(c.getColumnIndex("dname")));           
			}while(c.moveToNext());  
			}
	 c.close();
		return list;
	}
	public ArrayList<String> getsymptoms(SQLiteDatabase mydatabase2) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		 list.add("Select Symptom name Name");
		 String P_query123="SELECT distinct sname FROM symptoms";
		 Cursor c=mydatabase2.rawQuery(P_query123, null); 
		 if(c!=null)  
		{  
			 c.moveToFirst();
				do{ 	   
				list.add(c.getString(c.getColumnIndex("sname")));           
			}while(c.moveToNext());  
			}
	 c.close();
		return list;
		
	}
	public String getInfo(SQLiteDatabase mydatabase2,String s1) 
	{
		// System.out.print("hey");
		String P_query123="SELECT  dinfo FROM diseasetable  where dname='"+s1+"' ";
		 //System.out.print("hey.......how r u");
		 Cursor c=mydatabase2.rawQuery(P_query123,null);
		 //System.out.print("hey.......how r u");
		 if(c!=null)
		 {
			
			 if( c.moveToFirst() ){            //we missed this line
				int i=c.getColumnIndex("dinfo");
				 s=c.getString(i);
				 //System.out.print("hey.......how r u"+s);
			
		 }
		 }
		 c.close();//we missed this line
		 
		return s;
	}
	public String getmInfo(SQLiteDatabase mydatabase2, String s1) {
		// TODO Auto-generated method stub
		String P_query123="SELECT  minfo FROM diseasetable  where dname='"+s1+"' ";
		Cursor c=mydatabase2.rawQuery(P_query123,null);
		 
		 if(c!=null)
		 {
			
			 if( c.moveToFirst() ){          
				int i=c.getColumnIndex("minfo");
				 s=c.getString(i);
			System.out.print("hey.......how r u"+s);
			
		 }
		 }
		 c.close();
		return s;
	}
	public String getsInfo(SQLiteDatabase mydatabase2, String s1) {
		// TODO Auto-generated method stub
		String P_query123="SELECT  sinfo FROM diseasetable  where dname='"+s1+"' ";
		Cursor c=mydatabase2.rawQuery(P_query123,null);
		 
		 if(c!=null)
		 {
			
			 if( c.moveToFirst() ){          
				int i=c.getColumnIndex("sinfo");
				 s=c.getString(i);
			System.out.print("hey.......how r u"+s);
			
		 }
		 }
		 c.close();
		return s;
	}
	/*public ArrayList<String> getdiagNames(SQLiteDatabase mydatabase2, String s2,String s3,String s4,String s5,String s6,String s7) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		 String P_query123="select distinct dname from diseasetable dt inner join dissymp ds on dt.did =ds.did inner join symptoms s on ds.sid=s.sid where sname in('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
		// String P_query234="select dname from diseasetable where did='P_query123'";
		 Cursor c=mydatabase2.rawQuery(P_query123, null); 
		
	//	 Cursor c=mydatabase2.rawQuery(P_query123, null); 
		 c.moveToFirst();
		 if(c!=null)  
			{  
			
					do{ 	   
					list.add(c.getInt(c.getColumnIndex("sid")));           
				}while(c.moveToNext());  
				}
		 c.close();
			return list;
		ArrayList<String> list=new ArrayList<String>();
		
		 String P_query123="select distinct dname from diseasetable dt inner join dissymp ds on dt.did =ds.did inner join symptoms s on ds.sid=s.sid where sname in('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
		 Cursor c=mydatabase2.rawQuery(P_query123, null); 
		 c.moveToFirst();
		 if(c!=null)  
		{  
			 c.moveToFirst();
				do{ 	   
				list.add(c.getString(c.getColumnIndex("dname")));           
			}while(c.moveToNext());  
			}
	 c.close();
	return null;
		
		
	}*/
	
	public ArrayList<String> getdiagids(SQLiteDatabase mydatabase2, String s2, String s3,
			String s4, String s5, String s6,String s7) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();

		try{ 
		System.out.println("hello"+s2+""+s3+""+s4);
				//list.add("You might be suffering from the following diseases");
		 String P_query123="select distinct dname from diseasetable dt inner join dissymp ds on dt.did =ds.did inner join symptoms s on ds.sid=s.sid where sname in('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
					Cursor c=mydatabase2.rawQuery(P_query123, null); 
					System.out.println("hi am.."+P_query123);
					 c.moveToFirst();
					 if(c!=null)  
						{  
							 do{
							
							
								 	   
								list.add(c.getString(c.getColumnIndex("dname")));           
							 }while(c.moveToNext());
							}
					 c.close();
		
						
		}catch (Exception e) {
			// TODO: handle exception
			 
		 }
		 return list;
				}
	
	
}
