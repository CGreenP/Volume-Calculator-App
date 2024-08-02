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

public class Cube extends AppCompatActivity {
    EditText cube_edge;
    TextView title, result;
    Button btn;
    private double volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cube_edge = findViewById(R.id.editText_cube);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edge = cube_edge.getText().toString();
                if (edge.isEmpty()) {
                    Toast.makeText(Cube.this, "Please give valid input!", Toast.LENGTH_SHORT).show();
                } else {
                    int e = Integer.parseInt(edge);

                    // V = e * e * e
                    volume = (e * e * e);
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