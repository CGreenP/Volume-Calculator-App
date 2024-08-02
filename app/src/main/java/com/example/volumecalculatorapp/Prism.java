package com.example.volumecalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prism extends AppCompatActivity {

    EditText prism_base_area, prism_height;
    TextView title, result;
    Button btn;
    private double volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        prism_base_area= findViewById(R.id.editText_prism_base_area);
        prism_height = findViewById(R.id.editText_prism_height);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String base_area = prism_base_area.getText().toString();
                String height = prism_height.getText().toString();
                if (base_area.isEmpty() || height.isEmpty()) {
                    Toast.makeText(Prism.this, "Please give valid input!", Toast.LENGTH_SHORT).show();
                } else {
                    int b = Integer.parseInt(base_area);
                    int h = Integer.parseInt(height);

                    // V = b * h
                    volume = (b * h);
                    result.setText("V = " + volume + " m^3");
                }
            }
        });

        if (savedInstanceState != null) {
            volume = savedInstanceState.getDouble("vol");
            result.setText("V = " + volume + " m^3");
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("vol",volume);
    }
}