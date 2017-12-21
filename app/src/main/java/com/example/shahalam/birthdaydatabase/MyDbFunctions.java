package com.example.shahalam.birthdaydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ShahAlam on 21-Dec-17.
 */

public class MyDbFunctions extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Mydb";
    private static final String TABLE_NAME = "MyTable";

    private static final String COLUMN_ID= "id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_BDAY = "Days";


    public MyDbFunctions(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY, "+COLUMN_NAME+" TEXT, "+COLUMN_BDAY+" TEXT ); ";
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // --- --- Adding Data to Database --- ---
    void addingDataToTable (DataTemp dt) {
        SQLiteDatabase sdb = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, dt.getName());
        cv.put(COLUMN_BDAY, dt.getDay());

        sdb.insert(TABLE_NAME, null, cv);
        sdb.close();

    }
    // showing data ---------
    String[] my_data() {

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM "+TABLE_NAME;
        Cursor c = sq.rawQuery(q, null);

        String[] received_data = new String[c.getCount()];

        c.moveToFirst();
        if(c.moveToFirst()) {
            int counter = 0;
            do {
                received_data[counter] = "Name: "+c.getString(c.getColumnIndex(COLUMN_NAME +""))+"\nBirthday: "+c.getString(c.getColumnIndex(COLUMN_BDAY +""));
                counter = counter +1;
            } while (c.moveToNext());
        }
        return received_data;
    }
}
