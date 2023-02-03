package com.example.mynotesapplication.notas.modelo;

import java.io.Serializable;

public class Nota implements Serializable {
    private String titulo, cuerpo;

    public Nota(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public String toString() {
        return "Note{" +
                "titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                '}';
    }
}
