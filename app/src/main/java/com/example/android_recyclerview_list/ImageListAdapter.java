package com.example.android_recyclerview_list;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public  class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder>  {

private ArrayList<StoredImage> entryData;


    public ImageListAdapter(ArrayList<StoredImage> entryData) {
        this.entryData = entryData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ViewHolder holder, int position) {
        final StoredImage imageata = entryData.get(position);
        holder.itemImageView.setImageURI(imageata.getUriPic());
        holder.itemTextView.setText(imageata.getUriString());
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(v.getContext(), ImageDetails.class);
                detailIntent.putExtra("names",imageata);
                ((Activity)v.getContext()).startActivity(detailIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.entryData.size();
    }

class ViewHolder extends RecyclerView.ViewHolder{
    ConstraintLayout parentView;
    ImageView itemImageView;
    TextView itemTextView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.item_layout_item_name);
        itemImageView = itemView.findViewById(R.id.item_layout_item_image);

        parentView = itemView.findViewById(R.id.item_layout_parent_layout);

    }
}

}
