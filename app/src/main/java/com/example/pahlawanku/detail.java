package com.example.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detail extends AppCompatActivity {
private ImageView ivfoto;
private TextView tvnama,tvtentang;
private String ynama,ytentang,yfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvnama=findViewById(R.id.tv_nama);
        tvtentang=findViewById(R.id.tv_tentang);
        ivfoto=findViewById(R.id.iv_foto);

        Intent ambil= getIntent();
        ynama= ambil.getStringExtra("xnama");
        ytentang= ambil.getStringExtra("xtentang");
        yfoto= ambil.getStringExtra("xfoto");

        tvnama.setText(ynama);
        tvtentang.setText(ytentang);

        Glide
                .with(detail.this)
                .load(yfoto)
                .into(ivfoto);

    }
}