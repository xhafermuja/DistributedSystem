package com.unipz.xhm.fshkfrontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.unipz.xhm.fshkfrontend.adapter.DepartmentAdapter;
import com.unipz.xhm.fshkfrontend.adapter.ProfessorAdapter;
import com.unipz.xhm.fshkfrontend.model.Department;
import com.unipz.xhm.fshkfrontend.model.Professor;
import com.unipz.xhm.fshkfrontend.retrofit.DepartmentAPI;
import com.unipz.xhm.fshkfrontend.retrofit.RetrofitService;
import com.unipz.xhm.fshkfrontend.retrofit.StafiAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentActivity extends AppCompatActivity {
    private RecyclerView recyclerViewDepartment, recyclerViewStafi;
    private final RetrofitService retrofitService= new RetrofitService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Departamentet");

        recyclerViewDepartment= findViewById(R.id.departmentList_recyclerView);
        recyclerViewDepartment.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewStafi= findViewById(R.id.stafiList_recyclerView);
        recyclerViewStafi.setLayoutManager(new LinearLayoutManager(this));

        loadDepartments();
        loadStafi();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_student, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.departamentet) {
            startActivity(new Intent(this,DepartmentActivity.class));
            return true;
        } else if (id == R.id.lendet) {
            startActivity(new Intent(this,LendActivity.class));
            return true;
        } else if (id == R.id.evente) {
            startActivity(new Intent(this,EventActivity.class));
            return true;
        } else if (id == R.id.kontakt) {
            startActivity(new Intent(this,KontaktActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadDepartments(){
        DepartmentAPI departmentAPI= retrofitService.getRetrofit().create(DepartmentAPI.class);
        departmentAPI.getAllDepartments()
                .enqueue(new Callback<List<Department>>() {
                    @Override
                    public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                        populateListViewDepartment(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Department>> call, Throwable t) {
                        Toast.makeText(DepartmentActivity.this, "Failed to Load Departments", Toast.LENGTH_LONG).show();
                    }
                });


    }

    private void loadStafi(){
        StafiAPI stafiAPI= retrofitService.getRetrofit().create(StafiAPI.class);
        stafiAPI.getAllProfessor()
                .enqueue(new Callback<List<Professor>>() {
                    @Override
                    public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                        populateListViewStafi(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Professor>> call, Throwable t) {
                        Toast.makeText(DepartmentActivity.this, "Failed to Load Professors", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void populateListViewDepartment(List<Department> departmentList){
        DepartmentAdapter departmentAdapter= new DepartmentAdapter(departmentList);
        recyclerViewDepartment.setAdapter(departmentAdapter);

    }

    private void populateListViewStafi(List<Professor> professorList){
        ProfessorAdapter professorAdapter= new ProfessorAdapter(professorList);
        recyclerViewStafi.setAdapter(professorAdapter);
    }
}