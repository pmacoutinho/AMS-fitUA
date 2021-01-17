package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class TreinoEmCasaActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> casa = new ArrayList<>();
    ArrayList<String> dificuldade = new ArrayList<>();
    ArrayList<String> areas = new ArrayList<>();
    ArrayList<String> exercicios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_em_casa);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intent_back_arrow);
        });

        storeDataInArrays();

        CustomAdapter_TreinoCasa customAdapterTreinoCasa = new CustomAdapter_TreinoCasa(this, this, id, casa, dificuldade, areas, exercicios);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTreinoCasa);
        recyclerView.setAdapter(customAdapterTreinoCasa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void storeDataInArrays() {
        Cursor cursor = databaseHelper.readAllData("treinos_casa");

        if (cursor.getCount() == 0)
            Toast.makeText(this,"Ainda não foram introduzidos dados", Toast.LENGTH_SHORT).show();
        else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                casa.add(cursor.getString(1));
                dificuldade.add(cursor.getString(2));
                areas.add(cursor.getString(3));
                exercicios.add(cursor.getString(4));
            }
        }
    }
}
