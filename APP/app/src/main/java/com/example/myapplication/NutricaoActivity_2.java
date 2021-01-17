package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NutricaoActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricao_2);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, NutricaoActivity.class);
            startActivity(intent_back_arrow);
        });

        RadioGroup radioGroup_nutricao = findViewById(R.id.radioGroup_nutricao);
        Button button_confirmar = findViewById(R.id.button_confirmar);

        button_confirmar.setOnClickListener(v -> {
            if (radioGroup_nutricao.getCheckedRadioButtonId() != -1) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(NutricaoActivity_2.this);
                alertBuilder.setTitle("Confirmação");
                alertBuilder.setMessage("Confirma a marcação da consulta?");

                alertBuilder.setPositiveButton("Sim", (dialog, which) -> {
                    Toast.makeText(NutricaoActivity_2.this, "Consulta marcada", Toast.LENGTH_SHORT).show();
                    Intent intent_confirmacao = new Intent(NutricaoActivity_2.this, MenuPrincipalActivity.class);
                    startActivity(intent_confirmacao);
                });

                alertBuilder.setNegativeButton("Não", (dialog, which) ->
                        Toast.makeText(NutricaoActivity_2.this, "Consulta não marcada", Toast.LENGTH_SHORT).show());

                alertBuilder.show();

            } else
                Toast.makeText(this, "Selecione uma hora", Toast.LENGTH_SHORT).show();
        });

    }
}
