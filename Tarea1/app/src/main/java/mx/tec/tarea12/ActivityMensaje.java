package mx.tec.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityMensaje extends AppCompatActivity {

    EditText mensaje;
    Button botoncito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        mensaje = findViewById(R.id.editTextMensaje);
        botoncito = findViewById(R.id.buttonEnviar);
    }

    public void interaccionMensaje(View v){
        Intent intentito=new Intent();

        Toast.makeText(this, "MENSAJE ENVIADO " + mensaje.getText(), Toast.LENGTH_SHORT).show();

        finish();
    }



}