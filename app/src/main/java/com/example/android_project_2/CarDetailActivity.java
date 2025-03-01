package com.example.android_project_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class CarDetailActivity extends AppCompatActivity {

    private String carUrl; // Manufacturer's website URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        ImageView fullImageView = findViewById(R.id.fullImageView);

        // Get data from intent
        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("imageResId", 0);
        carUrl = intent.getStringExtra("carUrl");

        // Set full image
        fullImageView.setImageResource(imageResId);

        // Open website when clicking on full image
        fullImageView.setOnClickListener(v -> {
            if (carUrl != null && !carUrl.isEmpty()) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(carUrl));
                startActivity(browserIntent);
            }
        });
    }
}
