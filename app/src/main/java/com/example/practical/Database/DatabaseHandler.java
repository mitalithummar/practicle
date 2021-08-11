
package com.example.practical.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.practical.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TaskManager";
    private static final String TABLE_CONTACTS = "Task";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESC = "desc";
    private static final String KEY_REMIND_DATE = "remind me";
    private static final String KEY_DUE_DATE = "due date";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance  
    }

    // Creating Tables  
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT,"
                + KEY_DESC + "TEXT,"
                + KEY_REMIND_DATE + "TEXT,"
                + KEY_DUE_DATE + "TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database  
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed  
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again  
        onCreate(db);
    }

    // code to add the new contact  
    public void addTask(Task contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, contact.getTitle());
        values.put(KEY_DESC, contact.getDescription());
        values.put(KEY_REMIND_DATE, contact.getRemindMe());
        values.put(KEY_DUE_DATE, contact.getDueDate());

        // Inserting Row  
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack  
        db.close(); // Closing database connection  
    }

    // code to get all Task in a list view  
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> TaskList = new ArrayList<Task>();
        // Select All Query  
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list  
        if (cursor.moveToFirst()) {
            do {
                Task contact = new Task();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.setTitle(cursor.getString(1));
                contact.setDescription(cursor.getString(2));
                contact.setRemindMe(cursor.getString(3));
                contact.setDueDate(cursor.getString(4));
                // Adding contact to list
                TaskList.add(contact);
            } while (cursor.moveToNext());
        }

        // return Task list  
        return TaskList;
    }

    // code to update the single Task  
    public int updateTask(Task contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, contact.getTitle());
        values.put(KEY_DESC, contact.getDescription());
        values.put(KEY_REMIND_DATE, contact.getRemindMe());
        values.put(KEY_DUE_DATE, contact.getDueDate());

        // updating row  
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.get_id())});
    }

    // Deleting single Task  
    public void deleteTask(Task contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.get_id())});
        db.close();
    }


}  