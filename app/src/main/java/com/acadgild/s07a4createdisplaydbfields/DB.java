package com.acadgild.s07a4createdisplaydbfields;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunny on 9/14/16.
 */
public class DB extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    private static final String DB_NAME = "student_db";

    private static final String TABLE_NAME = "student_details";

    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";

    private static final String[] COLUMNS = {ID, FIRST_NAME, LAST_NAME};

    public DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRST_NAME + " TEXT, "
                + LAST_NAME + " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void addAStudentDetails(StudentDetails details) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, details.getFName());
        values.put(LAST_NAME, details.getLName());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public List<StudentDetails> getAllStudentsDetail(){

        List<StudentDetails> studentDetailsList = new LinkedList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME, null);

        StudentDetails details;
        if (cursor.moveToFirst()){
            do {
                details = new StudentDetails();
                details.setId(Integer.parseInt(cursor.getString(0)));
                details.setFName(cursor.getString(1));
                details.setLName(cursor.getString(2));

                studentDetailsList.add(details);
            }while (cursor.moveToNext());
        }

        return studentDetailsList;
    }
}
