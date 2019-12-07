package com.example.sqlitestudentinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbAdapter {

    DatabaseHelper databaseHelper;

    public DbAdapter(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    void insertintoDb(StudentModel student) {

        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues contentValu = new ContentValues();
        contentValu.put(DatabaseHelper.NAME, student.getName());
        contentValu.put(DatabaseHelper.EMAIL, student.getEmail());
        contentValu.put(DatabaseHelper.CGPA, student.getCgpa());
        contentValu.put(DatabaseHelper.PHONE, student.getPhone());

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValu);
        database.close();
    }


    public List<StudentModel> getAllData() {
        List<StudentModel> stuList = new ArrayList<>();
        String[] getcolum = {
                DatabaseHelper.ROW_ID,
                DatabaseHelper.NAME,
                DatabaseHelper.PHONE,
                DatabaseHelper.CGPA,
                DatabaseHelper.EMAIL
        };

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, getcolum,
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                {
                    StudentModel studentModel = new StudentModel();
                    studentModel.setId(cursor.getInt(0));
                    studentModel.setName(cursor.getString(1));
                    studentModel.setEmail(cursor.getString(2));
                    studentModel.setCgpa(cursor.getFloat(3));
                    studentModel.setPhone(cursor.getString(4));
                    stuList.add(studentModel);
                }
            } while (cursor.moveToNext());
        }
        return stuList;

    }
}
