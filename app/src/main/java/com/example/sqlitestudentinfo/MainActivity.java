package com.example.sqlitestudentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name, phone, email, cgpa;
    Button save, show;
    DbAdapter dbAdapter;
    List<StudentModel> studentModelslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameId);
        phone = findViewById(R.id.phoneId);
        email = findViewById(R.id.emailId);
        cgpa = findViewById(R.id.cgpaId);
        save = findViewById(R.id.saveId);
        show = findViewById(R.id.showId);
        dbAdapter = new DbAdapter(this);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DisplayInfo.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //

                boolean erro = false;
                String nam = name.getText().toString();


                if (nam.isEmpty()) {
                    name.setError(" Enter Nmae");
                    erro = true;
                } else {
                    erro = false;

                }
                String phn = phone.getText().toString();


                if (phn.isEmpty()) {
                    phone.setError(" Enter phone");
                    erro = true;
                } else {
                    erro = false;

                }
                float cgp = Float.valueOf(cgpa.getText().toString());
                if (cgp > 4) {
                    cgpa.setError(" Enter currently  cgpa");
                    erro = true;
                } else {
                    erro = false;

                }
                String emai = email.getText().toString();
                if (emai.isEmpty()) {
                    email.setError(" Enter email");
                    erro = true;

                } else {
                    erro = false;

                }


                if (erro) {
                    Toast.makeText(MainActivity.this, "Data not inserterd corretly", Toast.LENGTH_LONG).show();
                } else {
                    clearData();
                    StudentModel astudentmoodel = new StudentModel(nam, emai, phn, cgp);
                    dbAdapter.insertintoDb(astudentmoodel);
//                    studentModelslist.clear();
                    Toast.makeText(MainActivity.this, "Successfully  inserterd ", Toast.LENGTH_LONG).show();
                }

            }

        });


    }

    private void clearData() {

        name.setText(null);
        cgpa.setText(null);
        email.setText(null);
        phone.setText(null);
    }

}
