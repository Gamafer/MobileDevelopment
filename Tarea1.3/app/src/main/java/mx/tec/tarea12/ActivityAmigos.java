package mx.tec.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAmigos extends AppCompatActivity    {

    private EditText nombre, hobby;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        nombre =findViewById(R.id.editTextNombre);
        hobby = findViewById(R.id.editTextHobby);

        db = new DBHelper(this);

    }

    public void agregar(View v){

        db.guardar(nombre.getText().toString(), hobby.getText().toString());
        Toast.makeText(this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
    }

    public void buscar (View v){

        int idQuery= db.buscar(nombre.getText().toString());
        nombre.setText("" + idQuery);

    }

    public void borrar (View v){

        int afectados = db.borrar(nombre.getText().toString());
        Toast.makeText(this, afectados + " REGISTROS BORRADOS", Toast.LENGTH_SHORT).show();
    }

}