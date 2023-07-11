package com.example.appbth4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtMsg;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtMsg = findViewById(R.id.txtMsg);
        btnBack = findViewById(R.id.btnBack);

        Bundle extras = getIntent().getExtras();
        String msg = extras.getString("MESSAGE");
        txtMsg.setText(msg);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}