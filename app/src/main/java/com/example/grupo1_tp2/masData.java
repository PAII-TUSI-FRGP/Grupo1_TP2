package com.example.grupo1_tp2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.grupo1_tp2.SQLite.AdminSQLiteOpenHelper;
import com.example.grupo1_tp2.entidad.Contacto;

public class masData extends AppCompatActivity {
    private RadioButton primarioInconpmeto;
    private RadioButton primarioConpmeto;
    private RadioButton secundarioInconpmeto;
    private RadioButton secundarioConpmeto;
    private RadioButton otros;
    private CheckBox cbDeporte;
    private CheckBox cbArte;
    private CheckBox cbMusica;
    private CheckBox cbTecno;
    private Switch swRecibirNotificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mas_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        primarioInconpmeto = findViewById(R.id.rb_primario_incompleto);
        primarioConpmeto = findViewById(R.id.rb_primario_completo);
        secundarioInconpmeto = findViewById(R.id.rb_secundario_incompleto);
        secundarioConpmeto = findViewById(R.id.rb_secundario_completo);
        otros = findViewById(R.id.rb_otros);
        otros.setChecked(true);
        cbDeporte = findViewById(R.id.cb_deporte);
        cbArte = findViewById(R.id.cb_arte);
        cbMusica = findViewById(R.id.cb_musica);
        cbTecno = findViewById(R.id.cb_tecnologia);
        swRecibirNotificaciones = findViewById(R.id.sw_notificaciones);

    }

    public void gotoMain(View view) {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        Contacto contacto = (Contacto) b.getSerializable("contacto");
        Log.d("Llegocontacto", contacto.toString());

        String nivelDeEstudio = "";
        String intereses = "";

        if (primarioInconpmeto.isChecked()) {
            nivelDeEstudio = primarioInconpmeto.getText().toString();
        }
        if (primarioConpmeto.isChecked()) {
            nivelDeEstudio = primarioConpmeto.getText().toString();
        }
        if (secundarioInconpmeto.isChecked()) {
            nivelDeEstudio = secundarioInconpmeto.getText().toString();
        }
        if (secundarioConpmeto.isChecked()) {
            nivelDeEstudio = secundarioConpmeto.getText().toString();
        }
        if (otros.isChecked()) {
            nivelDeEstudio = otros.getText().toString();
        }

        contacto.setNivelDeEstudioAlcanzado(nivelDeEstudio);

        if(cbDeporte.isChecked()){
            intereses += cbDeporte.getText().toString() + ",";
        }
        if(cbArte.isChecked()){
            intereses += cbArte.getText().toString() + ",";
        }
        if(cbMusica.isChecked()) {
            intereses += cbMusica.getText().toString() + ",";
        }
        if(cbTecno.isChecked()) {
            intereses += cbTecno.getText().toString() + ",";
        }

        contacto.setIntereses(intereses);

        if(swRecibirNotificaciones.isChecked()){
            contacto.setNotificacion(true);
        }else{
            contacto.setNotificacion(false);
        }

        Log.d("Llegocontacto", contacto.toString());

        this.altaContactos(contacto);

        //Toast.makeText(this, "Guardar Datos", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void altaContactos(Contacto contacto) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "contacto", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nombre", contacto.getNombre());
        registro.put("apellido", contacto.getApellido());
        registro.put("telefono", contacto.getTelefono());
        registro.put("email", contacto.getEmail());
        registro.put("direccion", contacto.getDireccion());
        registro.put("fechaDeNacimiento", contacto.getFechaDeNacimiento());
        registro.put("nivelDeEstudioAlcanzado", contacto.getNivelDeEstudioAlcanzado());
        registro.put("intereses", contacto.getIntereses());
        registro.put("notificacion", contacto.isNotificacion());
        bd.insert("contactos", null, registro);
        bd.close();
        Toast.makeText(this, "Contacto guardado", Toast.LENGTH_SHORT).show();

    }

}