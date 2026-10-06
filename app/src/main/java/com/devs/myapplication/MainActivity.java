package com.devs.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEntrada;

    // Launcher para el Intent Explícito que espera un resultado (ConfigActivity)
    private final ActivityResultLauncher<Intent> configLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Toast.makeText(this, getString(R.string.msg_config_ok), Toast.LENGTH_SHORT).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEntrada = findViewById(R.id.etEntradaDato);
    }

    // ==========================================
    // 5 INTENTS IMPLÍCITOS
    // ==========================================
    public void abrirWeb(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.santotomas.cl")));
    }

    public void llamar(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+56228185731")));
    }

    public void abrirMapa(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-33.448,-70.669?q=Instituo+Profesional+Santo+Tomas")));
    }

    public void abrirAjustes(View view) {
        ejecutarIntent(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    public void enviarSMS(View view) {
        ejecutarIntent(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:007")));
    }

    // VALIDACIÓN GENERAL PARA INTENTS IMPLÍCITOS
    private void ejecutarIntent(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error_intent), Toast.LENGTH_SHORT).show();
        }
    }

    // ==========================================
    // 3 INTENTS EXPLÍCITOS
    // ==========================================

    // 1. Envía datos ingresados por el usuario
    public void irDetalle(View view) {
        String textoIngresado = etEntrada.getText().toString().trim();

        if (textoIngresado.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un dato en el cuadro de texto", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra("DATO_ENVIADO", textoIngresado);
        startActivity(intent);
    }

    // 2. Abre actividad esperando un resultado (ActivityResult)
    public void irConfig(View view) {
        configLauncher.launch(new Intent(this, ConfigActivity.class));
    }

    // 3. Abre actividad que ejecuta un Thread
    public void irThread(View view) {
        startActivity(new Intent(this, ThreadActivity.class));
    }
}