package com.example.bth3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Country> listCountry;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.lst);
        getCountryList();

        CountryAdapter c = new CountryAdapter(this, listCountry);
        listView.setAdapter(c);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Position: " + position + "\n";
                msg += "Quốc gia: " + listCountry.get(position).getName();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Ok ", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel!!! ", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();

            }
        });
    }

    protected void getCountryList() {
        listCountry = new ArrayList<>();
        listCountry.add(new Country("India", R.drawable.ic_flag));
        listCountry.add(new Country("China", R.drawable.ic_flag));
        listCountry.add(new Country("Australia", R.drawable.ic_flag));
        listCountry.add(new Country("Long An", R.drawable.ic_flag));
        listCountry.add(new Country("Viet Nam", R.drawable.ic_flag));

    }
}