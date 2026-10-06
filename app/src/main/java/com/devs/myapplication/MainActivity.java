package com.devs.myapplication;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // --- 5 INTENTS IMPLÍCITOS ---
    public void abrirWeb(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.santotomas.cl")));
    }

    public void llamar(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789")));
    }

    public void abrirMapa(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-33.448,-70.669?q=Santo+Tomas")));
    }

    public void abrirAjustes(View view) {
        ejecutarIntent(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    public void enviarSMS(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:123456789")));
    }

    // VALIDACIÓN: Evita que la app se cierre si falla el intent
    private void ejecutarIntent(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error_intent), Toast.LENGTH_SHORT).show();
        }
    }

    // --- 3 INTENTS EXPLÍCITOS ---
    public void irConfig(View view) {
        startActivity(new Intent(this, ConfigActivity.class));
    }

    public void irDetalle(View view) {
        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra("DATO_ENVIADO", getString(R.string.dato_enviado));
        startActivity(intent);
    }

    public void irThread(View view) {
        startActivity(new Intent(this, ThreadActivity.class));
    }
}