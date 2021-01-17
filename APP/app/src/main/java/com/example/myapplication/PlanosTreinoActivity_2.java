package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlanosTreinoActivity_2 extends AppCompatActivity {
    TextView text_descricao_casa, text_descricao_area, text_descricao_dificuldade,
            text_descricao_exercicios;
    String id, casa, area, dificuldade, exercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planos_treino2);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, PlanosTreinoActivity.class);
            startActivity(intent_back_arrow);
        });

        text_descricao_casa = findViewById(R.id.text_descricao_casa);
        text_descricao_area = findViewById(R.id.text_descricao_area);
        text_descricao_dificuldade = findViewById(R.id.text_descricao_dificuldade);
        text_descricao_exercicios = findViewById(R.id.text_descricao_exercicios);

        getAndSetIntentData();

        Button button_treino_ginasio = findViewById(R.id.button_treino_ginasio);
        Button button_treino_casa = findViewById(R.id.button_treino_casa);
        ViewGroup layout = (ViewGroup) button_treino_casa.getParent();

        if (Integer.parseInt(casa) == 0)
            layout.removeView(button_treino_casa);

        button_treino_ginasio.setOnClickListener(v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            boolean insert = databaseHelper.insertTreinos(0, Integer.parseInt(id), Integer.parseInt(casa), Integer.parseInt(dificuldade),
                    area, exercicios);

            if (insert)
                Toast.makeText(this, "Treino Adicionado", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        });

        button_treino_casa.setOnClickListener(v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            boolean insert = databaseHelper.insertTreinos(1, Integer.parseInt(id), Integer.parseInt(casa), Integer.parseInt(dificuldade),
                    area, exercicios);

            if (insert)
                Toast.makeText(this, "Treino Adicionado", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        });
    }

    @SuppressLint("SetTextI18n")
    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("casa") && getIntent().hasExtra("area")
                && getIntent().hasExtra("dificuldade") && getIntent().hasExtra("exercicios")){
            //Get
            id = getIntent().getStringExtra("id");
            casa = getIntent().getStringExtra("casa");
            area = getIntent().getStringExtra("area");
            dificuldade = getIntent().getStringExtra("dificuldade");
            exercicios = getIntent().getStringExtra("exercicios");

            //Set
            if (Integer.parseInt(casa) == 0)
                text_descricao_casa.setText("Não");
            else
                text_descricao_casa.setText("Sim");
            text_descricao_area.setText(area);
            text_descricao_dificuldade.setText(dificuldade);
            text_descricao_exercicios.setText(exercicios);
        } else
            Toast.makeText(this, "Não existem dados", Toast.LENGTH_SHORT).show();
    }
}
