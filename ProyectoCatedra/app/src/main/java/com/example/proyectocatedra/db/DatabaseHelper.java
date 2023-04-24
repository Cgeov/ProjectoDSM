package com.example.proyectocatedra.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Salarios.db";
    public static final String TABLE_REGISTROS = "Registros";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_REGISTROS + "(" +
                "id Integer PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "area TEXT NOT NULL," +
                "tipo TEXT NOT NULL," +
                "salario_base TEXT NOT NULL," +
                "deducciones TEXT NOT NULL," +
                "aguinaldo TEXT NOT NULL," +
                "salario_neto TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_REGISTROS);
        onCreate(db);
    }
}
