package com.example.growyourhealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "scoreSaver";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "table_score";
    private static final String COL0 = "_id";
    private static final String COL1 = "SCORE";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE" + TABLE_NAME + " (" + COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL1 + " TEXT);";

        Log.d(TAG, "onCreate:" + createTable);

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Adds an entry to the database for a runner's run
     *
     * @param score
     * @return
     */

    public boolean addScore (int score){
        // This will get an object store the database
        SQLiteDatabase db = this.getWritableDatabase();

        // This will help us write to the database. Think of put as putting this element into this column of db
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, score);

        // this will display info to help us in Logcat to see where we are
        Log.d(TAG, "addData: Adding " + score + " to" + TABLE_NAME);

        // insert value into table. Return -1 if not successful
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;       // didn't insert correctly
        else
            return true;        // successful add to table
    }

    /**
     * Returns all the data from the database
     * @return
     */

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed in
     * @param score
     * @return
     */

    public Cursor getItemID(int score){
        SQLiteDatabase db = this.getWritableDatabase();
        // query is essentially saying
        // "select the id from the table where the score is equal to the name passed in"

        String query = "SELECT " + COL0 + "FROM " + TABLE_NAME + " WHERE " + COL1 +
                " = '" + score + "'";
        // Note there are single quotes around the name variable inside of double quotes
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}


