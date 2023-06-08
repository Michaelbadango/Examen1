package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txt_nombre, txt_cargo, txt_area, txt_estado, txt_hijos, txt_sueldo, txt_subsidio,
    txt_atrasos, txt_horas, txt_sueldoT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre =findViewById(R.id.txt_nombre);
        txt_cargo = findViewById(R.id.txt_cargo);
        txt_area = findViewById(R.id.txt_area);
        txt_estado = findViewById(R.id.txt_estado);
        txt_hijos = findViewById(R.id.txt_hijos);
        txt_sueldo = findViewById(R.id.txt_subsidio);
        txt_subsidio = findViewById(R.id.txt_subsidio);
        txt_atrasos = findViewById(R.id.txt_atrasos);
        txt_horas = findViewById(R.id.txt_horas);
        txt_sueldoT = findViewById(R.id.txt_sueldoT);
    }

    public void registrar(View view){
        
    }
}