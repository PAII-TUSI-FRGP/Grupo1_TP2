package com.example.grupo1_tp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.OutputStreamWriter;
import java.security.PublicKey;

public class masData extends AppCompatActivity {

    private RadioGroup rgEstudios;
    private CheckBox chkDeporte, chkArte, chkMusica, chkTecno;
    private Switch swQuieroMas;

    String nombreRecibido = "";
    String apellidoRecibido = "";
    String emailRecibido = "";

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

        nombreRecibido = getIntent().getStringExtra("nombre");
        apellidoRecibido = getIntent().getStringExtra("apellido");
        emailRecibido = getIntent().getStringExtra("email");

        /*
        rgEstudios = findViewById(R.id.rgEstudios);
        chkDeporte = findViewById(R.id.chkDeporte);
        chkArte = findViewById(R.id.chkArte);
        chkMusica = findViewById(R.id.chkMusica);
        chkTecno = findViewById(R.id.chkTecno);
        swQuieroMas = findViewById(R.id.swQuieroMas);

         */
    }

    public void gotoMain(View view) {
        Toast.makeText(this, "Guardar Datos", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // GA  BOTON GUARDAR
    public void  guardar(View view){
        // capturlo lo ingresado
        /*
        int selectedRadioButtonId = rgEstudios.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String nivelEstudios = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "No seleccionado";
        boolean deporte = chkDeporte.isChecked();
        boolean arte = chkArte.isChecked();
        boolean musica = chkMusica.isChecked();
        boolean tecno = chkTecno.isChecked();
        boolean quieroMas = swQuieroMas.isChecked();
        String preferencias = "";
        */
        //unicos tres datos que me interesan por ahora

       Toast.makeText(this, emailRecibido, Toast.LENGTH_SHORT).show();

       /*
       String telefono =getIntent().getStringExtra(getIntent().getStringExtra("telefono"));

       //String direccion = getIntent().getStringExtra(getIntent().getStringExtra("direccion"));
       //String fechaNacimiento =  getIntent().getStringExtra(getIntent().getStringExtra("fechaNacimiento"));

        Toast.makeText(this, direccion, Toast.LENGTH_SHORT).show();


        if (deporte) {
            preferencias += "Deporte, ";
        }
        if (arte) {
            preferencias += "Arte, ";}
            if(musica){ preferencias += "Musica, ";}
                if(tecno){ preferencias += "Tecnologia, ";}


        String datos =   "Nivel de estudios: " + nivelEstudios;
        */
        try{
        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("contactos.txt", Activity.MODE_PRIVATE));
        archivo.write(nombreRecibido+", "+ apellidoRecibido + ": "+ emailRecibido);
        archivo.flush();
        archivo.close();


        }catch (Exception e){}

        //Toast.makeText(this, "Guardar Datos", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ContactosActivity.class);

        startActivity(intent);

    }

}