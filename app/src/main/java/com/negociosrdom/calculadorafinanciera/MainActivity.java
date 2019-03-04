package com.negociosrdom.calculadorafinanciera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnInteresSimple;
    private Button btnTiempos;
    private Button btnDescuentoSimple;
    private Button btnDescuentoRacional;
    private Button btnInteresCompuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInteresSimple = (Button) findViewById(R.id.btnInteresSimple);
        btnTiempos = (Button) findViewById(R.id.btnTiempos);
        btnDescuentoSimple = (Button) findViewById(R.id.btnDescuentoSimple);
        btnDescuentoRacional = (Button) findViewById(R.id.btnDescuentoRacional);
        btnInteresCompuesto = (Button) findViewById(R.id.btnInteresCompuesto);

        btnInteresSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(),interesSimple.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ha ocurrido un inconveniente",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnTiempos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(),TiempoExactoAproximado.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ha ocurrido un inconveniente",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDescuentoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(), DescuentoSimple.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ha ocurrido un inconveniente",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDescuentoRacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(), DescuentoRacional.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ha ocurrido un inconveniente",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnInteresCompuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(),InteresCompuesto.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ha ocurrido un inconveniente",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
