package com.example.volumecalculator;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
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

public class SphereActivity extends AppCompatActivity {

    EditText editText_sphere;
    TextView sphere_result;
    Button resultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText_sphere = findViewById(R.id.editText_sphere);
        sphere_result = findViewById(R.id.sphere_result);
        resultBtn = findViewById(R.id.btn1);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = editText_sphere.getText().toString();

                if (radius.isEmpty()){
                    Toast.makeText(SphereActivity.this, "Please enter the radius of the Sphere", Toast.LENGTH_SHORT).show();
                    return;
                }

                double radiusDouble = Double.parseDouble(radius);

                double volume = ((double) 4 /3) * Math.PI * Math.pow(radiusDouble, 3);


                sphere_result.setText("Volume: " +(Math.floor(volume * 100) / 100) + " m\u00B3");
            }
        });
    }
}