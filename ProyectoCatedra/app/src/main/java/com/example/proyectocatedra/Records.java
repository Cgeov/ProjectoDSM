package com.example.proyectocatedra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectocatedra.db.DbRegistros;

import java.util.ArrayList;
import java.util.List;

public class Records extends AppCompatActivity {

    ArrayList<CardData> listRegist;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listRegist = new ArrayList<>();

        DbRegistros dbRegistros = new DbRegistros(Records.this);

        CardAdapter cardAdapter = new CardAdapter(dbRegistros.showReg());
        recyclerView.setAdapter(cardAdapter);


        LinearLayout btnBackButton = findViewById(R.id.btnBackButton);


        btnBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Records.this, Calculadora.class);
                startActivity(intent);
            }
        });
    }
}
