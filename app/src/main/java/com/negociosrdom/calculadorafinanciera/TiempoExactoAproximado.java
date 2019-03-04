package com.negociosrdom.calculadorafinanciera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TiempoExactoAproximado extends AppCompatActivity {

    private EditText txtYearFecha1;
    private EditText txtMesFecha1;
    private EditText txtDiaFecha1;
    private EditText txtYearFecha2;
    private EditText txtMesFecha2;
    private EditText txtDiaFecha2;
    private TextView txtResultado;
    private int camposVacios;
    private Button btnCalcular;
    private Financiera objFinanciera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo_exacto_aproximado);

        txtYearFecha1 = (EditText) findViewById(R.id.txtDiaFecha1);
        txtMesFecha1 = (EditText) findViewById(R.id.txtMesFecha1);
        txtDiaFecha1 = (EditText) findViewById(R.id.txtDiaFecha1);

        txtYearFecha2 = (EditText) findViewById(R.id.txtYearFecha2);
        txtMesFecha2 = (EditText) findViewById(R.id.txtMesFecha2);
        txtDiaFecha2 = (EditText) findViewById(R.id.txtDiaFecha2);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btnCalcular = (Button) findViewById(R.id.btnCalcularTiempos);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });


    }

    private void calcular(){
        camposVacios = 0;

        if(txtYearFecha1.getText().toString().isEmpty()){camposVacios += 1;}
        if (txtMesFecha1.getText().toString().isEmpty()) {camposVacios +=1; }
        if (txtDiaFecha1.getText().toString().isEmpty()) {camposVacios +=1; }

        if (txtYearFecha2.getText().toString().isEmpty()) {camposVacios +=1; }
        if (txtMesFecha2.getText().toString().isEmpty()) {camposVacios +=1; }
        if (txtDiaFecha2.getText().toString().isEmpty()) {camposVacios +=1; }

        if(camposVacios > 0){
            Toast.makeText(this,"NO PUEDE DEJAR CAMPOS VACIOS",
                    Toast.LENGTH_SHORT).show();
        }else{
            objFinanciera = new Financiera();

            objFinanciera.setYearFecha1(Integer.parseInt(txtYearFecha1.getText().toString()));
            objFinanciera.setMesFecha1(Integer.parseInt(txtMesFecha1.getText().toString()));
            objFinanciera.setDiaFecha1(Integer.parseInt(txtDiaFecha1.getText().toString()));

            objFinanciera.setYearFecha2(Integer.parseInt(txtYearFecha2.getText().toString()));
            objFinanciera.setMesFecha2(Integer.parseInt(txtDiaFecha2.getText().toString()));
            objFinanciera.setDiaFecha2(Integer.parseInt(txtDiaFecha2.getText().toString()));
            objFinanciera.calcularFecha();

            txtResultado.setText("Los dias son: " + objFinanciera.getDias());
        }
    }
}
