package com.example.darazfourthassign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazfourthassign.R;
import com.example.darazfourthassign.model.Products;
import com.example.darazfourthassign.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHolder> {
    List<Products> productsLis;
    Context context;


    public ProductAdapter(Context context, List<Products> productsLis) {
        this.productsLis = productsLis;
        this.context=context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Products products=productsLis.get(position);
        Picasso.get().load(Url.base_url_image+productsLis.get(position).getImage()).into(holder.imgImage);
        holder.tvDescription.setText(products.getDescription());
        holder.tvRate.setText("Rs" + products.getPrice());
    }

    @Override
    public int getItemCount() {
        return productsLis.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imgImage;
        TextView tvDescription,tvRate;
        public ItemViewHolder(@NonNull View itemView){
            super(itemView);
            imgImage=itemView.findViewById(R.id.imgProduct);
            tvDescription=itemView.findViewById(R.id.tvProductDesc);
            tvRate=itemView.findViewById(R.id.tvProductPrice);
        }
    }
}
