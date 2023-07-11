package com.example.bth3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    Context context;
    List<Country> listCountry;
    LayoutInflater inflater;

    public CountryAdapter(Context context, List<Country> list) {
        context=context;
        listCountry=list;
        inflater=(LayoutInflater.from(context));

    }


    @Override
    public int getCount() {
        return listCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return listCountry.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.country_layout, null);
        TextView name = (TextView) convertView.findViewById(R.id.txtName);
        name.setText(listCountry.get(position).getName());
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        img.setImageResource(listCountry.get(position).getFlag());
        return convertView;
    }
}
