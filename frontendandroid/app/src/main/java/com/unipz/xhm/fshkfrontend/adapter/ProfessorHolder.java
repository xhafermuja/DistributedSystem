package com.unipz.xhm.fshkfrontend.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unipz.xhm.fshkfrontend.R;

public class ProfessorHolder extends RecyclerView.ViewHolder {

    ImageView photoProf;
    TextView emriProf,emailProf,nrZyreProf,katiProf,orariKonsProf,lendetProfPermbajtja;

    public ProfessorHolder(@NonNull View itemView) {
        super(itemView);
        emriProf= itemView.findViewById(R.id.stafi_list_emriProf);
        emailProf= itemView.findViewById(R.id.stafi_list_emailProf);
        nrZyreProf= itemView.findViewById(R.id.stafi_list_nrZyreProf);
        katiProf= itemView.findViewById(R.id.stafi_list_katiProf);
        orariKonsProf= itemView.findViewById(R.id.stafi_list_orariKonsProf);
        lendetProfPermbajtja= itemView.findViewById(R.id.stafi_list_lendetPermb);
        photoProf= itemView.findViewById(R.id.stafi_list_photoProf);
//
//        photoProf.setImageResource(R.drawable.unipz);
    }
}
