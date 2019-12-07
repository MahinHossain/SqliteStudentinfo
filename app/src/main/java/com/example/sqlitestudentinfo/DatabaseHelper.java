package com.example.sqlitestudentinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    static final int DATABASE_Verson = 3;
    static final String DATABASE_Name = "studentdb.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_Name, null, DATABASE_Verson);
    }

    public static final String TABLE_NAME = "student_Info_table";
    public static final String  ROW_ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String CGPA = "cgpa";
    public static final String PHONE = "phone";

    public static final String CREATE_TABLE = " CREATE TABLE  " + TABLE_NAME + "("
            + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT   UNIQUE  NOT NULL, "
            + NAME + " TEXT, "
            + EMAIL + " TEXT, "
            + CGPA + " TEXT, "
            + PHONE + " TEXT " + ")";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);

    }
}
