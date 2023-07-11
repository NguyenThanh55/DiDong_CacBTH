package com.example.ltdd_floatingmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtAlert;
    Button btnAlert, btnTraditionalList;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAlert = (TextView) findViewById(R.id.txtAlert);
        btnAlert = (Button) findViewById(R.id.btnAlert);
        btnTraditionalList= (Button) findViewById(R.id.btnTraditionalList);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thoát").setMessage("Bạn muốn thoát chương trình?").setIcon(R.drawable.ic_launcher_foreground).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtAlert.setText("YES " + Integer.toString(which));
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtAlert.setText("CANCEL " + Integer.toString(which));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtAlert.setText("NO " + Integer.toString(which));
                    }
                })
                        .create().show();
            }
        });

        btnTraditionalList.setOnClickListener(new View.OnClickListener() {
            String[] colors_array = { "RED", "GREEN", "BLUE" };
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.pick_color).setItems(colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                            txtAlert.setTextColor(Color.RED);
                            break;
                                case 1:
                                    txtAlert.setTextColor(Color.GREEN);
                                    break;
                                case 2:
                                    txtAlert.setTextColor(Color.BLUE);
                                    break;
                        }
                    }
                }).create()   .show();    }});

    }
}