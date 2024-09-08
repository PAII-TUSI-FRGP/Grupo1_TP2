package com.example.grupo1_tp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.grupo1_tp2.R;
import com.example.grupo1_tp2.entidad.Contacto;

import java.util.List;

public class ContactoAdapter extends ArrayAdapter<Contacto> {
    public ContactoAdapter(Context context, List<Contacto> contactos) {
        super(context, R.layout.list_template, contactos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_template, null);

        TextView txtNombreApellidoEmail = item.findViewById(R.id.txt_nombre_apellido_email);

        txtNombreApellidoEmail.setText(getItem(position).getNombre() + " " + getItem(position).getApellido() + " - " + getItem(position).getEmail());

        return item;
    }
}
