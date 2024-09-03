package com.example.grupo1_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioAgregarContacto extends AppCompatActivity {

    Spinner spinTelefono, spinEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //GA cargo los spinners
        spinTelefono= (Spinner)findViewById(R.id.spinnerTelefono);
        spinEmail=(Spinner)findViewById(R.id.spinnerEmail);
        String[] opciones = {"Casa", "Trabajo", "Movil"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        spinTelefono.setAdapter(adapter);
        spinEmail.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.opcion1Agregar){
            Toast.makeText(this, "Agregar contactos", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, FormularioAgregarContacto.class));
        }

        if(item.getItemId() == R.id.opcion2Listar){
            Toast.makeText(this, "Listado de contactos", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ContactosActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    //funcion navegar activity Ejercicio1Activity
    public void gotoMasDatos(View view) {
        Intent intent = new Intent(this, FrmMasDatosContacto.class);
        startActivity(intent);
    }
}