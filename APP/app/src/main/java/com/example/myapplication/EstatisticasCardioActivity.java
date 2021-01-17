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

public class EstatisticasCardioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas_cardio);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intent_back_arrow);
        });

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_cardio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;

                    case 1:
                        Intent intent_pesos = new Intent(EstatisticasCardioActivity.this, EstatisticasPesosActivity.class);
                        startActivity(intent_pesos);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        EditText editText_titulo = findViewById(R.id.editText_cardio_titulo);
        EditText editText_calorias = findViewById(R.id.editText_cardio_calorias);
        EditText editText_tempo = findViewById(R.id.editText_cardio_tempo);
        Button button_confirmar_cardio = findViewById(R.id.button_confirmar_cardio);

        button_confirmar_cardio.setOnClickListener(v -> {

            String titulo = editText_titulo.getText().toString();
            String calorias = editText_calorias.getText().toString();
            String tempo = editText_tempo.getText().toString();

            if (!titulo.matches("") && !calorias.matches("") && !tempo.matches("")) {
                DatabaseHelper databaseHelper = new DatabaseHelper(this);
                boolean insert = databaseHelper.insertEstatistica(0, titulo, calorias, tempo);

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
