package com.negociosrdom.calculadorafinanciera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class interesSimple extends AppCompatActivity {
    private EditText txtCapital;
    private EditText txtInteres;
    private EditText txtTiempo;
    private EditText txtTasa;
    private Button btnCalcular;
    private int camposVacios;
    private double capital;
    private double interes;
    private double tiempo;
    private double tasa;
    private double monto;
    private Financiera objFinanciera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes_simple);

        txtCapital = (EditText) findViewById(R.id.txtCapital);
        txtInteres = (EditText) findViewById(R.id.txtInteres);
        txtTiempo = (EditText) findViewById(R.id.txtTiempo);
        txtTasa = (EditText) findViewById(R.id.txtTasa);
        btnCalcular = (Button) findViewById(R.id.btnCalcularInteresSimple);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

    }

    private void calcular(){

        if(txtCapital.getText().toString().isEmpty()){
            capital = 0;
        }else{
            capital = Double.parseDouble(txtCapital.getText().toString());
        }

        if(txtTasa.getText().toString().isEmpty()){
            tasa = 0;
        }else{
            tasa = Double.parseDouble(txtTasa.getText().toString());
        }

        if(txtInteres.getText().toString().isEmpty()){
            interes = 0;
        }else{
            interes = Double.parseDouble(txtInteres.getText().toString());
        }

        if(txtTiempo.getText().toString().isEmpty()){
            tiempo = 0;
        }else{
            tiempo = Double.parseDouble(txtTiempo.getText().toString());
        }

        camposVacios = 0;

        if(capital == 0){
            camposVacios = camposVacios+1;
        }

        if(tasa == 0){
            camposVacios = camposVacios+1;
        }

        if(tiempo == 0){
            camposVacios = camposVacios+1;
        }

        if(interes == 0){
            camposVacios = camposVacios+1;
        }

        if(camposVacios == 1){
            objFinanciera = new Financiera();
            objFinanciera.setI(tasa);
            objFinanciera.setP(capital);
            objFinanciera.setT(tiempo);
            objFinanciera.setInteres(interes);

            if(capital == 0){
                objFinanciera.calCapital();
                capital = objFinanciera.getP();
                txtCapital.setText(String.valueOf(capital));
            }

            if(tasa == 0){
                objFinanciera.calTasa();
                tasa = objFinanciera.getI();
                txtTasa.setText(String.valueOf(tasa));
            }

            if(tiempo == 0){
                objFinanciera.calTiempo();
                tiempo = objFinanciera.getT();
                txtTiempo.setText(String.valueOf(tiempo));
            }

            if(interes == 0){
                objFinanciera.calInteresSimple();
                interes = objFinanciera.getInteres();
                txtInteres.setText(String.valueOf(interes));
            }

        }else{
            Toast.makeText(this,"Debe dejar solo un campo vacio",Toast.LENGTH_SHORT).show();
        }
    }
}
