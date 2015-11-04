package com.example.datastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Helper extends SQLiteOpenHelper {
	//Constructor Method
	public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
	// Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
 
    // Contacts table name
    private static final String TABLE_CUSTOMER = "contacts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String FIRST_NAME = "fName";
    private static final String LAST_NAME = "lName";
    private static final String ADDRESS = "address";
    private static final String CREDIT = "creditDetails";
    
    // Creating The Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + FIRST_NAME + " TEXT,"
                + LAST_NAME + " TEXT," + ADDRESS + " TEXT," + CREDIT + " TEXT" + ")";
        db.execSQL(CREATE_CUSTOMER_TABLE);
    }
 
    // Upgrading the Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
 
        // Recreate table
        onCreate(db);
    }

    public void addCustomer(Customer customer){
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, customer.fName); 
        values.put(LAST_NAME, customer.lName);
        values.put(ADDRESS, customer.address);
        values.put(CREDIT, customer.creditDetails);
     
        // Insert Row
        db.insert(TABLE_CUSTOMER, null, values);
        //Close Connection
        db.close();
    }    
}
