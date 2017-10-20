package com.sdl.dart.yellowpages2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ashutosh on 19/8/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    //FeedReaderContract f=new FeedReaderContract();
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "db";

    // Contacts table name
    private static final String TABLE_USER_DETAIL = "info";
    private static final String TABLE_BOOKINGS = "bookings";

    // Contacts Table Columns names
    // private static final String KEY_ID = "id";
    //private static final String KEY_ENROLL_NO = "enroll_no";
    private static final String U_NAME = "u_name";
    private static final String PASSWORD = "email";
    private static final String WORKER_ID = "W_ID";
    private static final String DATE = "Date";
    private static final String TIME = "Time";


    public DatabaseHandler(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USER_DETAIL_TABLE = "CREATE TABLE " + TABLE_USER_DETAIL + "("
                + U_NAME + " VARCHAR(20),"
                + PASSWORD + " VARCHAR(16)" + ")";
        String CREATE_BOOKINGS_TABLE = "CREATE TABLE " + TABLE_BOOKINGS + "(" + U_NAME + " VARCHAR(20)," + WORKER_ID + " VARCHAR(5)," + DATE + " VARCHAR(12)," + TIME + " VARCHAR(10)" + ")";
        db.execSQL(CREATE_USER_DETAIL_TABLE);
        db.execSQL(CREATE_BOOKINGS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DETAIL);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_BOOKINGS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new User Information
    void addNewUser(user newUser) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // values.put(KEY_ENROLL_NO, newStud.get_enroll_no());
        values.put(U_NAME, newUser.getU_name());
        values.put(PASSWORD, newUser.getPass());


        // Inserting Row
        db.insert(TABLE_USER_DETAIL, null, values);
        db.close(); // Closing database connection
    }

    void addNewBooking(Booking newBooking) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(U_NAME, newBooking.getU_name());
        values.put(WORKER_ID, newBooking.getW_id());
        values.put(DATE,newBooking.getDate_st());
        values.put(TIME,newBooking.getTime_st());
        db.insert(TABLE_BOOKINGS, null, values);
        db.close();
    }
    /*private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:mydatabase.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }*/

    boolean searchUser(user newUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = ("Select * from " + TABLE_USER_DETAIL + " where " + U_NAME + "='" + newUser.getU_name() + "' and " + PASSWORD + "='" + newUser.getPass() + "';");
        Cursor cursor = db.rawQuery(sql, null);
     /*   Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql))*/
        if (cursor.moveToFirst()) {
            return true;
        } else
            return false;/*
        try (Connection connect = ConnectionHelper(user,password,database,server);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }*/
    }

    public List<Booking> getAllBookingsList() {


        List<Booking> bookList = new ArrayList<Booking>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BOOKINGS + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Booking book = new Booking();
                //usr.set_id(Integer.parseInt(cursor.getString(0)));
                //stdnt.set_enroll_no(Integer.parseInt(cursor.getString(1)));
                book.setU_name(cursor.getString(0));
                book.setW_id(cursor.getString(1));
                book.setDate_st(cursor.getString(2));
                book.setTime_st(cursor.getString(3));

                // Adding contact to list
                bookList.add(book);

            } while (cursor.moveToNext());
        }

        // return contact list
        return bookList;
    }


    // Getting All Users
    public List<user> getAllUserList() {


        List<user> studentList = new ArrayList<user>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USER_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                user use = new user();
                //use.set_id(Integer.parseInt(cursor.getString(0)));
                //stdnt.set_enroll_no(Integer.parseInt(cursor.getString(1)));
                use.setU_name(cursor.getString(2));
                use.setPass(cursor.getString(3));

                // Adding contact to list
                studentList.add(use);

            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return studentList;
    }

}
