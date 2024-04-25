package com.example.networking;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Mountain> mountainArrayList;
    public MyAdapter(ArrayList<Mountain> mountainArrayList){
        this.mountainArrayList = mountainArrayList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
        }
    }



    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Mountain mountain = mountainArrayList.get(position);
        //holder.textViewName.setText(mountain.toString());
    }


    @Override
    public int getItemCount() {
        return mountainArrayList.size();
    }
}
