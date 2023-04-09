package com.example.proyectocatedra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

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
        String[] dataMonths = new String[] {
                "1 mes", "2 meses", "3 meses", "4 meses", "5 meses", "6 meses", "7 meses", "8 meses", "9 meses", "10 meses", "11 meses", "12 meses"
        };
        String[] dataYear = new String[] {
                "Menos de 1 Año", "1 a 3 Años", "3 a 10 años", "Más de 10 años"
        };
        String[] typeSalary = new String[] {
                "Mensual", "Quincenal", "Semana"
        };

        ArrayAdapter<String> spinnerDataArea = new ArrayAdapter<String>(this, R.layout.spinner_item, dataArea);
        ArrayAdapter<String> spinnerDataMonths = new ArrayAdapter<String>(this, R.layout.spinner_item, dataMonths);
        ArrayAdapter<String> spinnerDataYear = new ArrayAdapter<String>(this, R.layout.spinner_item, dataYear);
        ArrayAdapter<String> spinnerTypeSalary = new ArrayAdapter<String>(this, R.layout.spinner_item, typeSalary);

        Spinner spinnerArea = findViewById(R.id.spinnerArea);
        Spinner spinnerTipoSalario = findViewById(R.id.spinnerTipoSalario);
        Spinner spinnerAños = findViewById(R.id.spinnerAños);
        Spinner spinnerMeses = findViewById(R.id.spinnerMeses);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        ImageView btnRecords = findViewById(R.id.btnRecords);

        spinnerArea.setAdapter(spinnerDataArea);
        spinnerTipoSalario.setAdapter(spinnerTypeSalary);
        spinnerAños.setAdapter(spinnerDataYear);
        spinnerMeses.setAdapter(spinnerDataMonths);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculadora.this, Results.class);
                startActivity(intent);
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
