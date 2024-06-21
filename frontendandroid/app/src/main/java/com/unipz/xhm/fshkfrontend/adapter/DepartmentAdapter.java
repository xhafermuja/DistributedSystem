package com.unipz.xhm.fshkfrontend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unipz.xhm.fshkfrontend.R;
import com.unipz.xhm.fshkfrontend.model.Department;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentHolder> {

    private final List<Department>departmentList;

    public DepartmentAdapter(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @NonNull
    @Override
    public DepartmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_department, parent, false);


        return new DepartmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentHolder holder, int position) {
        Department department= departmentList.get(position);
        holder.emri.setText(department.getDepartmentEmri());
        holder.pershkrimi.setText(department.getDepartmentPershkrimi());

    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }
}
