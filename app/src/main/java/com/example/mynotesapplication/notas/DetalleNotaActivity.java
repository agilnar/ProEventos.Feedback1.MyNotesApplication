package com.example.mynotesapplication.notas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mynotesapplication.BaseActivity;
import com.example.mynotesapplication.R;
import com.example.mynotesapplication.utiles.Constantes;

public class DetalleNotaActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_nota);

        String noteTitle = getIntent().getStringExtra(Constantes.EXTRA_NOTE_TITLE);
        String noteBody = getIntent().getStringExtra(Constantes.EXTRA_NOTE_BODY);

        TextView textViewNoteTitle = findViewById(R.id.textViewNoteTitle);
        TextView textViewNoteBody = findViewById(R.id.textViewNoteBody);

        textViewNoteTitle.setText(noteTitle);
        textViewNoteBody.setText(noteBody);
    }
}
