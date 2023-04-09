package com.example.proyectocatedra;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        ImageView btnViewRecord = findViewById(R.id.btnViewRecords);
        ImageView btnAddMore = findViewById(R.id.btnAddMore);

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
}
