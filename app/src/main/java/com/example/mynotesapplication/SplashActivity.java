package com.example.mynotesapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.mynotesapplication.notas.NotasActivity;
import com.example.mynotesapplication.utiles.Constantes;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        runSlplash();
    }

    /**
     * Metodo que se encarga de ejecutar el Splash
     */
    private void runSlplash() {
        /**
         * Ejecucion de codigo asincrono
         */
        final Runnable splash = new Runnable() {
            @Override
            public void run() {
                boolean isUserLogged = prefs.getPref(Constantes.PREFS_USER); //Obtiene si el usuario esta logueado
                Intent intent = (isUserLogged) ? new Intent(SplashActivity.this, NotasActivity.class) : new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        /**
         * Elemento de timer
         */
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(splash); //Ejecuta en el hilo principal
            }
        };

        /**
         * Timer para correr el splash
         */
        Timer timer = new Timer();
        timer.schedule(timerTask, 500);
    }
}
