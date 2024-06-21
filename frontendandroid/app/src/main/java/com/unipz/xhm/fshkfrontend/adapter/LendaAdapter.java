package com.unipz.xhm.fshkfrontend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unipz.xhm.fshkfrontend.R;
import com.unipz.xhm.fshkfrontend.model.Lenda;
import com.unipz.xhm.fshkfrontend.model.Professor;

import java.util.List;

public class LendaAdapter extends RecyclerView.Adapter<LendaHolder> {
    private List<Lenda> lendaList;

    public LendaAdapter(List<Lenda> lendaList) {
        this.lendaList = lendaList;
    }

    @NonNull
    @Override
    public LendaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_lenda,parent,false);

        return new LendaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LendaHolder holder, int position) {
        Lenda lenda= lendaList.get(position);

        String lendaId= "19-03B06S-4O0";
        String semesterId= "Semester-";

        holder.lendaSalla.setText(String.valueOf(lenda.getProfessorNrZyre()));
        holder.lendaTitulli.setText(lenda.getLendaTitulli());
        holder.lendaLigjeruesi.setText(lenda.getProfessorEmri());
        holder.lendaId.setText(String.valueOf(lendaId+lenda.getLendaId()));
        holder.lendaKati.setText(String.valueOf(lenda.getProfessorKati()));
        holder.lendaKredi.setText(String.valueOf(lenda.getLendaKredi()));
        holder.lendaOraMbajtjes.setText(lenda.getLendaOraMbajtjes());
        holder.semesterId.setText(String.valueOf(semesterId+lenda.getSemesterId()));

    }

    @Override
    public int getItemCount() {
        return lendaList.size();
    }
}
