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

import com.example.danangdulich.DetailsActivity;
import com.example.danangdulich.R;
import com.example.danangdulich.model.AllPlacesData;

import java.util.ArrayList;
import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;
    List<AllPlacesData> allPlacesDataList;
    List<AllPlacesData> filterDataList;

    public RecentsAdapter(Context context, List<AllPlacesData> allPlacesDataList) {
        this.context = context;
        this.allPlacesDataList = allPlacesDataList;
        this.filterDataList = allPlacesDataList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item,parent,false);

        //tạo cột recycleview
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsAdapter.RecentsViewHolder holder, int position) {
        final AllPlacesData temp = filterDataList.get(position);

        holder.areaName.setText(filterDataList.get(position).getAreaName());
        holder.placeName.setText(filterDataList.get(position).getPlaceName());
        holder.placeImage.setImageResource(filterDataList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(context, DetailsActivity.class);
                it.putExtra("areaName",temp.getAreaName());
                it.putExtra("place",temp.getPlaceName());
                it.putExtra("placeImage",temp.getImageUrl());
                it.putExtra("openTime",temp.getOpenTime());
                it.putExtra("pic1",temp.getPic1());
                it.putExtra("pic2",temp.getPic2());
                it.putExtra("pic3",temp.getPic3());
                it.putExtra("desc",temp.getDesc());
                it.putExtra("price",temp.getPrice());
                it.putExtra("rating",temp.getRate());
                it.setFlags(it.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterDataList.size();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{
        ImageView placeImage;
        TextView placeName,areaName;
        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            areaName = itemView.findViewById(R.id.area_name);


        }
    }
    public List<AllPlacesData> recentsFilter(){
        List<AllPlacesData> listFilter = new ArrayList<>();
//        for (int i = 0; i < allPlacesDataList.size(); i++) {
//            if(allPlacesDataList.get(i).getAreaName().equals("Hải châu")){
//                AllPlacesData data = allPlacesDataList.get(i);
//            listFilter.add(data);
//            }
            for (AllPlacesData row : allPlacesDataList) {
            if(row.getAreaName().equals("Hải Châu") || row.getAreaName().equals("Hòa Vang")){
                listFilter.add(row);
            }
        }filterDataList = listFilter;
        return filterDataList;
    }

}
