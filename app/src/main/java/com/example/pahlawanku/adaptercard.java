package com.example.pahlawanku;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adaptercard extends  RecyclerView.Adapter<adaptercard.classviewholder> {
    private ArrayList<modelpahlawan> datapahlawan;
    private Context ctx;

    public adaptercard(ArrayList<modelpahlawan> datapahlawan, Context ctx) {
        this.datapahlawan = datapahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public classviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varview = LayoutInflater.from(ctx).inflate(R.layout.card, parent, false);
        return new classviewholder(varview);
    }

    @Override
    public void onBindViewHolder(@NonNull classviewholder holder, int position) {

        modelpahlawan pahlawan= datapahlawan.get(position);
        holder.tvnama.setText(pahlawan.getNama());
        holder.tvtentang.setText(pahlawan.getTentang());
        Glide
                .with(ctx)
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivfoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xnama,xtentang,xfoto;
                xnama= pahlawan.getNama();
                xfoto= pahlawan.getFoto();
                xtentang = pahlawan.getTentang();
                Intent kirim = new Intent(ctx,detail.class);
                kirim.putExtra("xnama", xnama);
                kirim.putExtra("xfoto", xfoto);
                kirim.putExtra("xtentang", xtentang);
                ctx.startActivity(kirim);


//                Log.d( "cek", xnama+"|"+xfoto+"|"+ xtentang);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datapahlawan.size();
    }

    public  class classviewholder extends RecyclerView.ViewHolder{
ImageView ivfoto;
TextView tvnama,tvtentang;

        public classviewholder(@NonNull View itemView) {

            super(itemView);
            ivfoto= itemView.findViewById(R.id.iv_foto);
            tvnama= itemView.findViewById(R.id.tv_nama);
            tvtentang= itemView.findViewById(R.id.tv_tentang);
        }
    }
}
