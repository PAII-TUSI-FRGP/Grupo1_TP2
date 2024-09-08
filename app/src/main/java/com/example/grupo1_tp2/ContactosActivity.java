package com.example.grupo1_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ContactosActivity extends AppCompatActivity {

    private TextView tvContactos;

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

        tvContactos = (TextView) findViewById(R.id.listadoContatos);
        String archvivoContactos[] = fileList();
        if (archivoExist(archvivoContactos, "contactos.txt")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("contactos.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String agendaCompleta = "";

                while (linea != null) {
                    agendaCompleta = agendaCompleta + linea + "\n";
                    linea = br.readLine();

                }
                br.close();
                archivo.close();
                tvContactos.setText(agendaCompleta);

            } catch (Exception e) {
            }

        }






    }

    private boolean archivoExist(String[] archivoContactos, String nombreArchivo) {

        for (int i=0; i<archivoContactos.length; i++){

            if (nombreArchivo.equals(archivoContactos[i])){
                return true;

            }
        }
        return false;
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
}