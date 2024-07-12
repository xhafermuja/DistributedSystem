package com.unipz.xhm.fshkfrontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class KontaktActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Kontakti");

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

    public void dergoEmail(View view){
        new AlertDialog.Builder(this)
                .setTitle("Dergo Mesazh")
                .setMessage("Emaili u dergua me suksess!")
                .setCancelable(true)
                .show();

    }
}