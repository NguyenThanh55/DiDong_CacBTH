package com.example.ltdd_actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show();
            return true;
        }
            if (id == R.id.action_share) {
                Toast.makeText(this, "About button selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (id == R.id.action_download) {
                Toast.makeText(this, "Help button selected", Toast.LENGTH_SHORT).show();
                return true;}
        return super.onOptionsItemSelected(item);}

}