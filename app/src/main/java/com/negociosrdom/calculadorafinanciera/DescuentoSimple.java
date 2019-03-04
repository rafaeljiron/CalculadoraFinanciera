package com.negociosrdom.calculadorafinanciera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DescuentoSimple extends AppCompatActivity {

    private EditText txtDescuentoBancario;
    private EditText txtTasa;
    private EditText txtTiempo;
    private EditText txtMonto;
    private EditText txtValorLiquido;
    private Button btnCalcular;
    private int camposVacios;
    private Financiera objFinanciera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descuento_simple);

        txtDescuentoBancario = (EditText) findViewById(R.id.txtDescuentoBancario);
        txtTasa = (EditText) findViewById(R.id.txtTasaDescuentoBancario);
        txtTiempo = (EditText) findViewById(R.id.txtTiempoDescuentoBancario);
        txtMonto = (EditText) findViewById(R.id.txtMontoPrestamoDescuentoBancario);
        txtValorLiquido = (EditText) findViewById(R.id.txtValorLiquidoDescuentoBancario);
        btnCalcular = (Button) findViewById(R.id.btnCalcularDescuentoSimple);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular(){
        objFinanciera = new Financiera();

        if (txtDescuentoBancario.getText().toString().isEmpty()){
            objFinanciera.setDb(0);
        }else{
            objFinanciera.setDb(Double.valueOf(txtDescuentoBancario.getText().toString()));
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

        /*if(txtValorLiquido.getText().toString().isEmpty()){
            objFinanciera.setPd(0);
        }else{
            objFinanciera.setPd(Double.parseDouble(txtValorLiquido.getText().toString()));
        }*/

        camposVacios = 0;

        if (objFinanciera.getDb() == 0){
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

        /*if(objFinanciera.getPd() == 0){
            camposVacios += 1;
        }*/

        if (camposVacios == 1){

            if (objFinanciera.getDb() == 0){
                objFinanciera.calDescuentoBancario();
                txtDescuentoBancario.setText(String.valueOf(objFinanciera.getDb()));
            }

            //DESDE AQUI
            if (objFinanciera.getI() == 0){
                objFinanciera.calTasaDescuentoBancario();
                txtTasa.setText(String.valueOf(objFinanciera.getI()));
            }

            if (objFinanciera.getT() == 0){
                objFinanciera.calTiempoDescuentoBancario();
                txtTiempo.setText(String.valueOf(objFinanciera.getT()));
            }

            if (objFinanciera.getS() == 0){
                objFinanciera.calMontoDescuentoBancario();
                txtMonto.setText(String.valueOf(objFinanciera.getS()));
            }

           /* if(objFinanciera.getPd() == 0){
                objFinanciera.calValorLiquidoDescuentoBancario();
                txtValorLiquido.setText(String.valueOf(objFinanciera.getPd()));
            }*/
            //HASTA AQUI

        }else{
            Toast.makeText(this,"Debe dejar solo un campo vacio",Toast.LENGTH_SHORT).show();
        }
    }
}
