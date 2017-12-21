package com.example.shahalam.birthdaydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tv = findViewById(R.id.showDataText);

        MyDbFunctions mf = new MyDbFunctions(getApplicationContext());

       String[] data = mf.my_data();
        String s = "";
         for(int i=0; i<data.length; i++)
        {
            s = s + data[i] + "\n\n";
        }
        tv.setText(s);
    }
}
