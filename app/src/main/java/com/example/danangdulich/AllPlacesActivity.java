package com.example.danangdulich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.danangdulich.adapter.AllPlacesAdapter;
import com.example.danangdulich.adapter.RecentsAdapter;
import com.example.danangdulich.model.AllPlacesData;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AllPlacesActivity extends AppCompatActivity {
    RecyclerView allplaceRecycler;
    AllPlacesAdapter allplaceAdapter;
    EditText searchView;
    CharSequence search="";
    List<AllPlacesData> allPlacesDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_places);

        searchView = findViewById(R.id.search_bar);

        allPlacesDataList = MainActivity.getAllPlacesDataList();

        setAllplaceRecycler(allPlacesDataList);
        searchView.setText(getIntent().getStringExtra("onwrite"));
        String searchlength = searchView.getText().toString();
        if (searchlength.length() == 0){
            searchView.setSelection(0);
        }else{
            searchView.requestFocus();
            searchView.setSelection(1);

        }

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                allplaceAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void setAllplaceRecycler(List<AllPlacesData> allPlacesDataList){

        allplaceRecycler = findViewById(R.id.all_place_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        allplaceRecycler.setLayoutManager(layoutManager);
        allplaceAdapter = new AllPlacesAdapter(this, allPlacesDataList);
        allplaceRecycler.setAdapter(allplaceAdapter);

    }

}