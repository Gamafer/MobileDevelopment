package mx.tec.tarea12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "FriendsDatabase.db";
    private static final String TABLE = "Amigos";
    private static final String FIELD_NOMBRE = "Nombre";
    private static final String FIELD_HOBBY = "Hobby";

    public DBHelper(Context context){

        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query= "CREATE TABLE " + TABLE + "(" + FIELD_NOMBRE + " TEXT, " + FIELD_HOBBY + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};

        db.execSQL(query, params);

        onCreate(db);
    }

    public void guardar(String nombre, String hobby){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(FIELD_NOMBRE, nombre);
        valores.put(FIELD_HOBBY, hobby);

        db.insert(TABLE, null, valores);
    }


    public int buscar(String nombre){

        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NOMBRE + " = ?";
        String[] params = {nombre};

        Cursor c = db.query(TABLE, null, clause, params, null, null, null);
        int resultado = -1;

        if(c.moveToFirst()){

            resultado = c.getInt(0);
        }


        return resultado;
    }

    public int borrar(String nombre){

        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NOMBRE + " = ?";
        String[] params = {nombre};


        return db.delete(TABLE, clause, params);
    }
}
