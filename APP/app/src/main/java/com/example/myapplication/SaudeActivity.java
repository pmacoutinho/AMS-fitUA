package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class SaudeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intent_back_arrow);
        });

        Button button_abrir = findViewById(R.id.button_abrir);

        button_abrir.setOnClickListener(v -> {
            Intent intent_abrir = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bancodasaude.com/noticias/oito-erros-comuns-no-ginasio-que-podem-prejudicar-a-saude//"));
            startActivity(intent_abrir);
        });
    }
}
