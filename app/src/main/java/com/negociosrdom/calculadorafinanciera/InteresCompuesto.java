package com.negociosrdom.calculadorafinanciera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InteresCompuesto extends AppCompatActivity {

    private EditText txtCapital;
    private EditText txtMontoCompuesto;
    private EditText txtInteresCompuesto;
    private EditText txtTasaNominal;
    private EditText txtFrecuenciaCapitazacion;
    private EditText txtInteresPorPeriodo;
    private EditText txtTiempo;
    private EditText txtPeriodos;
    private Button btnCalcularInteresCompuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes_compuesto);

        txtCapital = (EditText) findViewById(R.id.txtCapitalCompuesto);
        txtMontoCompuesto = (EditText)  findViewById(R.id.txtMontoCompuesto);
        txtInteresCompuesto = (EditText)  findViewById(R.id.txtInteresCompuesto);
        txtFrecuenciaCapitazacion = (EditText)  findViewById(R.id.txtFrecuenciaCapitazacion);
        txtInteresPorPeriodo = (EditText) findViewById(R.id.txtInteresPorPeriodo);
        txtTiempo = (EditText) findViewById(R.id.txtTiempoCompuesto);
        txtPeriodos = (EditText) findViewById(R.id.txtPeriodos);
        btnCalcularInteresCompuesto = (Button) findViewById(R.id.btnCalcularInteresCompuestos);

        btnCalcularInteresCompuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Prueba Correcta",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
