package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen1.bd.BDHelper;

public class MainActivity extends AppCompatActivity {
    EditText txt_id, txt_nombre, txt_cargo, txt_area, txt_estado, txt_hijos, txt_atrasos, txt_horas, txt_sueldor,
            txt_subsidio, txt_horasr, txt_extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre =findViewById(R.id.txt_nombre);
        txt_cargo = findViewById(R.id.txt_cargo);
        txt_area = findViewById(R.id.txt_area);
        txt_estado = findViewById(R.id.txt_estado);
        txt_hijos = findViewById(R.id.txt_hijos);
        txt_atrasos = findViewById(R.id.txt_atrasos);
        txt_horas = findViewById(R.id.txt_horas);
        txt_sueldor = findViewById(R.id.txt_sueldor);
        txt_subsidio = findViewById(R.id.txt_subsidio);
        txt_horasr = findViewById(R.id.txt_horasr);
        txt_extras = findViewById(R.id.txt_extras);
    }

    public void registrar(View view){
        BDHelper admin = new BDHelper(this,"Registro.db",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre = txt_nombre.getText().toString();
        String cargo = txt_cargo.getText().toString();
        String area = txt_area.getText().toString();
        String estado = txt_estado.getText().toString();
        int hijos = Integer.parseInt(txt_hijos.getText().toString());
        String atrasos = txt_atrasos.getText().toString();
        int horas = Integer.parseInt(txt_horas.getText().toString());

            ContentValues registro = new ContentValues();
            registro.put("f_nombre",nombre);
            registro.put("f_cargo",cargo);
            registro.put("f_area",area);
            registro.put("f_estado",estado);
            registro.put("f_hijos",hijos);

            // Calcular el sueldo base en función del cargo
            double sueldoBase = 0;
            if (cargo.equalsIgnoreCase("Docente")) {
                sueldoBase = 1000;
            } else if (cargo.equalsIgnoreCase("Funcionario")) {
                sueldoBase = 880;
            }
            registro.put("f_sueldo",sueldoBase);


            // Calcular el subsidio en función del número de hijos
            double subsidio = hijos * 50;
            registro.put("f_subsidio",subsidio);


            registro.put("f_atrasos",atrasos);
            registro.put("f_horas",horas);


            // Calcular el sueldo total
            double sueldoTotal = sueldoBase + subsidio + (horas * 12);
            registro.put("f_sueldoT", sueldoTotal);


            bd.insert("t_funcionario", null,registro);
            bd.close();
            Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();

            txt_sueldor.setText(this.determinarSueldo(cargo)+"");
            txt_subsidio.setText(this.subsidio(hijos)+"");
            txt_horasr.setText(sueldoTotal+"");
          

    }

    public double determinarSueldo(String cargo){
        double sueldo=0.00;
        //String cargo=et_cargo.getText().toString();
        if (cargo.equals("Administrativo")==true) {
            sueldo=880.00;
        }else if(cargo.equals("Docente")==true){

            sueldo= 1000.00;
        }
        return sueldo;
    }

    public double subsidio(int numero){
        double sub=0.00;


        if(numero>0){
            sub=numero*50;
        }else{
            sub=0;
        }
        return sub;
    }

    public double Calculohoras(double horas){
        double extras = 0;
        if (horas>0){
            extras = horas * 12;
        }else {
            return extras = 0;
        }
        return extras;
    }

    public void descuento(String item, double sueldo){
        double des = 0.00;
        if (item.equals("Si")==true){
            des = sueldo*0.08;
        }else {
            des = 0;
        }
    }


    public void modificar(View view) {
        BDHelper admin = new BDHelper(this, "Registro.db", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String id = txt_id.getText().toString();
        String nombre = txt_nombre.getText().toString();


        String tabla = "t_funcionario";
        String campoID = "usu_id";
        String clausura = campoID + " = ?";
        String[] where = { id };

        ContentValues registro = new ContentValues();
        registro.put("f_nombre",nombre);

        int registrosActualizados = bd.update(tabla, registro, clausura, where);
        if (registrosActualizados > 0) {
            Toast.makeText(this, "Registro modificado exitosamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontró el registro a modificar", Toast.LENGTH_SHORT).show();
        }

        bd.close();
    }


}