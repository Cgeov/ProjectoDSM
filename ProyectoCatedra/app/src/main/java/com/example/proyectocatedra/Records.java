package com.example.proyectocatedra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Records extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CardData card1 = new CardData( 2000.00, 500.00, 2500.00);
        CardData card2 = new CardData( 3000.00, 600.00, 3600.00);
        CardData card3 = new CardData( 4000.00, 800.00, 4800.00);
        CardData card4 = new CardData( 4000.00, 800.00, 4800.00);
        CardData card5 = new CardData( 4000.00, 800.00, 4800.00);
        CardData card6 = new CardData( 4000.00, 800.00, 4800.00);
        List<CardData> cardDataList = new ArrayList<>();
        cardDataList.add(card1);
        cardDataList.add(card2);
        cardDataList.add(card3);
        cardDataList.add(card4);
        cardDataList.add(card5);
        cardDataList.add(card6);
        CardAdapter cardAdapter = new CardAdapter(cardDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
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
