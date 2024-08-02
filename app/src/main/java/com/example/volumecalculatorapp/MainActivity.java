package com.example.volumecalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1- AdapterView: GridView
    GridView gridView;

    // 2- Data Source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;

    // 3- Adapter: MyCustomAdapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape s1= new Shape(R.drawable.sphere,"Sphere");
        Shape s2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape s3 = new Shape(R.drawable.cube, "Cube");
        Shape s4 = new Shape(R.drawable.prism, "Prism");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i = new Intent(getApplicationContext(), Sphere.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent j = new Intent(getApplicationContext(), Cylinder.class);
                        startActivity(j);
                        break;
                    case 2:
                        Intent k = new Intent(getApplicationContext(), Cube.class);
                        startActivity(k);
                        break;
                    case 3:
                        Intent l = new Intent(getApplicationContext(), Prism.class);
                        startActivity(l);
                        break;
                }
            }
        });

    }
}