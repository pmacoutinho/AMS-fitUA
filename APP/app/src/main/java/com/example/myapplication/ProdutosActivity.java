package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

public class ProdutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        ImageButton imgButton_back_arrow = findViewById(R.id.imgButton_back_arrow);

        imgButton_back_arrow.setOnClickListener(v -> {
            String pt = "0";
            if (getIntent().hasExtra("pt"))
                pt = getIntent().getStringExtra("pt");

            if (Integer.parseInt(pt) == 0) {
                Intent intent_back_arrow = new Intent(this, MenuPrincipalActivity.class);
                startActivity(intent_back_arrow);
            } else {
                Intent intent_back_arrow = new Intent(this, PTMenuPrincipalActivity.class);
                startActivity(intent_back_arrow);
            }
        });

        ImageButton imgButtom_prozis = findViewById(R.id.imgButton_prozis);
        ImageButton imgButton_my_protein = findViewById(R.id.imgButton_my_protein);

        imgButtom_prozis.setOnClickListener(v -> {
            Intent intent_prozis = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prozis.com/pt/pt"));
            startActivity(intent_prozis);
        });

        imgButton_my_protein.setOnClickListener(v -> {
            Intent intent_my_protein = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.myprotein.pt/"));
            startActivity(intent_my_protein);
        });
    }
}
