package com.unipz.xhm.fshkfrontend;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Mirsevini");


    }

    public void goDepartment(View view){
        startActivity(new Intent(this,DepartmentActivity.class));
    }

    public void goAdminPanel(View view){
        startActivity(new Intent(this, PanelDepartmentActivity.class));
    }


}