package com.askerlap.emad.bookteck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Shereen Adel on 2016-08-08.
 */
public class DBController {
    DBHelper dbHelper1;
    SQLiteDatabase database1;
    public DBController(Context context){
        dbHelper1=new DBHelper(context);
    }
    public void Open (){
        database1= dbHelper1.getWritableDatabase();

    }
    public void InsertFilm(String f_name,String c_name,String date,String time,int a_price,int c_price,int capacity){
        ContentValues values=new ContentValues();
        values.put(DBHelper.FILM_NAME,f_name);
        values.put(DBHelper.CINEMA_NAME,c_name);
        values.put(DBHelper.COLUMN_DATE,date);
        values.put(DBHelper.COLUMN_TIME,time);
        values.put(DBHelper.ADULT_PRICE,a_price);
        values.put(DBHelper.CHILD_PRICE,c_price);
        values.put(DBHelper.COLUMN_CAPACITY,capacity);
        database1.insert(DBHelper.TABLE_NAME,null,values);
    }

    public void UpdateFilm(int id,String f_name,String c_name,String date,String time,int a_price,int c_price,int capacity)
    {
        ContentValues values=new ContentValues();
        values.put(DBHelper.FILM_NAME,f_name);
        values.put(DBHelper.CINEMA_NAME,c_name);
        values.put(DBHelper.COLUMN_DATE,date);
        values.put(DBHelper.COLUMN_TIME,time);
        values.put(DBHelper.ADULT_PRICE,a_price);
        values.put(DBHelper.CHILD_PRICE,c_price);
        values.put(DBHelper.COLUMN_CAPACITY,capacity);
        database1.update(DBHelper.TABLE_NAME, values, DBHelper.COLUMN_ID + "=" + id, null);
    }


    public void DeleteFilm(int id)
    {
        database1.delete(DBHelper.TABLE_NAME, DBHelper.COLUMN_ID + "=" + id, null);
    }


    public ArrayList<Film> SelectAllFilms(){
        ArrayList<Film> Films=new ArrayList<Film>();
        Cursor cursor=database1.query(DBHelper.TABLE_NAME,new String[]{DBHelper.COLUMN_ID,DBHelper.FILM_NAME,
                DBHelper.CINEMA_NAME,DBHelper.COLUMN_DATE,DBHelper.COLUMN_TIME,DBHelper.COLUMN_ADULT,DBHelper.COLUMN_CHILD,
                DBHelper.ADULT_PRICE,DBHelper.CHILD_PRICE,DBHelper.COLUMN_CAPACITY},null,null,null,null,null );
        cursor.moveToFirst();
        Film film;
        while (!cursor.isAfterLast()){
            film=CurserToStudent(cursor);
            Films.add(film);
            cursor.moveToNext();
        }
        return Films;
    }


    private Film CurserToStudent(Cursor cursor){
        Film film=new Film();
        film.setId(cursor.getInt(0));
        film.setFilm_name(cursor.getString(1));
        film.setCinema_name(cursor.getString(2));
        film.setDate(cursor.getString(3));
        film.setTime(cursor.getString(4));
        film.setAdult(cursor.getInt(5));
        film.setChild(cursor.getInt(6));
        film.setAdult_price(cursor.getInt(7));
        film.setChild_price(cursor.getInt(8));
        film.setCapacity(cursor.getInt(9));
        return film;
    }

    public void Close(){
        dbHelper1.close();
    }





}
