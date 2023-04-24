package com.example.proyectocatedra;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Calculadora extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        String[] dataArea = new String[] {
                "Salud", "Informatica", "etc", "etc", "etc", "etc", "etc"
        };
        Integer[] dataMonths = new Integer[] {
                1,2,3,4,5,6,7,8,9,10,11,12
        };
        String[] dataYear = new String[] {
                "Menos de 1 Año", "1 a 3 Años", "3 a 10 años", "Más de 10 años"
        };
        String[] typeSalary = new String[] {
                "Mensual", "Quincenal", "Semanal"
        };

        ArrayAdapter<String> spinnerDataArea = new ArrayAdapter<String>(this, R.layout.spinner_item, dataArea);
        ArrayAdapter<Integer> spinnerDataMonths = new ArrayAdapter<Integer>(this, R.layout.spinner_item, dataMonths);
        ArrayAdapter<String> spinnerDataYear = new ArrayAdapter<String>(this, R.layout.spinner_item, dataYear);
        ArrayAdapter<String> spinnerTypeSalary = new ArrayAdapter<String>(this, R.layout.spinner_item, typeSalary);

        Spinner spinnerArea = findViewById(R.id.spinnerArea);
        Spinner spinnerTipoSalario = findViewById(R.id.spinnerTipoSalario);
        Spinner spinnerAños = findViewById(R.id.spinnerAños);
        Spinner spinnerMeses = findViewById(R.id.spinnerMeses);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        ImageView btnRecords = findViewById(R.id.btnRecords);
        EditText salario = findViewById(R.id.edtSalario);
        TextView bienvenida = findViewById(R.id.txtBienvenida);



        spinnerArea.setAdapter(spinnerDataArea);
        spinnerTipoSalario.setAdapter(spinnerTypeSalary);
        spinnerAños.setAdapter(spinnerDataYear);
        spinnerMeses.setAdapter(spinnerDataMonths);

        Bundle name = getIntent().getExtras();
        String personName = name.getString("name");

        bienvenida.setText(personName + ", Bienvenid@ :)");

        Toast toast = Toast.makeText(this,"Por favor ingrese su salario para continuar", Toast.LENGTH_LONG);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(salario.getText().toString().isEmpty()){
                    toast.show();
                }
                else{
                    String area = spinnerArea.getSelectedItem().toString();
                    String tipo = spinnerTipoSalario.getSelectedItem().toString();
                    String años = spinnerAños.getSelectedItem().toString();
                    Integer meses = Integer.parseInt(spinnerMeses.getSelectedItem().toString());

                    Bundle datos = new Bundle();
                    datos.putString("Area", area);
                    datos.putString("tipo", tipo);
                    datos.putString("años", años);
                    datos.putInt("meses", meses);
                    datos.putDouble("Salario", Double.parseDouble(salario.getText().toString()));
                    datos.putString("name", personName);

                    Intent intent = new Intent(Calculadora.this, Results.class);
                    intent.putExtras(datos);
                    startActivity(intent);
                }
            }
        });


        btnRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculadora.this, Records.class);
                startActivity(intent);
            }
        });
    }
}
