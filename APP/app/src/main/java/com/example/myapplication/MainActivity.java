package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextEmail = findViewById(R.id.editEmail);
        EditText editTextPassword = findViewById(R.id.editPassword);
        Button buttonEntrar = findViewById(R.id.buttonEntrar);

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

        buttonEntrar.setOnClickListener(v -> {
            int exists = databaseHelper.checkUserExist(editTextEmail.getText().toString(), editTextPassword.getText().toString());

            if (exists == 0) {
                Intent intent = new Intent(this, MenuPrincipalActivity.class);
                intent.putExtra("username", editTextEmail.getText().toString());
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Bem-vindo", Toast.LENGTH_SHORT).show();
            } else if (exists == 1) {
                Intent intent = new Intent(this, PTMenuPrincipalActivity.class);
                intent.putExtra("username", editTextEmail.getText().toString());
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Bem-vindo", Toast.LENGTH_SHORT).show();
            } else {
                editTextPassword.setText(null);
                Toast.makeText(MainActivity.this, "Login falhou. Email ou password inválidos.", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonFacebook = findViewById(R.id.buttonFacebook);
        Button buttonTwitter = findViewById(R.id.buttonTwitter);
        Button buttonGoogle = findViewById(R.id.buttonGoogle);

        buttonFacebook.setOnClickListener(v -> {
            Intent intent_buttonFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
            startActivity(intent_buttonFacebook);
        });

        buttonTwitter.setOnClickListener(v -> {
            Intent intent_buttonTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/"));
            startActivity(intent_buttonTwitter);
        });

        buttonGoogle.setOnClickListener(v -> {
            Intent intent_buttonGoogle = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
            startActivity(intent_buttonGoogle);
        });
    }
}
