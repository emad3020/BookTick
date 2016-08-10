package com.askerlap.emad.bookteck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shereen Adel on 2016-08-08.
 */
public class DBHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME="FilmDB";
    private final static int DATABASE_VERSION = 1;
    public final static String TABLE_NAME="Film";
    public final static String COLUMN_ID="_id";
    public final static String FILM_NAME="filmname";
    public final static String CINEMA_NAME="cinemaname";
    public final static String COLUMN_DATE="date";
    public final static String COLUMN_TIME="time";
    public final static String COLUMN_ADULT="adult";
    public final static String COLUMN_CHILD="child";
    public final static String ADULT_PRICE="adultprice";
    public final static String CHILD_PRICE="childprice";
    public final static String COLUMN_CAPACITY="capacity";


    private final static String CREATE_STATEMENT=" CREATE TABLE "+ TABLE_NAME +" ( "+ COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            FILM_NAME+" TEXT NOT NULL, "+ CINEMA_NAME +" TEXT NOT NULL, "+ COLUMN_DATE +" TEXT NOT NULL, "+ COLUMN_TIME +" TEXT NOT NULL, "+
            COLUMN_ADULT +" INTEGER, "+ COLUMN_CHILD +" INTEGER, "+ ADULT_PRICE +" INTEGER, "+ CHILD_PRICE +" INTEGER, "+ COLUMN_CAPACITY
            +" INTEGER); " ;


    public DBHelper(Context context) {
        super(context,DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
