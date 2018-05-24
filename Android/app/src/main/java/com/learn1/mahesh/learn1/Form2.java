package com.learn1.mahesh.learn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Form2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        String nameString = getIntent().getStringExtra("name");
        TextView textViewName = findViewById(R.id.textViewForm2);
        textViewName.setText(nameString);

    }
}
