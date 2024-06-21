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

import com.unipz.xhm.fshkfrontend.adapter.LendaAdapter;
import com.unipz.xhm.fshkfrontend.model.Lenda;
import com.unipz.xhm.fshkfrontend.retrofit.LendaAPI;
import com.unipz.xhm.fshkfrontend.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LendActivity extends AppCompatActivity {
    private RecyclerView recyclerViewSD, recyclerViewTIT;
    private final RetrofitService retrofitService= new RetrofitService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Lendet");

        recyclerViewSD= findViewById(R.id.lendetListSD_recyclerView);
        recyclerViewSD.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewTIT= findViewById(R.id.lendetListTIT_recyclerView);
        recyclerViewTIT.setLayoutManager(new LinearLayoutManager(this));

        loadLendSD();
        loadLendTIT();

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

    private void loadLendSD(){
        LendaAPI lendaAPI= retrofitService.getRetrofit().create(LendaAPI.class);
        lendaAPI.getAllLendaSD()
                .enqueue(new Callback<List<Lenda>>() {
                    @Override
                    public void onResponse(Call<List<Lenda>> call, Response<List<Lenda>> response) {
                        populateListLendaSD(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Lenda>> call, Throwable t) {
                        Toast.makeText(LendActivity.this, "Failed to Load Lenda", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void loadLendTIT(){
        LendaAPI lendaAPI= retrofitService.getRetrofit().create(LendaAPI.class);
        lendaAPI.getAllLendaTIT()
                .enqueue(new Callback<List<Lenda>>() {
                    @Override
                    public void onResponse(Call<List<Lenda>> call, Response<List<Lenda>> response) {
                        populateListLendaTIT(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Lenda>> call, Throwable t) {
                        Toast.makeText(LendActivity.this, "Failed to Load Lenda", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void populateListLendaSD(List<Lenda>lendaList){
        LendaAdapter lendaAdapter= new LendaAdapter(lendaList);
        recyclerViewSD.setAdapter(lendaAdapter);

    }

    private void populateListLendaTIT(List<Lenda>lendaList){
        LendaAdapter lendaAdapter= new LendaAdapter(lendaList);
        recyclerViewTIT.setAdapter(lendaAdapter);
    }


}