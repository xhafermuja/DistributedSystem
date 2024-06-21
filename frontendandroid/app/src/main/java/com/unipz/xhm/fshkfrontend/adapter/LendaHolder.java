package com.unipz.xhm.fshkfrontend.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unipz.xhm.fshkfrontend.R;

public class LendaHolder extends RecyclerView.ViewHolder {

    TextView lendaId,lendaTitulli,lendaKredi,lendaOraMbajtjes,lendaLigjeruesi,lendaKati,lendaSalla, semesterId;

    public LendaHolder(@NonNull View itemView) {
        super(itemView);
        lendaId= itemView.findViewById(R.id.lenda_list_kursId);
        lendaTitulli= itemView.findViewById(R.id.lenda_list_kursTitulli);
        lendaKredi= itemView.findViewById(R.id.lenda_list_kredi);
        lendaOraMbajtjes= itemView.findViewById(R.id.lenda_list_oraMbajtjes);
        lendaLigjeruesi= itemView.findViewById(R.id.lenda_list_professor);
        lendaKati= itemView.findViewById(R.id.lenda_list_kati);
        lendaSalla= itemView.findViewById(R.id.lenda_list_nrZyre);
        semesterId= itemView.findViewById(R.id.lenda_list_semesterId);
    }
}
