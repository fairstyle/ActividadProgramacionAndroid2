package com.example.actividadprogramacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDestino = findViewById(R.id.botonDestino);
        buttonDestino.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MainActivity2.class);

                EditText latitudOrigenInput = findViewById(R.id.inputOrigenLatitud);
                EditText longitudOrigenInput = findViewById(R.id.inputOrigenLongitud);

                if(!latitudOrigenInput.getText().toString().equals("") && !longitudOrigenInput.getText().toString().equals("")) {
                    intent.putExtra("LatitudOrigen", latitudOrigenInput.getText().toString().equals("") ? 0:Float.parseFloat(latitudOrigenInput.getText().toString()));
                    intent.putExtra("LongitudOrigen", longitudOrigenInput.getText().toString().equals("") ? 0:Float.parseFloat(longitudOrigenInput.getText().toString()));
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "No puede haber un campo vacio", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}