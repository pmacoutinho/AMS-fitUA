package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class EstatisticasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intent_back_arrow);
        });

        Button button_abrir_estatisticas = findViewById(R.id.button_abrir_estatisticas);

        button_abrir_estatisticas.setOnClickListener(v -> {
            Intent intent_abrir = new Intent(this, EstatisticasDadosActivity.class);
            startActivity(intent_abrir);
        });

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_tipo_treino, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;

                    case 1:
                        Intent intent_cardio = new Intent(EstatisticasActivity.this, EstatisticasCardioActivity.class);
                        startActivity(intent_cardio);
                        break;

                    case 2:
                        Intent intent_pesos = new Intent(EstatisticasActivity.this, EstatisticasPesosActivity.class);
                        startActivity(intent_pesos);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
