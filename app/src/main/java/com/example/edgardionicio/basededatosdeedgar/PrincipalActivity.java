package com.example.edgardionicio.basededatosdeedgar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class PrincipalActivity extends ActionBarActivity {

    EditText numero_de_control1, carrera1,semestre1,nombre1,apellidop1, apellidom1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        numero_de_control1 = (EditText) findViewById(R.id.numero_de_control);
        carrera1 = (EditText) findViewById(R.id.carrera);
        semestre1 = (EditText) findViewById(R.id.semestre);
        nombre1 = (EditText) findViewById(R.id.nombre);
        apellidop1 = (EditText) findViewById(R.id.apellidop);
        apellidom1 = (EditText) findViewById(R.id.apellidom);

    }
    public void agregar (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "estudiantes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String numero_de_control = numero_de_control1.getText().toString();
        String carrera = carrera1.getText().toString();
        String semestre = semestre1.getText().toString();
        String nombre = nombre1.getText().toString();
        String apellidop = apellidop1.getText().toString();
        String apellidom = apellidom1.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("id_numero_de_control", numero_de_control);
        registro.put("carrera", carrera);
        registro.put("semestre", semestre);
        registro.put("nombre", nombre);
        registro.put("apellido_p", apellidop);
        registro.put("apellido_m", apellidom);

        bd.insert("estudiantes", null, registro);
        bd.close();

        numero_de_control1.setText("");
        carrera1.setText("");
        semestre1.setText("");
        nombre1.setText("");
        apellidop1.setText("");
        apellidom1.setText("");

        Toast.makeText(this, "Se agrego un nuevo estudiantes", Toast.LENGTH_SHORT).show();

    }

    public void consulta(View v) {

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "estudiantes", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String numero_de_control = numero_de_control1.getText().toString();
            Cursor fila = bd.rawQuery("select carrera, semestre, nombre, apellido_p, apellido_m from estudiantes where id_numero_de_control=" + numero_de_control, null);
            if (fila.moveToFirst()) {
                carrera1.setText(fila.getString(0));
                semestre1.setText(fila.getString(1));
                nombre1.setText(fila.getString(2));
                apellidop1.setText(fila.getString(3));
                apellidom1.setText(fila.getString(4));
            } else {
                Toast.makeText(this, "No existe el estudiante", Toast.LENGTH_SHORT).show();
            }
            bd.close();
        }

    public void baja(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "estudiantes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String numero_de_control = numero_de_control1.getText().toString();
        int cant = bd.delete("estudiantes","id_numero_de_control=" + numero_de_control, null);
        bd.close();

        numero_de_control1.setText("");
        carrera1.setText("");
        semestre1.setText("");
        nombre1.setText("");
        apellidop1.setText("");
        apellidom1.setText("");

        if (cant == 1) {
            Toast.makeText(this, "Se borró el estudiante",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe el estudiante",Toast.LENGTH_SHORT).show();
        }
    }

    public void modificacion (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "estudiantes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String numero_de_control = numero_de_control1.getText().toString();
        String carrera = carrera1.getText().toString();
        String semestre = semestre1.getText().toString();
        String nombre = nombre1.getText().toString();
        String apellidop = apellidop1.getText().toString();
        String apellidom = apellidom1.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("id_numero_de_control", numero_de_control);
        registro.put("carrea", carrera);
        registro.put("semestre", semestre);
        registro.put("nombre", nombre);
        registro.put("apellido_p", apellidop);
        registro.put("apellido_m", apellidom);

        int cant = bd.update("estudiantes", registro, "id_numero_de_control=" + numero_de_control, null);
        bd.close();

        if (cant == 1) {
            Toast.makeText(this, "Se modificaron los datos del estudiante",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe el estudiante",Toast.LENGTH_SHORT).show();
        }

    }

    public void limpia (View v){
        numero_de_control1.setText("");
        carrera1.setText("");
        semestre1.setText("");
        nombre1.setText("");
        apellidop1.setText("");
        apellidom1.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
