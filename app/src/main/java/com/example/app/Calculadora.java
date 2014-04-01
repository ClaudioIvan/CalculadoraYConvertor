package com.example.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends ActionBarActivity {


    Button sumar, restar, dividir, multiplicar,igual;
    Button boton,boton1,boton2,boton3,boton4,boton5,boton6, boton7,boton8,boton9, boton10;
    EditText salida;
    Button salir;
    boolean primerNum=true;
    double operan1=0,operan2=0,resultado=0;
    char operador='=';



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


         sumar=(Button)findViewById(R.id.sumar);
         restar=(Button)findViewById(R.id.restar);
         dividir=(Button)findViewById(R.id.dividir);
         multiplicar=(Button)findViewById(R.id.multiplicar);
         igual=(Button)findViewById(R.id.resultado);
         boton=(Button)findViewById(R.id.button);
         boton1=(Button)findViewById(R.id.button1);
         boton2=(Button)findViewById(R.id.button2);
         boton3=(Button)findViewById(R.id.button3);
         boton4=(Button)findViewById(R.id.button4);
         boton5=(Button)findViewById(R.id.button5);
         boton6=(Button)findViewById(R.id.button6);
         boton7=(Button)findViewById(R.id.button7);
         boton8=(Button)findViewById(R.id.button8);
         boton9=(Button)findViewById(R.id.button9);
         boton10=(Button)findViewById(R.id.button10);
         salida=(EditText)findViewById(R.id.editText);
         salir=(Button)findViewById(R.id.Salir);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("1");

            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("2");
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("3");
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("4");
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("5");
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("6");
            }
        });
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("7");
            }
        });
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("8");
            }
        });
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("9");
            }
        });
        boton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(primerNum==true){
                salida.setText(salida.getText()+".");
                primerNum=false;}
                else{
                agregarNume(".");
                }
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNume("0");
            }
        });


        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operan1 == 0){
                    operan1=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    operador='+';
                }

                else if(operan2==0){
                    operan2=Double.parseDouble(String.valueOf(salida.getText()));

                    calcular();
                    resultado=operan1;
                    salida.setText(""+resultado);
                    operan2=0;
                    operador='+';
                    primerNum=true;
                }

            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operan1 == 0){
                    operan1=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    operador='-';
                }

                else if(operan2==0){
                    operan2=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    calcular();
                    resultado=operan1;
                    salida.setText(""+resultado);

                    operan2=0;
                    operador='-';
                }


            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operan1 == 0){
                    operan1=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    operador='/';
                }

                else if(operan2==0){
                    operan2=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    calcular();
                    resultado=operan1;
                    salida.setText(""+resultado);

                    operan2=0;
                    operador='/';
                }
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operan1 == 0){
                    operan1=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    operador='*';
                }

                else if(operan2==0){
                    operan2=Double.parseDouble(String.valueOf(salida.getText()));
                    primerNum=true;
                    calcular();
                    resultado=operan1;
                    salida.setText(""+resultado);

                    operan2=0;
                    operador='*';
                }
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
                resultado=operan1;
                salida.setText(""+resultado);
                operan2=0;
                operador='=';
                primerNum=true;
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarMain();
            }
        });

    }

    public void cambiarMain(){

        Intent main1=new Intent(this, MainActivity.class);
        startActivityForResult(main1,0);
    }

    public void agregarNume(String numero){
        if(primerNum==true){
            primerNum=false;
            salida.setText(numero);
        }
        else{
            salida.setText(salida.getText()+numero);
        }
    }


    public void calcular(){

        switch (operador){

           case '+':
            operan2=Double.parseDouble(String.valueOf(salida.getText()));
            operan1=operan1+operan2;

               break;

            case '-':
                operan2=Double.parseDouble(String.valueOf(salida.getText()));
                operan1=operan1-operan2;
                break;

            case '*':
                operan2=Double.parseDouble(String.valueOf(salida.getText()));
                operan1=operan1*operan2;

                break;

            case '/':
                operan2=Double.parseDouble(String.valueOf(salida.getText()));
                operan1=operan1/operan2;
                break;


        }


        }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
