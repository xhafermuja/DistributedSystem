package com.unipz.xhm.fshkfrontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unipz.xhm.fshkfrontend.model.Department;
import com.unipz.xhm.fshkfrontend.model.Lenda;
import com.unipz.xhm.fshkfrontend.model.Professor;
import com.unipz.xhm.fshkfrontend.retrofit.DepartmentAPI;
import com.unipz.xhm.fshkfrontend.retrofit.RetrofitService;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PanelDepartmentActivity extends AppCompatActivity {
    private final RetrofitService retrofitService= new RetrofitService();
    private final DepartmentAPI departmentAPI = retrofitService.getRetrofit().create(DepartmentAPI.class);
    private EditText depId,profForDep,lendaId,profForLend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Panel Department");

        initializeComponents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_admin, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.panelDepartamentet) {
            startActivity(new Intent(this, PanelDepartmentActivity.class));
            return true;
        } else if (id == R.id.panelLendet) {
            startActivity(new Intent(this, PanelLendetActivity.class));
            return true;
        }else if (id == R.id.panelStafi) {
            startActivity(new Intent(this, PanelStafiActivity.class));
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void initializeComponents() {
        depId= findViewById(R.id.departmentId);
        profForDep = findViewById(R.id.professorIdPD);
        lendaId = findViewById(R.id.lendaIdPL);
        profForLend = findViewById(R.id.professorIdPL);
    }


    public void assignDepProf(View view){
        String dep = String.valueOf(depId.getText());
        String prof = String.valueOf(profForDep.getText());

        departmentAPI.assignDepartment(Integer.parseInt(prof),Integer.parseInt(dep))
                .enqueue(new Callback<Professor>() {
                    @Override
                    public void onResponse(Call<Professor> call, Response<Professor> response) {
                        Toast.makeText(PanelDepartmentActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Professor> call, Throwable t) {
                        Toast.makeText(PanelDepartmentActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });
    }

    public void assignLendProf(View view){
        String lend = String.valueOf(lendaId.getText());
        String prof = String.valueOf(profForLend.getText());

        departmentAPI.assignProfessor(Integer.parseInt(lend),Integer.parseInt(prof))
                .enqueue(new Callback<Lenda>() {
                    @Override
                    public void onResponse(Call<Lenda> call, Response<Lenda> response) {
                        Toast.makeText(PanelDepartmentActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Lenda> call, Throwable t) {
                        Toast.makeText(PanelDepartmentActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });
    }
}
