package com.negociosrdom.calculadorafinanciera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DescuentoRacional extends AppCompatActivity {

    private EditText txtDescuentoRacional;
    private EditText txtTasa;
    private EditText txtTiempo;
    private EditText txtMonto;
    private EditText txtValorLiquido;
    private Button btnCalcularDescuentoRacional;
    private int camposVacios;
    private Financiera objFinanciera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descuento_racional);

        txtDescuentoRacional= (EditText) findViewById(R.id.txtDescuentoRacional);
        txtTasa = (EditText) findViewById(R.id.txtTasaDr);
        txtTiempo = (EditText) findViewById(R.id.txtTiempoDr);
        txtMonto = (EditText) findViewById(R.id.txtMontoDr);
        txtValorLiquido = (EditText) findViewById(R.id.txtValorLiquidoDr);

        btnCalcularDescuentoRacional = (Button) findViewById(R.id.btnCalcularDescuentoRacional);

        btnCalcularDescuentoRacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular(){
        //Dr = (S*i*t) / (1+i*t)
        objFinanciera = new Financiera();

        if(txtDescuentoRacional.getText().toString().isEmpty()){
            objFinanciera.setDr(0);
        }else{
            objFinanciera.setDr(Double.parseDouble(txtDescuentoRacional.getText().toString()));
        }

        if(txtTasa.getText().toString().isEmpty()){
            objFinanciera.setI(0);
        }else{
            objFinanciera.setI(Double.parseDouble(txtTasa.getText().toString()));
        }

        if(txtTiempo.getText().toString().isEmpty()){
            objFinanciera.setT(0);
        }else{
            objFinanciera.setT(Double.parseDouble(txtTiempo.getText().toString()));
        }

        if(txtMonto.getText().toString().isEmpty()){
            objFinanciera.setS(0);
        }else{
            objFinanciera.setS(Double.parseDouble(txtMonto.getText().toString()));
        }

       /* if(txtValorLiquido.getText().toString().isEmpty()){
            objFinanciera.setPd(0);
        }else{
            objFinanciera.setPd(Double.parseDouble(txtValorLiquido.getText().toString()));
        }*/

        camposVacios = 0;

        if(objFinanciera.getDr() == 0){
            camposVacios += 1;
        }

        if (objFinanciera.getI() == 0){
            camposVacios += 1;
        }

        if (objFinanciera.getT() == 0){
            camposVacios += 1;
        }

        if (objFinanciera.getS() == 0){
            camposVacios += 1;
        }

       /* if(objFinanciera.getPd() == 0){
            camposVacios += 1;
        }*/

        if (camposVacios == 1){
            if(objFinanciera.getDr() == 0){
                objFinanciera.calDescuentoRacional();
                txtDescuentoRacional.setText(String.valueOf(objFinanciera.getDr()));
            }

            if (objFinanciera.getI() == 0){
                objFinanciera.calTasaDr();
                txtTasa.setText(String.valueOf(objFinanciera.getI()));
            }

            if (objFinanciera.getT() == 0){
                objFinanciera.calTiempoDr();
                txtTiempo.setText(String.valueOf(objFinanciera.getT()));
            }

            if (objFinanciera.getS() == 0){
                objFinanciera.calMontoDr();
                txtMonto.setText(String.valueOf(objFinanciera.getS()));
            }

           /* if(objFinanciera.getPd() == 0){
                objFinanciera.calValorLiquidoDr();
                txtValorLiquido.setText(String.valueOf(objFinanciera.getPd()));
            }*/
        }else{
            Toast.makeText(this,"Debe dejar solo un campo vacio",Toast.LENGTH_SHORT).show();
        }

    }
}
