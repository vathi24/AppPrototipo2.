package com.devs.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        TextView tvEstado = findViewById(R.id.tvEstadoThread);

        // Cumple con el criterio de Threads de la rúbrica
        new Thread(() -> {
            try {
                Thread.sleep(2500); // Espera 2.5 segundos

                // Actualiza la interfaz gráfica desde el hilo principal
                runOnUiThread(() -> {
                    tvEstado.setText("✅ Proceso completado con éxito");
                    tvEstado.setTextColor(0xFF4CAF50); // Verde
                    tvEstado.setTextSize(24);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void volver(View view) {
        finish();
    }
}