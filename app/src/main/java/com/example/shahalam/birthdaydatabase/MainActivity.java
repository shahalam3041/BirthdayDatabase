package com.example.shahalam.birthdaydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etBirthday;
    Button btnSave, btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etBirthday = findViewById(R.id.etBirthday);
        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);

       final MyDbFunctions mf = new MyDbFunctions(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = etName.getText().toString();
                String _bday = etBirthday.getText().toString();

                DataTemp dt = new DataTemp(_name, _bday);
                mf.addingDataToTable(dt);

                Toast.makeText(getApplicationContext(), "Data added succesfully", Toast.LENGTH_LONG).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowData.class);
                startActivity(intent);
            }
        });
    }

}
