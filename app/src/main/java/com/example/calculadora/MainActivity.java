package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // variables
    Number IdN_1, IdN_2, total;
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // referenciar variables con su id
        EditText IdN_1 = findViewById(R.id.IdN_1);
        EditText IdN_2 = findViewById(R.id.IdN_2);
        EditText total = findViewById(R.id.total);


        Button button = findViewById(R.id.button);
        //button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);



        // detectar evento clic
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Number plus = IdN_1 + IdN_2;
                String num1 = IdN_1.getText().toString();
                String num2 = IdN_2.getText().toString();

                // si esta vacio
                if(num1.isEmpty() || num2.isEmpty()) {
                    // duracion toast=ventana emergente
                    Toast mytoast = Toast.makeText(getBaseContext(),
                            "Ingrese todos los valores",
                            Toast.LENGTH_LONG);
                    mytoast.show();
                }

                int resul = Integer.parseInt(num1) + Integer.parseInt(num2);
                total.setText("Resultado " + resul);
                IdN_1.setText("");
                IdN_2.setText("");



                //Toast.makeText(getBaseContext(), "Se ha presionado el boton Sumar", Toast.LENGTH_SHORT).show();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Se ha presionado el boton Restar", Toast.LENGTH_SHORT).show();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Se ha presionado el boton Multiplicar", Toast.LENGTH_SHORT).show();

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}