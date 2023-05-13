package com.example.proyectocatedra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocatedra.db.DbRegistros;

public class ViewData extends AppCompatActivity {

    EditText edtSalario;
    Spinner Area, tipo, meses, años;
    Button btnUpdate, btnDelete;

    CardData cardData;
    int id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        String[] dataArea = new String[] {
                "Salud", "Informatica", "Agricultura", "Educación", "Recursos Humanos", "Marketing", "Contabilidad"
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

        Area = findViewById(R.id.spinnerArea);
        tipo = findViewById(R.id.spinnerTipoSalario);
        años = findViewById(R.id.spinnerAños);
        meses = findViewById(R.id.spinnerMeses);
        btnUpdate = findViewById(R.id.btnCalcular);
        btnDelete = findViewById(R.id.btnEliminar);
        ImageView btnRecords = findViewById(R.id.btnRecords);
        edtSalario = findViewById(R.id.edtSalario);
        TextView bienvenida = findViewById(R.id.txtBienvenida);



        Area.setAdapter(spinnerDataArea);
        tipo.setAdapter(spinnerTypeSalary);
        años.setAdapter(spinnerDataYear);
        meses.setAdapter(spinnerDataMonths);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                id = extras.getInt("id");
            }
            else{
                id = Integer.parseInt(null);
            }
        }
        else{
            id = (int)savedInstanceState.getSerializable("id");
        }

        DbRegistros dbRegistros = new DbRegistros(ViewData.this);
        cardData = dbRegistros.seeReg(id);

        if(cardData != null){
            bienvenida.setText(cardData.getNombre()+" Bienvenid@ :)");
            edtSalario.setText(cardData.getBaseSalary());

            for(int i= 0; i<=dataArea.length; i++){
                if(cardData.getArea().equals(dataArea[i])){
                    Area.setSelection(i);
                    break;
                }
            }
            for(int i =0; i<=typeSalary.length; i++){
                if(cardData.getTipo().equals(typeSalary[i])){
                    tipo.setSelection(i);
                    break;
                }
            }
        }
        Toast toast = Toast.makeText(this,"Por favor ingrese su salario para continuar", Toast.LENGTH_LONG);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSalario.getText().toString().isEmpty()){
                    toast.show();
                }
                else{
                    String area = Area.getSelectedItem().toString();
                    String Tipo = tipo.getSelectedItem().toString();
                    String Años = años.getSelectedItem().toString();
                    Integer Meses = Integer.parseInt(meses.getSelectedItem().toString());

                    Bundle datos = new Bundle();
                    datos.putInt("id", id);
                    datos.putString("Area", area);
                    datos.putString("tipo", Tipo);
                    datos.putString("años", Años);
                    datos.putInt("meses", Meses);
                    datos.putDouble("Salario", Double.parseDouble(edtSalario.getText().toString()));
                    datos.putString("name", cardData.getNombre());

                    Intent intent = new Intent(ViewData.this, updateRegist.class);
                    intent.putExtras(datos);
                    startActivity(intent);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewData.this);
                builder.setMessage("¿Está seguro que desea eliminar esta ficha?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(dbRegistros.DeleteReg(id)){
                                    Intent intent = new Intent(ViewData.this, Records.class);
                                    startActivity(intent);
                                }
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
    }
}