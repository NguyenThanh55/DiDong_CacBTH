package com.example.bth1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail;
    EditText txtPass;
    Button btLogin;
    TableLayout tb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPass = (EditText)findViewById(R.id.txtPass);
        btLogin = (Button) findViewById(R.id.btLogin);
        tb = (TableLayout)findViewById(R.id.tb);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String pass = txtPass.getText().toString();
                Log.d("EMAIL", email);
                Log.d("PASS", pass);
                if(isValid(email) && pass.length()>0) {
                    addToTable();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Email not valid!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private boolean isValid(String email) {
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))" +
                "\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(email);
        return matcher.matches();
    }

    private void addToTable() {
        TableRow tableRow = new TableRow(getApplicationContext());
        TextView t1 = new TextView(getApplicationContext());
        t1.setText(txtEmail.getText().toString());
        TextView t2 = new TextView(getApplicationContext());
        t2.setText(" " + txtPass.getText().toString());
        tableRow.addView(t1);
        tableRow.addView(t2);
        tb.addView(tableRow);
    }
}