package mx.tec.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityHobbie extends AppCompatActivity {

    EditText hobbie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbie);

        hobbie= findViewById(R.id.editTextH);
    }

    public void menu(View v){
        Intent intentito = new Intent();
        intentito.putExtra("hobbie", hobbie.getText().toString());
        setResult(Activity.RESULT_OK, intentito);
        finish();
    }

}