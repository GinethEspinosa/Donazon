package net.smallacademy.authenticatorapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;


class AdapterItems extends RecyclerView.Adapter<AdapterItems.ProductViewHolder> {

    Context context;
    List<Item> itemsList;

    public void addData(Item data) {
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
        Picasso.get().load(itemsList.get(position).getImage()).into(holder.imageItem);
        holder.nameItem.setText(itemsList.get(position).getNameItem());
        holder.desc.setText(itemsList.get(position).getDescription());
        holder.ID.setText(itemsList.get(position).getIdItem().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ItemView.class);
                context.startActivity(i/*, activityOptions.toBundle()*/);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageItem;
        TextView nameItem;
        TextView desc;
        TextView ID;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.imageView);
            nameItem = itemView.findViewById(R.id.nameItem);
            desc = itemView.findViewById(R.id.prod_category);
            ID = itemView.findViewById(R.id.prodid3);
        }
    }
}