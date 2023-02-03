package com.example.mynotesapplication.notas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapplication.BaseActivity;
import com.example.mynotesapplication.LoginActivity;
import com.example.mynotesapplication.R;
import com.example.mynotesapplication.notas.modelo.Nota;
import com.example.mynotesapplication.utiles.Constantes;
import com.example.mynotesapplication.utiles.PrivacidadActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class NotasActivity extends BaseActivity {
    RecyclerView recycleViewNotes;
    ArrayList<Nota> noteList = new ArrayList<>();
    int REQUEST_CODE = 1;
    private final String SHARED_PREFERENCE_NAME = "sharedPreferenceListOfNotes";

    Button privacidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        setLogoutEvent();
        setNewNoteEvent();
        setRecycleViewData();

        privacidad=(Button) findViewById(R.id.privacidad);
        privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(NotasActivity.this, PrivacidadActivity.class);

                startActivity(intent0);
            }
        });
    }


    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("notes", null);
        Type type = new TypeToken<ArrayList<Nota>>() {
        }.getType();
        noteList = gson.fromJson(json, type);
        if (noteList == null)
            noteList = new ArrayList<>();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(noteList);
        editor.putString("notes", json);
        editor.apply();
        //Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo para manejar las notas
     */
    private void setRecycleViewData() {
        recycleViewNotes = findViewById(R.id.recycleViewNotes); //Componente Recycleview instanciado del layout

        this.loadData();

        //Adapter que se encarga de manejar la info del Recycleview
        NotasAdapter adapter = new NotasAdapter(noteList, NotasActivity.this);
        recycleViewNotes.setAdapter(adapter);

        //recycleViewNotes.setHasFixedSize(true); //Dice que los datos no cambiaran en runtime

        //Define como se dispone el recycleview segun la vista
        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotasActivity.this);
        recycleViewNotes.setLayoutManager(manager);
    }

    /**
     * Metodo para manejar el cierre de sesion mediante el boton
     */
    private void setLogoutEvent() {
        Button btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.setPref(Constantes.PREFS_USER, false);
                Intent intent = new Intent(NotasActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * Metodo para manejar el boton de Añadir Nota
     */
    private void setNewNoteEvent() {
        Button btnAddNote = findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("***************************************");
                Intent intent = new Intent(NotasActivity.this, NotasAnadirNota.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Nota newnota = new Nota(data.getStringExtra("title"), data.getStringExtra("body"));
        noteList.add(newnota);
        this.saveData();
        this.setRecycleViewData();
    }
}