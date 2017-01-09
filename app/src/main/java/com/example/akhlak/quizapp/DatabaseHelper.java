package com.example.akhlak.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

/*
 * Created by akhlak on 21/12/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String LEADERBOARD_TABLE = "Leaderboard";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_USERNAME = "Username";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_SCORE = "Score";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "Name text not null, Email text not null, Username text not null, Password text not null);";

    private static final String LEADERBOARD_CREATE = "create table Leaderboard (id integer primary key not null , " +
            "Username text not null, Score integer not null);";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME, null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(LEADERBOARD_CREATE);
        this.db = db;

    }

    public void insertContact(Contact c)
    {
        db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());

        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_USERNAME, c.getUsername());

        db.insert(TABLE_NAME, null , values);
        db.close();
    }

    String searchPass(String Username)
    {
        db = this.getReadableDatabase();
        String query = "select Username, Password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String DatabaseUsername, Databasepassword = "";

        if(cursor.moveToFirst())
        {
            do {
                DatabaseUsername = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                if (DatabaseUsername.equals(Username))
                {
                    Databasepassword = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

                    break;
                }
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return Databasepassword;
    }

    String searchUsername(String Username)
    {
        db = this.getReadableDatabase();
        String query = "select Username from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String DatabaseUsername = "";

        if (cursor.moveToFirst())
        {
            do {
                DatabaseUsername = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                if(DatabaseUsername.equals(Username))
                {
                    DatabaseUsername = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));

                    break;
                }
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return DatabaseUsername;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        String query2 = "DROP TABLE IF EXISTS "+LEADERBOARD_TABLE;
        db.execSQL(query2);
        this.onCreate(db);
    }

    public void saveScore(Bundle b)
    {
        db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Leaderboard";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_SCORE, b.getInt("score"));
        values.put(COLUMN_USERNAME, b.getString("playerusername"));

        db.insert(LEADERBOARD_TABLE, null , values);
        db.close();
    }

    public Bundle getscoreat(int i)
    {
        db = this.getReadableDatabase();
        Bundle b = new Bundle();

        String query = "select * from Leaderboard order by Score desc, Username asc";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToPosition(i-1))
        {

                b.putString("playerusername", cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                b.putInt("score", cursor.getInt(cursor.getColumnIndex(COLUMN_SCORE)));

        }
        return b;
    }

    public int[] getuserscore(String Username)
    {
        db = this.getReadableDatabase();
        String query = "select * from Leaderboard order by Username asc, Score desc";
        Cursor cursor = db.rawQuery(query , null);
        String DatabaseUsername;
        int j=0;
        int[] score={0,0,0};

        if (cursor.moveToFirst()) {
            do {
                DatabaseUsername = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                if (DatabaseUsername.equals(Username))
                {
                    score[j] = cursor.getInt(cursor.getColumnIndex(COLUMN_SCORE));
                    j++;

                    if(j==3)
                        {
                            break;
                        }
                }
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return score;
    }
}
