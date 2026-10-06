package com.devs.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        TextView tvDato = findViewById(R.id.tvDatoRecibido);

        // Validación de datos recibidos
        if (getIntent() != null && getIntent().hasExtra("DATO_ENVIADO")) {
            String dato = getIntent().getStringExtra("DATO_ENVIADO");
            tvDato.setText(dato);
        }
    }
    public void volver(View view) {
        finish();
    }
}