package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class EstatisticasPesosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas_pesos);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intent_back_arrow);
        });

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_pesos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;

                    case 1:
                        Intent intent_cardio = new Intent(EstatisticasPesosActivity.this, EstatisticasCardioActivity.class);
                        startActivity(intent_cardio);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        EditText editText_titulo = findViewById(R.id.editText_pesos_titulo);
        EditText editText_peso = findViewById(R.id.editText_pesos_peso);
        EditText editText_tempo = findViewById(R.id.editText_pesos_tempo);
        Button button_confirmar_pesos = findViewById(R.id.button_confirmar_pesos);

        button_confirmar_pesos.setOnClickListener(v -> {

            String titulo = editText_titulo.getText().toString();
            String peso = editText_peso.getText().toString();
            String tempo = editText_tempo.getText().toString();

            if (!titulo.matches("") && !peso.matches("") && !tempo.matches("")) {
                DatabaseHelper databaseHelper = new DatabaseHelper(this);
                boolean insert = databaseHelper.insertEstatistica(1, titulo, peso, tempo);

                if (insert) {
                    Toast.makeText(this, "Estatisticas Guardadas", Toast.LENGTH_SHORT).show();
                    Intent intent_confirmar = new Intent(this, EstatisticasActivity.class);
                    startActivity(intent_confirmar);
                } else
                    Toast.makeText(this, "Ocorreu um erro ao guardar!", Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(this, "Preencha todos os dados", Toast.LENGTH_SHORT).show();
        });

    }
}
