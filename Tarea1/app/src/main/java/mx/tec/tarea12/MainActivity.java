package mx.tec.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    Button botoncito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        botoncito = findViewById(R.id.button2);

    }

        public void interaccion1(View v){

            Toast.makeText(this, "BOTON PRESIONADO", Toast.LENGTH_SHORT).show();

            Intent intentito=new Intent(this, ActivityMenu.class);
            intentito.putExtra("nombre", nombre.getText().toString());
            startActivity(intentito);
        }


}