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

public class PrismActivity extends AppCompatActivity {

    EditText prism_base_area, prism_height;
    TextView prism_result;
    Button prism_btn;

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

        prism_base_area = findViewById(R.id.prism_base_area);
        prism_height = findViewById(R.id.prism_height);
        prism_result = findViewById(R.id.prism_result);
        prism_btn = findViewById(R.id.prism_btn);

        prism_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseArea, height;
                Double baseAreaDouble, heightDouble, volume;

                baseArea = prism_base_area.getText().toString();
                if(baseArea.isEmpty()){
                    Toast.makeText(PrismActivity.this, "Please enter the base area", Toast.LENGTH_SHORT).show();
                    return;
                }

                height = prism_height.getText().toString();
                if(height.isEmpty()){
                    Toast.makeText(PrismActivity.this, "Please enter the height", Toast.LENGTH_SHORT).show();
                    return;
                }

                baseAreaDouble = Double.parseDouble(baseArea);
                heightDouble = Double.parseDouble(height);

                volume = baseAreaDouble * heightDouble;

                prism_result.setText(("Volume: " +(Math.floor(volume * 100) / 100) + " m\u00B3"));
            }
        });
    }
}