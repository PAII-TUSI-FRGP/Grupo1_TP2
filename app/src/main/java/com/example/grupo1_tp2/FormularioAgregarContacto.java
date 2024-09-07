package com.example.grupo1_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

    public void onClickContinuar (View view)
    {
        // Obtengo los valores de los campos de texto
        String nombre = ((EditText) findViewById(R.id.editTextText)).getText().toString();
        String apellido = ((EditText) findViewById(R.id.editTextText3)).getText().toString();
        String telefono = ((EditText) findViewById(R.id.editTextText5)).getText().toString();
        String email = ((EditText) findViewById(R.id.editTextText4)).getText().toString();
        String fechaNacimiento = ((EditText) findViewById(R.id.editTextDate)).getText().toString();

        // Se Valida que solo se cuente con letras en el text
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            Toast.makeText(this, "El nombre no debe contener números", Toast.LENGTH_SHORT).show();
            return;
        }
        // Se Valida que solo se cuente con letras en el text
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            Toast.makeText(this, "El apellido no debe contener números", Toast.LENGTH_SHORT).show();
            return;
        }

        // Se valida en Teléfono (Solo números, guiones permitidos y el simbolo + )
        if (!telefono.matches("[0-9-+]+")) {
            Toast.makeText(this, "El teléfono solo debe contener números y guiones", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar Email (Formato de email válido)
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Ingrese un email válido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar Fecha de Nacimiento (Formato de DD-MM-YYYY)
        if (!fechaNacimiento.matches("\\d{2}-\\d{2}-\\d{4}")) { // Formato esperado: yyyy-MM-dd
            Toast.makeText(this, "Ingrese una fecha de nacimiento válida (Formato: DD-MM-YYYY)", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mensaje para saber si todo salio bien
        Toast.makeText(this, "Formulario validado con éxito", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Formulario2Activity.class));
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
        Intent intent = new Intent(this, masData.class);
        startActivity(intent);
    }
}