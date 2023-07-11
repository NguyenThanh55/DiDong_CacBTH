package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView txtMsg;
    Spinner spinner;

    String[] items = {"Data-0", "Data-1", "Data-2", "Data-3", "Data-4", "Data-5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtMsg = (TextView) findViewById(R.id.txtMsg);

        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                items);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txtMsg.setText(items[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}