package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter_TreinoGinasio extends RecyclerView.Adapter<CustomAdapter_TreinoGinasio.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList id, casa, dificuldade, area, exercicios;

    CustomAdapter_TreinoGinasio(Activity activity, Context context, ArrayList id, ArrayList casa,
                             ArrayList dificuldade, ArrayList area, ArrayList exercicios) {
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.casa = casa;
        this.dificuldade = dificuldade;
        this.area = area;
        this.exercicios = exercicios;
    }

    @NonNull
    public CustomAdapter_TreinoGinasio.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_planos_treino, parent, false);
        return new CustomAdapter_TreinoGinasio.MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull final CustomAdapter_TreinoGinasio.MyViewHolder holder, final int position) {
        holder.textId.setText(String.valueOf(id.get(position)));
        if (Integer.parseInt(String.valueOf(casa.get(position))) == 0)
            holder.textCasa.setText("Não");
        else
            holder.textCasa.setText("Sim");
        holder.textArea.setText(String.valueOf(area.get(position)));
        holder.textDificuldade.setText(String.valueOf(dificuldade.get(position)));

        holder.mainLayoutPlanosTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TreinoNoGinasioActivity_2.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("casa", String.valueOf(casa.get(position)));
                intent.putExtra("area", String.valueOf(area.get(position)));
                intent.putExtra("dificuldade", String.valueOf(dificuldade.get(position)));
                intent.putExtra("exercicios", String.valueOf(exercicios.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    public int getItemCount() {
        return id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textId, textCasa, textDificuldade, textArea, textExercicios;
        LinearLayout mainLayoutPlanosTreino;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textId = itemView.findViewById(R.id.textId);
            textCasa = itemView.findViewById(R.id.text_casa);
            textDificuldade = itemView.findViewById(R.id.text_dificuldade);
            textArea = itemView.findViewById(R.id.text_area);
            mainLayoutPlanosTreino = itemView.findViewById(R.id.mainLayoutPlanosTreino);
        }
    }
}
