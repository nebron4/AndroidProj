package com.example.androidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeviceDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DeviceDatabaseHelper";
    private static final String DATABASE_NAME = "DeviceDataTable.db";
    public static final String TABLE_NAME = "device_table";

    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "TYPE";
    public static final String COL4 = "ROOM";
    public static final String COL5 = "STATUS";
    public static final String COL6 = "TEMPR";
    public static final String COL7 = "MODE";



    public DeviceDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);

    }


    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, ROOM TEXT, STATUS TEXT, TEMPR TEXT, MODE TEXT)");
    }

    public boolean insertData(String rooms){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, rooms);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getDevices(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;

    }

    public boolean updateDevices(String id, String rooms){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, rooms);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Integer deleteDevices(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});

    }



    //thermostat
    public boolean insertDataThermo(String name, String rooms){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, name);
        contentValues.put(COL3, "Thermostat");
        contentValues.put(COL4, rooms);
        contentValues.put(COL5, "NA");
        contentValues.put(COL6, "70");
        contentValues.put(COL7, "COOL");

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getDevicesThermo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " WHERE TYPE='Thermostat'", null);
        return res;

    }
}
