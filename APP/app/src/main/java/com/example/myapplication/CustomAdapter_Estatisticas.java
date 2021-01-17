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

public class CustomAdapter_Estatisticas extends RecyclerView.Adapter<CustomAdapter_Estatisticas.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList id, tipoExercicio, titulo, calorias_peso, tempo;

    CustomAdapter_Estatisticas(Activity activity, Context context, ArrayList id, ArrayList tipoExercicio, ArrayList titulo,
                               ArrayList calorias_peso, ArrayList tempo) {
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.tipoExercicio = tipoExercicio;
        this.titulo = titulo;
        this.calorias_peso = calorias_peso;
        this.tempo = tempo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_estatisticas, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if (Integer.parseInt(String.valueOf(tipoExercicio.get(position))) == 0) {
            holder.textTipoExercicio.setText("Cardio");
            holder.textCaloriasPesoMANUAL.setText("Calorias:");
            holder.textKcalKg.setText("Kcal");
        } else {
            holder.textTipoExercicio.setText("Pesos");
            holder.textCaloriasPesoMANUAL.setText("Peso Total:");
            holder.textKcalKg.setText("Kg");
        }
        holder.textTitulo.setText(String.valueOf(titulo.get(position)));
        holder.textCaloriasPeso.setText(String.valueOf(calorias_peso.get(position)));
        holder.textTempo.setText(String.valueOf(tempo.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EstatisticasEditarActivity.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("tipoExercicio", String.valueOf(tipoExercicio.get(position)));
                intent.putExtra("titulo", String.valueOf(titulo.get(position)));
                intent.putExtra("calorias_peso", String.valueOf(calorias_peso.get(position)));
                intent.putExtra("tempo", String.valueOf(tempo.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tipoExercicio.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textTipoExercicio, textTitulo, textCaloriasPeso, textTempo, textCaloriasPesoMANUAL, textKcalKg;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textTipoExercicio = itemView.findViewById(R.id.textTipoExercicio);
            textTitulo = itemView.findViewById(R.id.textTitulo);
            textCaloriasPeso = itemView.findViewById(R.id.textCaloriasPeso);
            textTempo = itemView.findViewById(R.id.textTempo);
            textCaloriasPesoMANUAL = itemView.findViewById(R.id.textCaloriasPesoMANUAL);
            textKcalKg = itemView.findViewById(R.id.textKcalKg);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
