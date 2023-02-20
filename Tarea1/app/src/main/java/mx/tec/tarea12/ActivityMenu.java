package mx.tec.tarea12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    Button botoncito;
    Button botoncito2;
    Button botoncito3;
    TextView nombre;
    TextView otro;

    private static final int ACTIVITY_HOBBIE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        botoncito = findViewById(R.id.button);
        botoncito2 = findViewById(R.id.button3);
        botoncito3 = findViewById(R.id.button4);
        nombre = findViewById(R.id.textView);
        otro = findViewById(R.id.textView2);

        Intent intentito = getIntent();

        String nombreStr= "HOLA " + intentito.getStringExtra("nombre");

        nombre.setText(nombreStr);



    }

    public void actMensaje(View v){

        Toast.makeText(this, "BOTON PRESIONADO", Toast.LENGTH_SHORT).show();

        Intent intentito=new Intent(this, ActivityMensaje.class);
        startActivity(intentito);
    }

    public void actHobbie(View v){

        Toast.makeText(this, "BOTON PRESIONADO", Toast.LENGTH_SHORT).show();

        Intent intentito=new Intent(this, ActivityHobbie.class);
        startActivityForResult(intentito, ACTIVITY_HOBBIE);
    }

    public void actAmigos(View v){

        Toast.makeText(this, "BOTON PRESIONADO", Toast.LENGTH_SHORT).show();

        Intent intentito=new Intent(this, ActivityAmigos.class);
        startActivity(intentito);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY_HOBBIE && resultCode == Activity.RESULT_OK && data != null){
            String hobby= data.getStringExtra("hobbie");
            otro.setText(hobby);
        }

    }


}