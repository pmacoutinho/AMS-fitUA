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

public class EstatisticasDadosActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> tipoExercicio = new ArrayList<>();
    ArrayList<String> titulo = new ArrayList<>();
    ArrayList<String> calorias_peso = new ArrayList<>();
    ArrayList<String> tempo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas_dados);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, EstatisticasActivity.class);
            startActivity(intent_back_arrow);
        });

        storeDataInArrays();

        CustomAdapter_Estatisticas customAdapterEstatisticas = new CustomAdapter_Estatisticas(this, this, id, tipoExercicio, titulo, calorias_peso, tempo);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEstatisticas);
        recyclerView.setAdapter(customAdapterEstatisticas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void storeDataInArrays() {
        Cursor cursor = databaseHelper.readAllData("estatisticas");

        if (cursor.getCount() == 0)
            Toast.makeText(this,"Ainda não foram introduzidos dados", Toast.LENGTH_SHORT).show();
        else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                tipoExercicio.add(cursor.getString(1));
                titulo.add(cursor.getString(2));
                calorias_peso.add(cursor.getString(3));
                tempo.add(cursor.getString(4));
            }
        }
    }
}
