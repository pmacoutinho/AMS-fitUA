package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class PTMenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt_menu_principal);

        ImageButton imgButton_planosTreinoPT = findViewById(R.id.imgButton_planosTreinoPT);
        ImageButton imgButton_falarCliente = findViewById(R.id.imgButton_falarCliente);
        ImageButton imgButton_treinoCasaPT = findViewById(R.id.imgButton_treinoCasaPT);
        ImageButton imgButton_produtosPT = findViewById(R.id.imgButton_produtosPT);
        ImageButton imgButton_contactosPT = findViewById(R.id.imgButton_contactosPT);
        Button button_logOutPT = findViewById(R.id.button_logOutPT);

        imgButton_planosTreinoPT.setOnClickListener(v -> {
            Intent intent_planosTreino = new Intent(this, PlanosTreinoActivity.class);
            intent_planosTreino.putExtra("pt", "1");
            startActivity(intent_planosTreino);
        });

        imgButton_falarCliente.setOnClickListener(v -> {
            Intent intent_falarPT = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.whatsapp.com/"));
            startActivity(intent_falarPT);
        });

        imgButton_treinoCasaPT.setOnClickListener(v -> {
            Intent intent_treinoCasaPT = new Intent(Intent.ACTION_VIEW, Uri.parse("https://zoom.us/pt-pt/meetings.html"));
            startActivity(intent_treinoCasaPT);
        });

        imgButton_produtosPT.setOnClickListener(v -> {
            Intent intent_produtos = new Intent(this, ProdutosActivity.class);
            intent_produtos.putExtra("pt", "1");
            startActivity(intent_produtos);
        });

        imgButton_contactosPT.setOnClickListener(v -> {
            Intent intent_contactos = new Intent(this, ContactosActivity.class);
            intent_contactos.putExtra("pt", "1");
            startActivity(intent_contactos);
        });

        button_logOutPT.setOnClickListener(v -> {
            Intent intent_logOut = new Intent(this, MainActivity.class);
            startActivity(intent_logOut);
        });
    }
}
