package com.example.proyectocatedra;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectocatedra.db.DbRegistros;

public class Results extends AppCompatActivity {

    EditText salarioB;
    EditText tipoSal;
    EditText tiempo;
    EditText ISSS;
    EditText AFP;
    EditText RENT;
    EditText descT;
    TextView salNeto;
    TextView aguinaldo;

    double renta = 0.0;
    double afp = 0.00;
    double isss = 0.00;
    double preRent = 0.00;
    double totalDesc = 0.00;
    double excedente = 0.00;
    double sueldoneto = 0.00;
    double Aguinaldo = 0.00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        ImageView btnViewRecord = findViewById(R.id.btnViewRecords);
        ImageView btnAddMore = findViewById(R.id.btnAddMore);

        salarioB = findViewById(R.id.salarioB);
        tipoSal = findViewById(R.id.tipoSal);
        tiempo = findViewById(R.id.tiempo);
        ISSS = findViewById(R.id.isss);
        AFP = findViewById(R.id.afp);
        RENT = findViewById(R.id.renta);
        descT = findViewById(R.id.descT);
        salNeto = findViewById(R.id.salNeto);
        aguinaldo = findViewById(R.id.aguinaldo);


        //Recibiendo datos de pantalla "Calculadora" con bundle
        Bundle recept = getIntent().getExtras();
        //Verificando que el bundle no esté vacío
        if(recept != null){
            //Recibiendo los datos
            String area = recept.getString("Area");
            String tipo = recept.getString("tipo");
            String año = recept.getString("años");
            Integer meses = recept.getInt("meses");
            Double salario = recept.getDouble("Salario");
            String name = recept.getString("name");

            salarioB.setText("$"+salario.toString());
            tipoSal.setText(tipo);
            tiempo.setText(año);
            //Llamado las funciones para realizar calculos
            CalcularDesc(salario);
            CalcularAguinald(año,salario,meses);
            //Instanciando la clase DbRegistros para llamar al metodo insertar
            DbRegistros dbRegistros = new DbRegistros(Results.this);
            long id = dbRegistros.InsertReg(name,area,tipo,salarioB.getText().toString(),descT.getText().toString(),
                    aguinaldo.getText().toString(),salNeto.getText().toString());
            //validando que se insertó un registro
            if(id > 0){
                Toast.makeText(Results.this, "Registro insertado con éxito", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Results.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Vacio", Toast.LENGTH_LONG);
        }


        btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, Calculadora.class);
                startActivity(intent);
            }
        });


        btnViewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, Records.class);
                startActivity(intent);
            }
        });

    }

    private void CalcularDesc(Double salario){

        if(salario >= 0.01 && salario <= 472){
            isss =salario*0.03;
            afp = salario*0.0725;
            totalDesc = isss + afp;
            sueldoneto = salario - totalDesc;
        }
        else if(salario >= 472.01 && salario<= 895.24){
            isss = salario*0.03;
            afp = salario*0.0725;
            preRent = salario - isss - afp;
            excedente = preRent - 472;
            renta = (excedente * 0.1) + 17.67;
            totalDesc = isss + afp + renta;
            sueldoneto = salario - totalDesc;
        }
        else if(salario >= 895.25 && salario <= 2038.10){
            isss = salario*0.03;
            afp = salario*0.0725;
            preRent = salario - isss - afp;
            excedente = preRent - 895.24;
            renta = (excedente * 0.2) + 60;
            totalDesc = isss + afp + renta;
            sueldoneto = salario - totalDesc;
        }
        else if(salario >= 2038.11){
            isss = salario*0.03;
            afp = salario*0.0725;
            preRent = salario - isss - afp;
            excedente = preRent - 2038.10;
            renta = (excedente * 0.3) + 288.57;
            totalDesc = isss + afp + renta;
            sueldoneto = salario - totalDesc;
        }

        ISSS.setText(String.format("$ %.2f", isss));
        AFP.setText(String.format("$ %.2f", afp));
        RENT.setText(String.format("$ %.2f", renta));
        descT.setText(String.format("$ %.2f", totalDesc));
        salNeto.setText(String.format("$ %.2f", sueldoneto));
    }

    private void CalcularAguinald(String tiempo, Double salario, Integer meses){
        if(tiempo.equals("Menos de 1 Año")){
            for(int i =0; i<=meses; i++){
                if(i == meses){
                    Aguinaldo = ((salario/30)*15)*(meses*30)/365;
                }
            }
        }
        else if(tiempo.equals("1 a 3 Años")){
            Aguinaldo = (salario/30)*15;
        }
        else if(tiempo.equals("3 a 10 años")){
            Aguinaldo = (salario/30)*19;
        }
        else if(tiempo.equals("Más de 10 años")){
            Aguinaldo = (salario/30)*21;
        }

        aguinaldo.setText(String.format("$ %.2f", Aguinaldo));
    }
}
