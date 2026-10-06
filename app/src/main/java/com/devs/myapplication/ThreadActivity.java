package com.devs.myapplication;

import android.os.Bundle;

import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThreadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        // Creación del Thread
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simula un proceso de 2 segundos
                runOnUiThread(() ->
                        Toast.makeText(this, getString(R.string.msg_hilo), Toast.LENGTH_LONG).show()
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}