package com.example.sqlitestudentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DisplayInfo extends AppCompatActivity {

    DisplayAdapter displayAdapter;
    ListView listView;
    List<StudentModel> studentModelslist;
    DbAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        listView = findViewById(R.id.listViewId);
        dbAdapter = new DbAdapter(this);
        studentModelslist=dbAdapter.getAllData();
        displayAdapter = new DisplayAdapter(this, studentModelslist);
        listView.setAdapter(displayAdapter);

    }
}
