package com.unipz.xhm.fshkfrontend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unipz.xhm.fshkfrontend.R;
import com.unipz.xhm.fshkfrontend.model.Lenda;
import com.unipz.xhm.fshkfrontend.model.Professor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorHolder>{

    private List<Professor> professorList;

    public ProfessorAdapter(List<Professor> professorList) {
        this.professorList = professorList;
    }

    @NonNull
    @Override
    public ProfessorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_stafi, parent, false);

        return new ProfessorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorHolder holder, int position) {
        Professor professor= professorList.get(position);


        holder.emriProf.setText(professor.getProfessorEmri());
        holder.emailProf.setText(professor.getProfessorEmail());
        holder.orariKonsProf.setText(professor.getProfessorOrariKonsultime());
        holder.lendetProfPermbajtja.setText(
                professor.getLendetLigj().stream()
                        .map(Lenda::getLendaTitulli) // Map each Lenda object to its lendaTitulli
                        .collect(Collectors.joining(", ")) // Join them with a comma and space
        );
        holder.katiProf.setText(String.valueOf("Kati:"+professor.getProfessorKati()));
        holder.nrZyreProf.setText(String.valueOf("NrZyre:"+professor.getProfessorNrZyre()));

        String photoProf = "prof" + professor.getProfessorId();
        int resourceId = holder.photoProf.getContext().getResources().getIdentifier(photoProf, "drawable", holder.photoProf.getContext().getPackageName());

        Glide.with(holder.photoProf.getContext())
                .load(resourceId)
                .placeholder(R.drawable.prof1)  // Replace with your actual placeholder drawable
                .circleCrop()
                .override(400,400)
                .into(holder.photoProf);
    }

    @Override
    public int getItemCount() {
        return professorList.size();
    }
}
