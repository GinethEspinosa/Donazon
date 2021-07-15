package net.smallacademy.authenticatorapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class AdapterItems extends RecyclerView.Adapter<AdapterItems.ProductViewHolder> {

    Context context;
    List<Item> itemsList;

    public void addData(Item data){
        this.itemsList.add(data);
        this.notifyDataSetChanged();
    }

    public AdapterItems(Context context, List<Item> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.products_row_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {

        holder.imageItem.setImageResource(itemsList.get(position).getImage());
        holder.nameItem.setText(itemsList.get(position).getNameItem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ItemView.class);
/*
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
               */ context.startActivity(i/*, activityOptions.toBundle()*/);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageItem;
        TextView nameItem;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.imageView);
            nameItem = itemView.findViewById(R.id.prod_name2);

        }
    }
}