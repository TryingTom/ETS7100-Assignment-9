package com.example.assignment9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class OmaAdapteri extends ArrayAdapter {
    private ArrayList<RoomEntity> lista;
    private Context context;

    public OmaAdapteri(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        lista = (ArrayList<RoomEntity>) objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            View v = LayoutInflater.from(context).inflate(R.layout.adapter_layout, parent, false);
            TextView Username = v.findViewById(R.id.UsernameTW);
            TextView Password = v.findViewById(R.id.PasswordTW);
            TextView Timestamp = v.findViewById(R.id.TimestampTW);

            Username.setText(lista.get(position).getUsername());
            Password.setText(lista.get(position).getPassword());
            Timestamp.setText(lista.get(position).getTimestamp());
            convertView = v;
        }
        return convertView;
    }
}