package com.unipz.xhm.fshkfrontend.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unipz.xhm.fshkfrontend.R;

public class DepartmentHolder extends RecyclerView.ViewHolder {

    TextView emri,pershkrimi;

    public DepartmentHolder(@NonNull View itemView) {
        super(itemView);
        emri=itemView.findViewById(R.id.department_list_emri);
        pershkrimi= itemView.findViewById(R.id.department_list_pershkrimi);
    }
}
