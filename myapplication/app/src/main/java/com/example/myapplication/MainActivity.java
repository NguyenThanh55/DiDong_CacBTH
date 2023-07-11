package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null)
        {
            Log.e(TAG, "Bug!!!");
        }
        else
        {
            Log.e(TAG, "Welcome Thanh!!!");
        }

        setContentView(R.layout.activity_main);
    }
}