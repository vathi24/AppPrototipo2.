package com.devs.myapplication;

import android.os.Bundle;

import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        TextView tvDato = findViewById(R.id.tvDato);
        // Validar que el intent traiga datos
        if (getIntent() != null && getIntent().hasExtra("DATO_ENVIADO")) {
            String dato = getIntent().getStringExtra("DATO_ENVIADO");
            tvDato.setText(dato);
        }
    }
}