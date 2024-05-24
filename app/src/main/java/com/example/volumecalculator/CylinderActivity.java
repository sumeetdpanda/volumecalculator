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

public class CylinderActivity extends AppCompatActivity {

    EditText cylinder_radius, cylinder_height;
    TextView cylinder_result;
    Button btn_cylinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cylinder_radius = findViewById(R.id.cylinder_radius);
        cylinder_height = findViewById(R.id.cylinder_height);
        cylinder_result = findViewById(R.id.cylinder_result);
        btn_cylinder = findViewById(R.id.btn_cylinder);

        btn_cylinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius, height;
                Double radiusDouble, heightDouble, volume;

                radius = cylinder_radius.getText().toString();
                if (radius.isEmpty()) {
                    Toast.makeText(CylinderActivity.this, "Please enter the radius of the Cylinder", Toast.LENGTH_SHORT).show();
                    return;
                }

                height = cylinder_height.getText().toString();
                if (height.isEmpty()) {
                    Toast.makeText(CylinderActivity.this, "Please enter the height of the Cylinder", Toast.LENGTH_SHORT).show();
                    return;
                }

                radiusDouble = Double.parseDouble(radius);
                heightDouble = Double.parseDouble(height);

                volume =  Math.PI * Math.pow(radiusDouble, 2) * heightDouble;

                cylinder_result.setText("Volume: " +(Math.floor(volume * 100) / 100) + " m\u00B3");
            }
        });
    }
}