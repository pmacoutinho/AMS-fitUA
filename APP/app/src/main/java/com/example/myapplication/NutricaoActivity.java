package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class NutricaoActivity extends AppCompatActivity {

    int dia = 100; // Posto a 100 para nunca causar conflitos
    int mes = 100;
    int ano = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricao);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intent_back_arrow);
        });

        CalendarView calendarView = findViewById(R.id.calendarView);
        Date dataHoje = Calendar.getInstance().getTime();
        String diaHoje = (String) DateFormat.format("dd", dataHoje);
        String mesHoje = (String) DateFormat.format("MM", dataHoje);
        String anoHoje = (String) DateFormat.format("yyyy", dataHoje);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            dia = dayOfMonth;
            mes = month + 1;
            ano = year;
        });

        Button button_confirmar = findViewById(R.id.button_confirmar);

        button_confirmar.setOnClickListener(v -> {
            if (dia > Integer.parseInt(diaHoje) && mes >= Integer.parseInt(mesHoje) && ano >= Integer.parseInt(anoHoje)) {
                Intent intent_confirmar = new Intent(this, NutricaoActivity_2.class);
                startActivity(intent_confirmar);
            } else
                Toast.makeText(this, "Data inválida, precisa de pelo menos um dia de antecedência", Toast.LENGTH_LONG).show();
        });
    }
}
