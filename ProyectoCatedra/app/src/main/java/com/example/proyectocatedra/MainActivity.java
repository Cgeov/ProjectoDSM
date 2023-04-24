package com.example.proyectocatedra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.proyectocatedra.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myConstraintLayout = findViewById(R.id.inner_constraint_layout);

        myConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Intent intent = new Intent(MainActivity.this, AfterSplash.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "HA OCURRIDO UN ERROR", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}