package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TreinoNoGinasioActivity_2 extends AppCompatActivity {
    TextView text_descricao_casa, text_descricao_area, text_descricao_dificuldade,
            text_descricao_exercicios;
    String id, casa, area, dificuldade, exercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_no_ginasio_2);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, TreinoNoGinasioActivity.class);
            startActivity(intent_back_arrow);
        });

        text_descricao_casa = findViewById(R.id.text_descricao_casa);
        text_descricao_area = findViewById(R.id.text_descricao_area);
        text_descricao_dificuldade = findViewById(R.id.text_descricao_dificuldade);
        text_descricao_exercicios = findViewById(R.id.text_descricao_exercicios);

        getAndSetIntentData();

        Button button_remover_treino = findViewById(R.id.button_remover_treino);

        button_remover_treino.setOnClickListener(v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            int delete = databaseHelper.deleteTreinos(0, id);

            if (delete > 0) {
                Toast.makeText(this, "Dados eliminados com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent_delete = new Intent(this, TreinoNoGinasioActivity.class);
                startActivity(intent_delete);
            } else
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
