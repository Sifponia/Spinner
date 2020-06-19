package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1)-Parte logica, encapsular y declarara el tipo de dato de android
    private EditText valor1, valor2;
    private Spinner spinner1;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2)-Crear la parte grafica y asignarlo en los objectos anteriormente creados
        valor1 = (EditText)findViewById(R.id.etNumero1);
        valor2=(EditText)findViewById(R.id.etNumero2);
        tvResultado = (TextView)findViewById(R.id.twResultado);
        spinner1 =(Spinner)findViewById(R.id.Spinner);


        //3)-Crear una array que añadiremos en el spinner
        String operaciones []= {"Sumar","Restar","Multiplicar","Dividir"};

        //4)-Crear un object de tipo ArrayAdapter
        ArrayAdapter<String>adaptador = new ArrayAdapter<>(this, R.layout.spinner_item, operaciones);
        //enviar object con el metodo setAdapter
        spinner1.setAdapter(adaptador);
    }

    //5)-Metodo del botton
    public void operacionesArit(View view){
     String srtValor1 = valor1.getText().toString();
     String srtValor2 = valor2.getText().toString();

     float floValor1 = Float.parseFloat(srtValor1);
     float floValo2 = Float.parseFloat(srtValor2);

     String seleccionar = spinner1.getSelectedItem().toString();

     //Condicion Sumar
     if(seleccionar.equals("Sumar")){
         float floSumar = floValor1+floValo2;
        String srtResultado = String.valueOf(floSumar);
         tvResultado.setText("El resultado es " + srtResultado);

     }
        //Condicion Restar
       else if(seleccionar.equals("Restar")){
            float floRestar = floValor1-floValo2;
            String srtResul = String.valueOf(floRestar);
            tvResultado.setText("El resultado es " + floRestar);

        }

        //Condicion Multiplicar
       else if(seleccionar.equals("Multiplicar")){
            float floMulti = floValor1*floValo2;
            tvResultado.setText("El resultado es " + floMulti);

        }

        //Condicion Dividir
       else if(seleccionar.equals("Dividir")){
            float floDividir = floValor1/floValo2;
            String srtResul = String.valueOf(floDividir);
            tvResultado.setText("El resultado es " + srtResul);

        }


    }


}