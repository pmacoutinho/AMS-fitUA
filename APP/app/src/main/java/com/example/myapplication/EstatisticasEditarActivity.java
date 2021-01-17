package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class EstatisticasEditarActivity extends AppCompatActivity {

    EditText editText_titulo_editar, editText_calorias_peso_editar, editText_tempo_editar;
    TextView text_kcalKg_editar;
    String id, tipoExercicio, titulo, calorias_peso, tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas_editar);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, EstatisticasDadosActivity.class);
            startActivity(intent_back_arrow);
        });

        editText_titulo_editar = findViewById(R.id.editText_titulo_editar);
        editText_calorias_peso_editar = findViewById(R.id.editText_calorias_peso_editar);
        editText_tempo_editar = findViewById(R.id.editText_tempo_editar);
        text_kcalKg_editar = findViewById(R.id.text_kcalKg_editar);
        //Button button_atualizar = findViewById(R.id.button_atualizar);
        Button button_eliminar = findViewById(R.id.button_eliminar);

        getAndSetIntentData();

        /* POSSIBLE FUTURE FEATURE -> UPDATE DATA
        button_atualizar.setOnClickListener(v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            int update = databaseHelper.updateEstatisticas(id, titulo, calorias_peso, tempo);

            if (update != -1) {
                Toast.makeText(this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent_update = new Intent(this, EstatisticasDadosActivity.class);
                startActivity(intent_update);
            } else
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }); */

        button_eliminar.setOnClickListener(v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            int delete = databaseHelper.deleteEstatisticas(id);

            if (delete > 0) {
                Toast.makeText(this, "Dados eliminados com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent_delete = new Intent(this, EstatisticasDadosActivity.class);
                startActivity(intent_delete);
            } else
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        });
    }

    @SuppressLint("SetTextI18n")
    void getAndSetIntentData(){
        if (getIntent().hasExtra("tipoExercicio") && getIntent().hasExtra("titulo")
                && getIntent().hasExtra("calorias_peso") && getIntent().hasExtra("tempo")){
            //Get
            id = getIntent().getStringExtra("id");
            tipoExercicio = getIntent().getStringExtra("tipoExercicio");
            titulo = getIntent().getStringExtra("titulo");
            calorias_peso = getIntent().getStringExtra("calorias_peso");
            tempo = getIntent().getStringExtra("tempo");

            //Set
            editText_titulo_editar.setText(titulo);
            editText_calorias_peso_editar.setText(calorias_peso);
            editText_tempo_editar.setText(tempo);
            if (Integer.parseInt(tipoExercicio) == 0)
                text_kcalKg_editar.setText("Kcal");
            else
                text_kcalKg_editar.setText("Kg");
        } else
            Toast.makeText(this, "Não existem dados", Toast.LENGTH_SHORT).show();
    }
}
