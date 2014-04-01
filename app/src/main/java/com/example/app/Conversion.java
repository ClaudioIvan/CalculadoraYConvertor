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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Conversion extends ActionBarActivity {



    RadioGroup grpRadio;
    RadioButton centi;
    RadioButton fahre;
    Button convertidor;
    Button salir;
    EditText entrada;
    TextView salida;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);


        centi=(RadioButton)findViewById(R.id.radioButton);
        fahre=(RadioButton)findViewById(R.id.radioButton2);
        salir=(Button)findViewById(R.id.button2);
        convertidor=(Button)findViewById(R.id.button);
        entrada=(EditText)findViewById(R.id.editText);
        salida=(TextView)findViewById(R.id.textView2);



        convertidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(centi.isChecked()){
                    double dato1=Double.parseDouble(String.valueOf(entrada.getText()));
                    double resultado=dato1*(1.8)+32;
                    salida.setText("Resultado: "+resultado+" Fahrenheit");
                }

                if(fahre.isChecked()){
                    double dato1=Double.parseDouble(String.valueOf(entrada.getText()));
                    double resultado=(dato1-32)*(5/9);
                    salida.setText("Resultado: "+resultado+" Centigrados");
                }

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Regresar", Toast.LENGTH_SHORT).show();
                regresar();
            }
        });
    }



public void regresar(){

    Intent main1=new Intent(this, MainActivity.class);
    startActivityForResult(main1,0);

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.conversion, menu);
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
