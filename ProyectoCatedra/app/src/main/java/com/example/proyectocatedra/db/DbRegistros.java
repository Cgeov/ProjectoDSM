package com.example.proyectocatedra.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRegistros extends DatabaseHelper{

    Context context;

    public DbRegistros(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    //Función que ingresa registros
    public long InsertReg(String nombre, String area, String tipo, String salB, String deducciones, String aguinaldo, String slNeto){
        //Instanciando la variable ID para poder retornarla
        long id = 0;

        try{
            //Instanciando la clase DatabaseHelper e instanciando SQLiteDatabase para
            //Que permita insertar datos en una tabla especifica
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            //Guardando todos los parametros en una instancia de la class ContentValues
            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("area", area);
            values.put("tipo", tipo);
            values.put("salario_base", salB);
            values.put("deducciones", deducciones);
            values.put("aguinaldo", aguinaldo);
            values.put("salario_neto", slNeto);

            //Llamando la función insert de SQLiteDatabase, como es dbRegistros es una clase Heredada
            //de DatabaseHelper, podemos invocar parametros de DatabaseHelper
            //Y se insertan todos los datos que se encuentren en values
            id = db.insert(TABLE_REGISTROS,null,values);

            //NOTA: db.insert devuelve el id generado al momento de ingresar el valor en la BD
            
        }
        catch (Exception ex){
            ex.toString();
        }

        return id;
    }
}
