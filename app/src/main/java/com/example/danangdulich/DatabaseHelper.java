package com.example.danangdulich;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.danangdulich.model.AllPlacesData;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database_name";
    private static final String TABLE_NAME = "travel_table";
    //private static final String ID = "id";
    private static final String PLACENAME = "placeName";
    private static final String AREANAME = "areaName";
    private static final String OPENTIME = "openTime";
    private static final String PIC1 = "pic1";
    private static final String PIC2 = "pic2";
    private static final String PIC3 = "pic3";
    private static final String DESC = "descc";
    private static final String PRICE = "price";
    private static final String IMAGEURL = "imageUrl";
    private static final String RATE = "rate";
    List<AllPlacesData> allPlacesDataList;

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                "(" + PLACENAME + " TEXT PRIMARY KEY," +
                AREANAME + " TEXT," +
                OPENTIME + " TEXT," +
                PIC1 + " INTEGER," +
                PIC2 + " INTEGER," +
                PIC3 + " INTEGER," +
                DESC + " TEXT," +
                PRICE + " TEXT," +
                IMAGEURL + " INTEGER," +
                RATE + " DOUBLE" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertTable(AllPlacesData allPlacesData){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLACENAME, allPlacesData.getPlaceName());
        contentValues.put(AREANAME, allPlacesData.getAreaName());
        contentValues.put(OPENTIME, allPlacesData.getOpenTime());
        contentValues.put(PIC1, allPlacesData.getPic1());
        contentValues.put(PIC2, allPlacesData.getPic2());
        contentValues.put(PIC3, allPlacesData.getPic3());
        contentValues.put(DESC, allPlacesData.getDesc());
        contentValues.put(PRICE,allPlacesData.getPrice());
        contentValues.put(IMAGEURL, allPlacesData.getImageUrl());
        contentValues.put(RATE, allPlacesData.getRate());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
        db.close();

    }
//    public boolean insertTable(String pln, String arn, String op, Integer pic1, Integer pic2, Integer pic3, String desc, String pri, Integer img, Double rate){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(PLACENAME, pln);
//        contentValues.put(AREANAME, arn);
//        contentValues.put(OPENTIME, op);
//        contentValues.put(PIC1, pic1);
//        contentValues.put(PIC2, pic2);
//        contentValues.put(PIC3, pic3);
//        contentValues.put(DESC, desc);
//        contentValues.put(PRICE,pri);
//        contentValues.put(IMAGEURL, img);
//        contentValues.put(RATE, rate);
//        SQLiteDatabase db = this.getWritableDatabase();
//        long rs = db.insert(TABLE_NAME, null, contentValues);
//        if (rs == -1){
//            return false;
//        }else {
//            return true;
//        }
//
//    }


    public List<AllPlacesData> getAll(){
        String sql = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        allPlacesDataList =  new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do{
                String placeName = cursor.getString(0);
                String areaName = cursor.getString(1);
                String openTime = cursor.getString(2);
                Integer pic1 = Integer.parseInt(cursor.getString(3));
                Integer pic2 = Integer.parseInt(cursor.getString(4));
                Integer pic3 = Integer.parseInt(cursor.getString(5));
                String descc= cursor.getString(6);
                String price = cursor.getString(7);
                Integer imageUrl = Integer.parseInt(cursor.getString(8));
                Double rate = Double.parseDouble(cursor.getString(9));
                allPlacesDataList.add(new AllPlacesData(placeName, areaName, openTime, pic1, pic2, pic3, descc, price, imageUrl, rate));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return allPlacesDataList;
    }

}
