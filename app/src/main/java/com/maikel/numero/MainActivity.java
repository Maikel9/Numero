package com.maikel.numero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numero;
    TextView binario, octal, hexadecimal;
    Button calcular, limpiar, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.editTextDate);
        binario = findViewById(R.id.textBinario);
        octal = findViewById(R.id.textOctal);
        hexadecimal = findViewById(R.id.texthexadecimal);
        calcular = findViewById(R.id.button);
        limpiar = findViewById(R.id.btnlimpiar);
        salir = findViewById(R.id.btnSalir);
    }
    public void metodo(View view){
        //Binario
        String num = numero.getText().toString();
        int input = Integer.parseInt(num);
        int digito;
        String bina="";
        do {
            digito = input %2;
            bina += digito;
            input = input/2;
        } while (input !=0);
        bina = new StringBuilder(bina).reverse().toString();
        binario.setText("Binario: "+bina);

        //Octal
        String num2 = numero.getText().toString();
        int input2 = Integer.parseInt(num2);
        int residuo;
        String octa="";
        char[] caracteresOctales = {'0', '1', '2', '3', '4', '5', '6', '7',};
        do {
            residuo = input2 %8;
            char caracter = caracteresOctales[residuo];
            octa = caracter + octa;
            input2 = input2 /8;
        } while (input2 !=0);
        octal.setText("Octal: "+octa);

        //Hexadecimal
        String num3 = numero.getText().toString();
        int input3 = Integer.parseInt(num3);
        int residuoh;
        String hexa="";
        char[] caracteresHexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        do {
            residuoh = input3 %16;
            char caracterh = caracteresHexadecimales[residuoh];
            hexa = caracterh + hexa;
            input3 = input3 /16;
        } while (input3 !=0);
        hexadecimal.setText("Hexadecimal: "+hexa);

    }
    public void limpiartext(View view){
        Toast.makeText(this, "Se limpio la pantalla", Toast.LENGTH_SHORT).show();
        numero.setText("");
        binario.setText("Binario");
        octal.setText("Octal");
        hexadecimal.setText("Hexadecimal");
    }
    public void salirApp(View view){
        Toast.makeText(this, "Haz salido de la app", Toast.LENGTH_SHORT).show();
        finishAffinity();
    }

}