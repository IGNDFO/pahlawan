package com.example.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private RecyclerView rvpahlawan;
private ArrayList<modelpahlawan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvpahlawan = findViewById(R.id.rv_pahlawan);
        rvpahlawan.setHasFixedSize(true);
        data.addAll(datapahlawan.ambilDataPahlawan());
        tampildatacard();
    }

    private void tampildatacard(){
        rvpahlawan.setLayoutManager(new LinearLayoutManager(this));
        adaptercard varadaptercard = new adaptercard(data);
        rvpahlawan.setAdapter(varadaptercard);
    }
}