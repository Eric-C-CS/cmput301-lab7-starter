package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView cityText = findViewById(R.id.city_name_text);
        Button backButton = findViewById(R.id.back_button);

        // get city name
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("cityName");
        cityText.setText(cityName);

        // return button go back to MainActivity
        backButton.setOnClickListener(v -> finish());
    }
}
