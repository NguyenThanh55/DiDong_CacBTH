package com.example.ltdd_autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ArrayAdapterDemo4 extends Activity implements TextWatcher {
    TextView txtMsg;
    AutoCompleteTextView txtAutoComplete;

    String[] items = {
            "words", "starting", "with", "set", "Setback",
            "Setline", "Setoffs", "Setouts", "Setters", "Setting",
            "Settled", "Settler", "Wordless", "Wordiness", "Adios"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        txtAutoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        txtAutoComplete.addTextChangedListener(this);
        txtAutoComplete.setAdapter(new ArrayAdapter<String>(this,
                                    android.R.layout.simple_list_item_single_choice,
                                    items));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        txtMsg.setText(txtAutoComplete.getText());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


}
