package com.example.actividadprogramacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonIr = findViewById(R.id.botonIr);
        buttonIr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MapsActivity.class);

                EditText latitudDestinoInput = findViewById(R.id.inputDestinoLatitud);
                EditText longitudDestinoInput = findViewById(R.id.inputDestinoLongitud);

                if(!latitudDestinoInput.getText().toString().equals("") && !longitudDestinoInput.getText().toString().equals("")) {

                    Bundle extras = getIntent().getExtras();
                    if(extras != null){
                        intent.putExtra("LatitudOrigen", extras.getFloat("LatitudOrigen"));
                        intent.putExtra("LongitudOrigen", extras.getFloat("LongitudOrigen"));
                        intent.putExtra("LatitudDestino", latitudDestinoInput.getText().toString().equals("") ? 0:Float.parseFloat(latitudDestinoInput.getText().toString()));
                        intent.putExtra("LongitudDestino", longitudDestinoInput.getText().toString().equals("") ? 0:Float.parseFloat(longitudDestinoInput.getText().toString()));
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "No deberias estar aqui", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "No puede haber un campo vacio", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}