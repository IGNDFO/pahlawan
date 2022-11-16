package com.example.pahlawanku;

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

    public adaptercard(ArrayList<modelpahlawan> datapahlawan) {
        this.datapahlawan = datapahlawan;
    }

    @NonNull
    @Override
    public classviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varview = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new classviewholder(varview);
    }

    @Override
    public void onBindViewHolder(@NonNull classviewholder holder, int position) {
modelpahlawan pahlawan= datapahlawan.get(position);
        holder.tvnama.setText(pahlawan.getNama());
        holder.tvtentang.setText(pahlawan.getTentang());
        Glide
                .with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivfoto);


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
