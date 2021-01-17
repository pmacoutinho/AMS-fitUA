package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ImageButton imgButton_planosTreino = findViewById(R.id.imgButton_planosTreino);
        ImageButton imgButton_falarPT = findViewById(R.id.imgButton_falarPT);
        ImageButton imgButton_estatisticas = findViewById(R.id.imgButton_estatisticas);
        ImageButton imgButton_treinoCasa = findViewById(R.id.imgButton_treinoCasa);
        ImageButton imgButton_treinoGinasio = findViewById(R.id.imgButton_treinoGinasio);
        ImageButton imgButton_produtos = findViewById(R.id.imgButton_produtos);
        ImageButton imgButton_saude = findViewById(R.id.imgButton_saude);
        ImageButton imgButton_nutricao = findViewById(R.id.imgButton_nutricao);
        ImageButton imgButton_contactos = findViewById(R.id.imgButton_contactos);
        Button button_logOut = findViewById(R.id.button_logOut);

        imgButton_planosTreino.setOnClickListener(v -> {
            Intent intent_planosTreino = new Intent(this, PlanosTreinoActivity.class);
            intent_planosTreino.putExtra("pt", "0");
            startActivity(intent_planosTreino);
        });

        imgButton_falarPT.setOnClickListener(v -> {
            Intent intent_falarPT = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.whatsapp.com/"));
            startActivity(intent_falarPT);
        });

        imgButton_estatisticas.setOnClickListener(v -> {
            Intent intent_estatisticas = new Intent(this, EstatisticasActivity.class);
            startActivity(intent_estatisticas);
        });

        imgButton_treinoCasa.setOnClickListener(v -> {
            Intent intent_treinoCasa = new Intent(this, TreinoEmCasaActivity.class);
            startActivity(intent_treinoCasa);
        });

        imgButton_treinoGinasio.setOnClickListener(v -> {
            Intent intent_treinoGinasio = new Intent(this, TreinoNoGinasioActivity.class);
            startActivity(intent_treinoGinasio);
        });

        imgButton_produtos.setOnClickListener(v -> {
            Intent intent_produtos = new Intent(this, ProdutosActivity.class);
            intent_produtos.putExtra("pt", "0");
            startActivity(intent_produtos);
        });

        imgButton_saude.setOnClickListener(v -> {
            Intent intent_saude = new Intent(this, SaudeActivity.class);
            startActivity(intent_saude);
        });

        imgButton_nutricao.setOnClickListener(v -> {
            Intent intent_nutricao = new Intent(this, NutricaoActivity.class);
            startActivity(intent_nutricao);
        });

        imgButton_contactos.setOnClickListener(v -> {
            Intent intent_contactos = new Intent(this, ContactosActivity.class);
            intent_contactos.putExtra("pt", "0");
            startActivity(intent_contactos);
        });

        button_logOut.setOnClickListener(v -> {
            Intent intent_logOut = new Intent(this, MainActivity.class);
            startActivity(intent_logOut);
        });
    }
}
