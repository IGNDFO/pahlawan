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

public class adapter_grid extends  RecyclerView.Adapter<adapter_grid.classviewholder> {
    private ArrayList<modelpahlawan> datapahlawan;
    private Context ctx;


    public adapter_grid(ArrayList<modelpahlawan> datapahlawan, Context ctx) {
        this.datapahlawan = datapahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public classviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varview = LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false);
        return new classviewholder(varview);
    }

    @Override
    public void onBindViewHolder(@NonNull classviewholder holder, int position) {

        modelpahlawan pahlawan= datapahlawan.get(position);

        Glide
                .with(ctx)
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.iv_grid);

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
        ImageView iv_grid;

        public classviewholder(@NonNull View itemView) {

            super(itemView);
            iv_grid= itemView.findViewById(R.id.iv_grid);

        }
    }
}
