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
import android.widget.EditText;
import android.widget.Toast;

import com.unipz.xhm.fshkfrontend.model.Professor;
import com.unipz.xhm.fshkfrontend.retrofit.RetrofitService;
import com.unipz.xhm.fshkfrontend.retrofit.StafiAPI;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PanelStafiActivity extends AppCompatActivity {

    private final RetrofitService retrofitService= new RetrofitService();
    private final StafiAPI stafiAPI= retrofitService.getRetrofit().create(StafiAPI.class);
    private EditText emriProf,emailProf, nrZyreProf, orariKonsProf, katiProf, idProf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_stafi);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Panel Stafi");

        intializeComponents();
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

    private void intializeComponents(){
        idProf= findViewById(R.id.professorId);
        emriProf= findViewById(R.id.professorEmri);
        emailProf= findViewById(R.id.professorEmal);
        nrZyreProf= findViewById(R.id.professorNrZyre);
        orariKonsProf= findViewById(R.id.professorOrariKonsultime);
        katiProf= findViewById(R.id.professorKati);
    }

    public void addStaff(View view){
        String emri= String.valueOf(emriProf.getText());
        String email= String.valueOf(emailProf.getText());
        String nrZyre= String.valueOf(nrZyreProf.getText());
        String orari= String.valueOf(orariKonsProf.getText());
        String kati= String.valueOf(katiProf.getText());

        Professor professor= new Professor();

        professor.setProfessorEmri(emri);
        professor.setProfessorEmail(email);
        professor.setProfessorNrZyre(Integer.parseInt(nrZyre));
        professor.setProfessorOrariKonsultime(orari);
        professor.setProfessorKati(Integer.parseInt(kati));

        stafiAPI.saveProfessor(professor)
                .enqueue(new Callback<Professor>() {
                    @Override
                    public void onResponse(Call<Professor> call, Response<Professor> response) {
                        Toast.makeText(PanelStafiActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Professor> call, Throwable t) {
                        Toast.makeText(PanelStafiActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });
    }

    public void updateStaff(View view){
        String id= String.valueOf(idProf.getText());
        String emri= String.valueOf(emriProf.getText());
        String email= String.valueOf(emailProf.getText());
        String nrZyre= String.valueOf(nrZyreProf.getText());
        String orari= String.valueOf(orariKonsProf.getText());
        String kati= String.valueOf(katiProf.getText());

        Professor professor= new Professor();

        professor.setProfessorEmri(emri);
        professor.setProfessorEmail(email);
        professor.setProfessorNrZyre(Integer.parseInt(nrZyre));
        professor.setProfessorOrariKonsultime(orari);
        professor.setProfessorKati(Integer.parseInt(kati));

        stafiAPI.updateProfessor(Integer.parseInt(id),professor)
                .enqueue(new Callback<Professor>() {
                    @Override
                    public void onResponse(Call<Professor> call, Response<Professor> response) {
                        Toast.makeText(PanelStafiActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Professor> call, Throwable t) {
                        Toast.makeText(PanelStafiActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });
    }

    public void deleteStaff(View view){
        String id= String.valueOf(idProf.getText());

        stafiAPI.deleteProfessor(Integer.parseInt(id))
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(PanelStafiActivity.this, "Delete successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(PanelStafiActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });

    }

}