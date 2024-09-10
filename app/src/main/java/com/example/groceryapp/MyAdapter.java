package com.example.groceryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    private final List<Item> itemList;
    public ItemClickListener itemClickListener;

    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }
    public void setItemClickListener(ItemClickListener thisListener){
        this.itemClickListener = thisListener;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false
        );
        return new MyViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Item item = itemList.get(position);
        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.itemImg.setImageResource(item.getItemImage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public  class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemImg;
        TextView title,description;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null){
                itemClickListener.onClick(v,getAdapterPosition());
            }
        }
    }
}
