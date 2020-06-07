package com.example.actividadprogramacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.botonIr);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MapsActivity.class);

                EditText latitudInput = findViewById(R.id.inputLatitud);
                EditText longitudInput = findViewById(R.id.inputLongitud);

                System.out.println("latitud input!!!!!!!!");
                if(!latitudInput.getText().toString().equals("") || !longitudInput.getText().toString().equals("")) {
                    intent.putExtra("Latitud", latitudInput.getText().toString().equals("") ? 0:Float.parseFloat(latitudInput.getText().toString()));
                    intent.putExtra("Longitud", longitudInput.getText().toString().equals("") ? 0:Float.parseFloat(longitudInput.getText().toString()));
                }
                startActivity(intent);
            }

        });
    }
}