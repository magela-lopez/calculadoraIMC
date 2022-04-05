package com.mobileexercicio.imccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcularIMC = findViewById(R.id.btnCalcIMC);
        Button btnLimparDados = findViewById(R.id.button2);
        TextView lblResult = findViewById(R.id.txtNumIMC);
        TextView lblTextResult = findViewById(R.id.txtIMC);
        EditText txtPeso = findViewById(R.id.txtPesoKg);
        EditText txtAltura = findViewById(R.id.txtAltura);

        btnCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(txtPeso.getText().toString());
                double altura = Double.parseDouble(txtAltura.getText().toString());
                double imcResult = calcIMC(peso,altura);
                resultIMC(imcResult, lblResult,lblTextResult);
            }
        });

        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblResult.setText("");
                lblTextResult.setText("");
                txtAltura.setText("");
                txtPeso.setText("");
            }
        });

    }

    private double calcIMC(double peso, double altura){
        double result = peso/(altura*altura);
        return result;
    }

    private void resultIMC(double imc, TextView lblResult, TextView lblTextResult){


        if(imc<18.5){
            //Abaixo do Peso
            lblResult.setText("Seu IMC é: "+ imc);
            lblResult.setTextColor(getColorStateList(R.color.colorTextResultMin));
            lblTextResult.setText("Cuidado! Você está abaixo do peso normal");
        }else if(imc<=24.9){
            //Peso Normal
            lblResult.setText("Seu IMC é: "+ imc);
            lblResult.setTextColor(getColorStateList(R.color.colorTextResultIdeal));
            lblTextResult.setText("Você está no seu peso saudável. Continue Assim!");
        }else if(imc<=29.9){
            //Sobrepreso
            lblResult.setText("Seu IMC é: "+ imc);
            lblResult.setTextColor(getColorStateList(R.color.colorTextResultMin));
            lblTextResult.setText("Cuidado! Você está com sobrepeso (acima do peso desejado)");
        }else{
            //Obesidade
            lblResult.setText("Seu IMC é: "+ imc);
            lblResult.setTextColor(getColorStateList(R.color.colorTextResultMax));
            lblTextResult.setText("Você está com obesidade");
        }
    }
}