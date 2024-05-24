package com.example.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CubeActivity extends AppCompatActivity {

    EditText cube_length;
    TextView cube_result;
    Button cube_btn;

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

        cube_length = findViewById(R.id.cube_length);
        cube_result = findViewById(R.id.cube_result);
        cube_btn = findViewById(R.id.cube_btn);

        cube_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length;
                Double length_double, volume;

                length = cube_length.getText().toString();
                if(length.isEmpty()){
                    Toast.makeText(CubeActivity.this, "Please enter the length of the cube", Toast.LENGTH_SHORT).show();
                    return;
                }

                length_double = Double.parseDouble(length);

                volume = Math.pow(length_double, 3);

                cube_result.setText("Volume: " +(Math.floor(volume * 100) / 100) + " m\u00B3");
            }
        });
    }
}