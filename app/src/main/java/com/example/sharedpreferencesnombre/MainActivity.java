package com.example.sharedpreferencesnombre;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText textField;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField=(EditText)findViewById(R.id.etTextfield);
        btnConfirm=(Button)findViewById(R.id.btnConfirm);

        SharedPreferences preferences = this.getSharedPreferences("datos", Context.MODE_PRIVATE);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Login");
        builder.setMessage("Usuario previamente contectado: " + preferences.getString("nombre", "no tiene todavía nombre establecido"));
        AlertDialog dialog = builder.create();
        dialog.show();


    }

    public void ejecutar(View view){
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombre",textField.getText().toString());
        editor.commit();

        Toast.makeText(getApplicationContext(),"Nuevo nombre guardado.", Toast.LENGTH_LONG ).show();
        finish();




    }
}