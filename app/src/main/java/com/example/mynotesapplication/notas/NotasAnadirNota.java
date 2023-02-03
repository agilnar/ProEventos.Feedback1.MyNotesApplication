package com.example.mynotesapplication.notas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mynotesapplication.BaseActivity;
import com.example.mynotesapplication.R;

public class NotasAnadirNota extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);

        EditText editTextNewNoteTitle = findViewById(R.id.editTextNewNoteTitle);
        EditText editTextNewNoteBody = findViewById(R.id.editTextNewNoteBody);
        Button btnCreateNote = findViewById(R.id.btnCreateNote);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button atrass = findViewById(R.id.atrass);
        atrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotasAnadirNota.this, NotasActivity.class);
                startActivity(intent);
            }
        });

        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextNewNoteTitle.getText().toString();
                String body = editTextNewNoteBody.getText().toString();

                if (!title.isEmpty()) {
                    Intent intent = new Intent(NotasAnadirNota.this, NotasActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("body", body);
                    setResult(RESULT_OK, intent);
                    finish();
                } else
                    Toast.makeText(NotasAnadirNota.this, "Agrega un titulo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
