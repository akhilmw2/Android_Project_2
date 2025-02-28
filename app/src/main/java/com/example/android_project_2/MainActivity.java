package com.example.android_project_2;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Car> carList;
    private CarAdapter adapter;

    private void adjustGridColumns() {
        gridView.setNumColumns(3); // Always 3 columns
        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
    }

    private void adjustGridHeight() {
        gridView.post(() -> {
            ViewGroup.LayoutParams params = gridView.getLayoutParams();
            params.height = ViewGroup.LayoutParams.MATCH_PARENT; // Fix: Ensure it fills the screen
            gridView.setLayoutParams(params);
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);
        carList = new ArrayList<>();

        // Add car data (images must be in res/drawable)
        carList.add(new Car("Mazda 3", R.drawable.audi));
        carList.add(new Car("Honda Civic", R.drawable.bmw));
        carList.add(new Car("Toyota Corolla", R.drawable.ford));
        carList.add(new Car("BMW 3 Series", R.drawable.honda));
        carList.add(new Car("Audi A4", R.drawable.mazda));
        carList.add(new Car("Ford Mustang", R.drawable.mercedes));
        carList.add(new Car("Ford Mustang", R.drawable.nissan));
        carList.add(new Car("Ford Mustang", R.drawable.tesla));
        carList.add(new Car("Ford Mustang", R.drawable.toyota));

        adapter = new CarAdapter(this, carList);
        adjustGridHeight();
        gridView.setAdapter(adapter);
        adjustGridColumns();
    }
}