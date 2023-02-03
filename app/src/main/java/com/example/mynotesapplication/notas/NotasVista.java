package com.example.mynotesapplication.notas;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapplication.R;

public class NotasVista extends RecyclerView.ViewHolder {

    LinearLayout linearLayoutContainer;
    TextView textViewNoteTitle, textViewNoteBody;

    public NotasVista(@NonNull View itemView) {
        super(itemView);

        linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);
        textViewNoteTitle = itemView.findViewById(R.id.textViewNoteTitle);
        textViewNoteBody = itemView.findViewById(R.id.textViewNoteBody);
    }
}