package com.example.mynotesapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotesapplication.utiles.Preferencias;

public class BaseActivity extends AppCompatActivity {
    public Preferencias prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        prefs = new Preferencias(this);
    }
}