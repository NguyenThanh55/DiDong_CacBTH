package com.example.appbth52;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button btnSave, btnLoad;
    TextView textView1;
    EditText editText;

    String data;
    private String file = "myFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        textView1 = findViewById(R.id.textView1);
        editText = findViewById(R.id.editText);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = editText.getText().toString();
                try{
                    FileOutputStream fOut = openFileOutput(file, MODE_APPEND);
                    fOut.write(data.getBytes(StandardCharsets.UTF_8));
                    fOut.close();
                    Toast.makeText(MainActivity.this, "File save sucessfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fIn = openFileInput(file);
                    int c;
                    String temp ="";
                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char)c);
                    }
                    fIn.close();
                    textView1.setText(temp);
                    Toast.makeText(MainActivity.this, "File read successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}