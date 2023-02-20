package mx.tec.tarea12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView saludos, saludos2;
    private static final int ACTIVITY_SALUDOS =0;
    private static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludos = findViewById(R.id.textView);
        saludos2= findViewById(R.id.textView2);

        prefs=getSharedPreferences("Saludos", MODE_PRIVATE);
    }

    public void abrirSaludos(View v){
        Intent intentito = new Intent(this, ActivitySaludos.class);
        startActivityForResult(intentito, ACTIVITY_SALUDOS);
    }

    public void abrirAmigos(View v){
        Intent intentito = new Intent(this, ActivityAmigos.class);
        startActivity(intentito);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY_SALUDOS && resultCode == Activity.RESULT_OK){
            saludos.setText(prefs.getString("saludo", "No hay saludo"));
            saludos2.setText(prefs.getString("saludo2", "No hay saludo2"));
        }

    }

}