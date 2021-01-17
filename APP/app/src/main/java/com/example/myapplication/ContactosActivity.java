package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class ContactosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

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
    }
}
