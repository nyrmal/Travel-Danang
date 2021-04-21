package com.example.danangdulich.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danangdulich.AllPlacesActivity;
import com.example.danangdulich.DetailsActivity;
import com.example.danangdulich.ItemAnimation;
import com.example.danangdulich.R;
import com.example.danangdulich.model.AllPlacesData;


import java.util.ArrayList;
import java.util.List;


public class AllPlacesAdapter extends RecyclerView.Adapter<AllPlacesAdapter.RecyclerviewHolder> {

    Context context;
    List<AllPlacesData> allPlacesDataList;
    List<AllPlacesData> filterDataList;

    public AllPlacesAdapter(Context context, List<AllPlacesData> allPlacesDataList) {
        this.context = context;
        this.allPlacesDataList = allPlacesDataList;
        this.filterDataList = allPlacesDataList;
    }



    @NonNull
    @Override
    public AllPlacesAdapter.RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_place_row_item,parent,false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllPlacesAdapter.RecyclerviewHolder holder, int position) {

        final AllPlacesData temp = filterDataList.get(position);
            holder.areaName.setText(filterDataList.get(position).getAreaName());
            holder.placeName.setText(filterDataList.get(position).getPlaceName());
            holder.placeImage.setImageResource(filterDataList.get(position).getImageUrl());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it = new Intent(context, DetailsActivity.class);
                    it.putExtra("areaName",temp.getAreaName());
                    it.putExtra("place", temp.getPlaceName());
                    it.putExtra("placeImage", temp.getImageUrl());
                    it.putExtra("openTime", temp.getOpenTime());
                    it.putExtra("pic1", temp.getPic1());
                    it.putExtra("pic2", temp.getPic2());
                    it.putExtra("pic3", temp.getPic3());
                    it.putExtra("desc", temp.getDesc());
                    it.putExtra("price", temp.getPrice());
                    it.putExtra("rating",temp.getRate());
                    it.setFlags(it.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(it);
                }
            });
        ItemAnimation.animateFadeIn(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return filterDataList.size();

    }

    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName,areaName;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            areaName = itemView.findViewById(R.id.area_name);
        }
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String Key = charSequence.toString();
                if (Key.isEmpty()) {
                    filterDataList = allPlacesDataList;
                } else {
                    List<AllPlacesData> listFilter = new ArrayList<>();
                    for (AllPlacesData row : allPlacesDataList) {
                        if (row.getPlaceName().toLowerCase().contains(Key.toLowerCase())) {
                            listFilter.add(row);
                        }
                    }
                    filterDataList = listFilter;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterDataList = (List<AllPlacesData>)filterResults.values;
                notifyDataSetChanged();
            }
        };

    }
}