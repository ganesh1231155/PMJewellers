package com.example.pmjewellers.ui.bag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.pmjewellers.HomeActivity;
import com.example.pmjewellers.R;
import com.example.pmjewellers.ui.bag.ProductDetailedActivity;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
public class BagFragmentAdapter extends RecyclerView.Adapter<BagFragmentAdapter.viewHolder>  {
    Context context;
    ArrayList<BagModel> homeModelArrayList;

    String image,name,category,price,offers;


    public BagFragmentAdapter(Context c, ArrayList<BagModel> h) {
        this.homeModelArrayList = h;
        this.context = c;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_home_fragment,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Glide.with(context).load(homeModelArrayList.get(position).getProductImage()).centerCrop().into(holder.ProductImage);
        holder.ProductName.setText(homeModelArrayList.get(position).getProductName());
        holder.ProductCategory.setText(homeModelArrayList.get(position).getProductCategory());
        holder.ProductPrice.setText(homeModelArrayList.get(position).getProductPrice());
        holder.ProductOffers.setText(homeModelArrayList.get(position).getProductOffer());
        image = homeModelArrayList.get(position).getProductImage();
        name = homeModelArrayList.get(position).getProductName();
        category = homeModelArrayList.get(position).getProductCategory();
        price = homeModelArrayList.get(position).getProductPrice();
        offers = homeModelArrayList.get(position).getProductOffer();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetailedActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ProductImage",image);
                bundle.putString("ProductName",name);
                bundle.putString("ProductCategory",category);
                bundle.putString("ProductPrice",price);
                bundle.putString("ProductOffers",offers);
                intent.putExtra("Bundle",bundle);

                view.getContext().startActivity(intent);

            }
        });

        holder.itemView.findViewById(R.id.addToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.ProductName.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }





    @Override
    public int getItemCount() {
        return homeModelArrayList.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView ProductImage;
        TextView ProductName,ProductCategory,ProductPrice,ProductOffers;

        public viewHolder(@NonNull View itemView) {

            super(itemView);


            context  = itemView.getContext();

            ProductImage = itemView.findViewById(R.id.ProductImage);
            ProductName = itemView.findViewById(R.id.ProductName);
            ProductCategory = itemView.findViewById(R.id.ProductCategory);
            ProductPrice = itemView.findViewById(R.id.ProductPrice);
            ProductOffers = itemView.findViewById(R.id.ProductOffers);

        }






    }

}
