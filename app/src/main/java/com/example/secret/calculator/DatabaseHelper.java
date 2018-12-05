package com.example.secret.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "calculation_table";
    private static final String COL_NO = "_no";
    private static final String COL_CALC = "calculation";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String table = "CREATE TABLE " + TABLE_NAME + " (" + COL_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CALC + " TEXT)";
        db.execSQL(table);
        Log.d(TAG, "onCreate: Creating table!");
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        Log.d(TAG, "onUpgrade: Updating table!");
        onCreate(db);
    }

    public boolean addCalc(String calc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CALC, calc);

        Log.d(TAG, "onCreate: Adding " + calc + "to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getCalc(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //delete a specific row in table
    public boolean deleteRow(long rowId){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = COL_NO + "=" + rowId;
        return db.delete(TABLE_NAME, where, null) != 0;
    }

    //delete all rows in table
    public void deleteAll(){
        Cursor data = getCalc();
        long rowId = data.getColumnIndexOrThrow(COL_NO);
        //loop the deletion row by row
        if(data.moveToFirst()){
            do{
                deleteRow(data.getLong((int) rowId));
            }
            while (data.moveToNext());
        }
        //close the database
        data.close();
    }
}
