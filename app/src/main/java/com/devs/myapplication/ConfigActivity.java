package com.devs.myapplication;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    // Retorna RESULT_OK a la actividad principal
    public void guardarYVolver(View view) {
        setResult(RESULT_OK);
        finish();
    }
}