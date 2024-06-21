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

import com.unipz.xhm.fshkfrontend.model.Lenda;
import com.unipz.xhm.fshkfrontend.retrofit.LendaAPI;
import com.unipz.xhm.fshkfrontend.retrofit.RetrofitService;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PanelLendetActivity extends AppCompatActivity {
    private final RetrofitService retrofitService= new RetrofitService();
    private final LendaAPI lendaAPI = retrofitService.getRetrofit().create(LendaAPI.class);
    private EditText titulliLenda,krediLenda,orariLenda, idLenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_lendet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Panel Lendet");

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
        titulliLenda = findViewById(R.id.lendaTitulli);
        krediLenda = findViewById(R.id.lendaKredi);
        orariLenda = findViewById(R.id.lendaOraMbajtjes);
        idLenda= findViewById(R.id.lendaId);
    }

    public void addLend(View view){
        String titulli = String.valueOf(titulliLenda.getText());
        String kredi = String.valueOf(krediLenda.getText());
        String orari = String.valueOf(orariLenda.getText());

        Lenda lenda = new Lenda();
        lenda.setLendaTitulli(titulli);
        lenda.setLendaKredi(Integer.parseInt(kredi));
        lenda.setLendaOraMbajtjes(orari);

        lendaAPI.saveLenda(lenda)
                .enqueue(new Callback<Lenda>() {
                    @Override
                    public void onResponse(Call<Lenda> call, Response<Lenda> response) {
                        Toast.makeText(PanelLendetActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Lenda> call, Throwable t) {
                        Toast.makeText(PanelLendetActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });
    }

    public void updateLend(View view){
        String id = String.valueOf(idLenda.getText());
        String titulli = String.valueOf(titulliLenda.getText());
        String kredi = String.valueOf(krediLenda.getText());
        String orari = String.valueOf(orariLenda.getText());

        Lenda lenda= new Lenda();

        lenda.setLendaTitulli(titulli);
        lenda.setLendaKredi(Integer.parseInt(kredi));
        lenda.setLendaOraMbajtjes(orari);

        lendaAPI.updateLenda(Integer.parseInt(id),lenda)
                .enqueue(new Callback<Lenda>() {
                    @Override
                    public void onResponse(Call<Lenda> call, Response<Lenda> response) {
                        Toast.makeText(PanelLendetActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Lenda> call, Throwable t) {
                        Toast.makeText(PanelLendetActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });

    }

    public void deleteLend(View view){
        String id = String.valueOf(idLenda.getText());

        lendaAPI.deleteLenda(Integer.parseInt(id))
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(PanelLendetActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(PanelLendetActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                    }
                });
    }

}