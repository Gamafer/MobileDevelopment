package mx.tec.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivitySaludos extends AppCompatActivity {

    EditText saludos, saludos2;

    private static SharedPreferences prefs;
    private static final String KEY_SALUDOS ="saludos";
    private static final String KEY_SALUDOS2 ="saludos2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludos);

        saludos = findViewById(R.id.editTextTextPersonName);
        saludos2= findViewById(R.id.editTextTextPersonName2);

        prefs=getSharedPreferences("misSaludos", MODE_PRIVATE);

    }

    public void mandarMensaje(View v){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_SALUDOS, saludos.getText().toString());
        editor.putString(KEY_SALUDOS2, saludos2.getText().toString());
        editor.commit();
        finish();

    }


}