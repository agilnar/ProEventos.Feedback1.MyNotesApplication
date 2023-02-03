package com.example.mynotesapplication.notas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapplication.notas.modelo.Nota;
import com.example.mynotesapplication.R;
import com.example.mynotesapplication.utiles.Constantes;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasVista> {
    ArrayList<Nota> noteList;
    Context context;

    public NotasAdapter(ArrayList<Nota> noteList, Context context) {
        this.noteList = noteList;
        this.context = context;
    }

    @NonNull
    @Override
    public NotasVista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Definimos como se crea la vista (viewholder)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new NotasVista(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasVista holder, int position) {
        //Define lo que pasa en el momento que ya se cargo la vista
        holder.textViewNoteTitle.setText(noteList.get(position).getTitulo());
        holder.textViewNoteBody.setText(noteList.get(position).getCuerpo());

        //Manejamos el evento de click
        holder.linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetalleNotaActivity.class);
                intent.putExtra(Constantes.EXTRA_NOTE_TITLE, noteList.get(position).getTitulo());
                intent.putExtra(Constantes.EXTRA_NOTE_BODY, noteList.get(position).getCuerpo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
