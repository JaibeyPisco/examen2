
package com.example.ejercicio2examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // definimos las variables 
    int precioBase = 10;

    Spinner spinner1;
    CheckBox papas, hotdog, tomate, queso, huevo, mayonesa, mostaza, ketchup;
    ArrayList<String> nResult;
    ArrayList<String> salsas;
    TextView muestrDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinnner
        spinner1 = findViewById(R.id.spinner);

        muestrDatos = findViewById(R.id.muestrDatos);
        //Complementos
        papas = findViewById(R.id.papas);
        hotdog = findViewById(R.id.hotdogs);
        tomate = findViewById(R.id.tomate);
        queso = findViewById(R.id.queso);
        huevo = findViewById(R.id.huevo);

        //Salsas
        mayonesa = findViewById(R.id.mayonesa);
        mostaza = findViewById(R.id.mostaza);
        ketchup = findViewById(R.id.ketchup);

        //Mostrar las hamburgesas en el spinner
        String[] hamburguesas = {"Chorizo Parrillero", "Ranchera", "Filete de pollo ", "Royal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hamburguesas);
        spinner1.setAdapter(adapter);


        nResult = new ArrayList<>();
        salsas = new ArrayList<>();

       // Selecionamos los complementos
        checkAdicionales(papas);
        checkAdicionales(hotdog);
        checkAdicionales(tomate);
        checkAdicionales(queso);
        checkAdicionales(huevo);

        //Selecionamos las salsas
        salsaSelecionada(mayonesa);
        salsaSelecionada(mostaza);
        salsaSelecionada(ketchup);


    }

    //Remueve o añado campos selecionados
    public void checkAdicionales(CheckBox dato) {
        dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dato.isChecked()) nResult.add(""+ (String) dato.getText());
                else nResult.remove((String) dato.getText());

            }
        });
    }
    public void salsaSelecionada(CheckBox dato) {
        dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dato.isChecked()) salsas.add((String) dato.getText());
                else salsas.remove((String) dato.getText());

            }
        });
    }



    //Boton comprar
    public void comprar(View view) {
        //Unir las listas para ser iteradas
       StringBuilder stringBuilder = new StringBuilder();

       //Combinar dos arreglos para poder interarlos
        ArrayList<String> combinar = new ArrayList<>();
        combinar.addAll(nResult);
        combinar.addAll(salsas);
        float precioHamburguesa = (nResult.size() * 5) + precioBase;

        stringBuilder.append("HAMBURGUESA: " + spinner1.getSelectedItem()).append("\n");
        stringBuilder.append("COMPLEMENTOS Y SALSA: ").append("\n");

        for (String complemento : combinar)
            stringBuilder.append(complemento).append("\n");
        stringBuilder.append("El precio de la hamburguesa es:" + precioHamburguesa);

        muestrDatos.setText(stringBuilder);
    }

}
