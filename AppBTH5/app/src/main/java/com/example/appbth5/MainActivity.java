package com.example.appbth5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtClass, txtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.ed1);
        txtClass = findViewById(R.id.ed2);
        txtAge = findViewById(R.id.ed3);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String strName = sh.getString("name", "");
        String StrClass = sh.getString("class", "");
        int iAge = sh.getInt("age", 0);

        txtName.setText(strName);
        txtClass.setText(StrClass);
        txtAge.setText(String.valueOf(iAge));
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = sh.edit();

        myEditor.putString("name", txtName.getText().toString());
        myEditor.putString("class", txtName.getText().toString());
        myEditor.putInt("age ", Integer.parseInt(txtAge.getText().toString()));

        myEditor.apply();
    }

}