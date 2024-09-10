package com.example.grupo1_tp2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.grupo1_tp2.SQLite.AdminSQLiteOpenHelper;
import com.example.grupo1_tp2.adapter.ContactoAdapter;
import com.example.grupo1_tp2.entidad.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactosActivity extends AppCompatActivity {
    private TextView tvContactos;
    private ListView lvContactos;
    private List<Contacto> listacontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contactos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvContactos = findViewById(R.id.tv_contactos);
        lvContactos = findViewById(R.id.lv_contactos);
        listacontactos = new ArrayList<>();

        this.consultarContactos();

        ContactoAdapter adapter = new ContactoAdapter(this, listacontactos);
        lvContactos.setAdapter(adapter);

        lvContactos.setOnItemClickListener((parent, view, position, id) -> {
            Contacto contacto = listacontactos.get(position);
            tvContactos.setText(contacto.toString());
        });

    }

    private void consultarContactos() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "contacto", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String consulta = "select * from contactos";
        Cursor fila = db.rawQuery(consulta, null);
        if (fila.moveToFirst()) {

            do {
                Contacto contacto = new Contacto();

                contacto.setNombre(fila.getString(0));
                contacto.setApellido(fila.getString(1));
                contacto.setTelefono(fila.getString(2));
                contacto.setEmail(fila.getString(3));
                contacto.setDireccion(fila.getString(4));
                contacto.setFechaDeNacimiento(fila.getString(5));
                contacto.setNivelDeEstudioAlcanzado(fila.getString(6));
                contacto.setIntereses(fila.getString(7));
                contacto.setNotificacion(fila.getString(8).equals("1") ? true : false);

                Log.d("LISTA", "8: " + fila.getString(8) + "---" + (fila.getString(8).equals("1") ? true : false));

                listacontactos.add(contacto);
            } while (fila.moveToNext());
            Toast.makeText(this, "Consulta exitosa: " + listacontactos.size(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.opcion1Agregar) {
            Toast.makeText(this, "Agregar contactos", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, FormularioAgregarContacto.class));
        }

        if (item.getItemId() == R.id.opcion2Listar) {
            Toast.makeText(this, "Listado de contactos", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ContactosActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}