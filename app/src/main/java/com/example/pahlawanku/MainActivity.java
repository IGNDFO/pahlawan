package com.example.pahlawanku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        adaptercard varadaptercard = new adaptercard(data,MainActivity.this);
        rvpahlawan.setAdapter(varadaptercard);
    }
    private void tampildatagrid(){
        rvpahlawan.setLayoutManager(new GridLayoutManager(this,2));
        adapter_grid varadaptergrid= new adapter_grid(data, MainActivity.this);
        rvpahlawan.setAdapter(varadaptergrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mode, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mode_card:
                tampildatacard();
                break;
            case R.id.mode_grid:
                tampildatagrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}