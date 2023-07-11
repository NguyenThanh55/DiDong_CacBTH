package com.example.farmmarket.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.farmmarket.R;

public class MainActivity extends AppCompatActivity {

    EditText txtSDT;
    EditText txtPass;
    private Button btnDangNhap;
    private Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSDT = (EditText) findViewById(R.id.txtSDT);
        txtPass = (EditText) findViewById(R.id.txtPass);

        btnDangNhap = (Button) findViewById(R.id.btn_dangnhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdt = String.valueOf(txtSDT.getText());
                String pass = txtPass.getText().toString();
                Log.d("SDT", sdt);
                Log.d("PASS", pass);
                if(sdt.length()==10 && pass.length()>0) {
                    startActivity(new Intent(MainActivity.this, IntroActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), sdt, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}