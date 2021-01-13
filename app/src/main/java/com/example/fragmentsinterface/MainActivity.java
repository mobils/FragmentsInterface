package com.example.fragmentsinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragment1Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.botoActivity1);

        // TODO: el botó del activity inflarà el fragment1
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();  //IMPORTANT Sempre getSupportFragmentManager

                if (fm.findFragmentById(R.id.contenidor1) == null) { //comprova si hi ha un fragment
                    Fragment1 fragment1 = new Fragment1();
                    fm.beginTransaction().replace(R.id.contenidor1, fragment1).commit(); //.add si no hi ha res
                    // o .replace si vol substituir o afegir
                }

            }
        });
    }

    @Override
    public void onFragment1Click() {
        //Aquí arribarem quan el botó del fragment es clica
        //TODO: Mostrar toast
        Toast.makeText(this,"Ha clicat al fragment1", Toast.LENGTH_SHORT).show();

        //TODO: Inflar fragment2
    }


}