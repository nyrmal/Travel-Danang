package com.example.danangdulich;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danangdulich.adapter.RecentsAdapter;
import com.example.danangdulich.adapter.TopPlacesAdapter;
import com.example.danangdulich.model.AllPlacesData;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recentRecycler, topPlaceRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
    EditText searchbar;
    DatabaseHelper databaseHelper;

    public static List<AllPlacesData> allPlacesDataList;

    public static List<AllPlacesData> getAllPlacesDataList() {
        return allPlacesDataList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tatca);
        searchbar = (EditText)findViewById(R.id.searchBar);
        //allPlacesDataList = new AllPlacesActivity().getAllPlacesDataList();

        //database
        databaseHelper = new DatabaseHelper(MainActivity.this);

        databaseHelper.insertTable(new AllPlacesData("Asia Park","Hải Châu","8h - 21h",R.drawable.asia1,R.drawable.asia2,R.drawable.asia3,openFile("asia.txt"),"50.000",R.drawable.asia5,5.0));
        databaseHelper.insertTable(new AllPlacesData("Bà Nà hill","Hòa Vang","7h30 - 21h",R.drawable.banahill1,R.drawable.banahill2,R.drawable.banahill3,openFile("banahill.txt"),"200.000",R.drawable.banahill4,4.7));
        databaseHelper.insertTable(new AllPlacesData("Bãi biển Mỹ khê","Sơn Trà","24/24h",R.drawable.mykhe1,R.drawable.mykhe2,R.drawable.mykhe3,openFile("mykhebeach.txt"),"100.000",R.drawable.mykhe5,5.0));
        databaseHelper.insertTable(new AllPlacesData("Bán đảo Sơn trà","Sơn Trà","24/24h",R.drawable.bandaosontra1,R.drawable.bandaosontra2,R.drawable.bandaosontra3,openFile("sontraisland.txt"),"200.000",R.drawable.bandaosontra4,4.6));
        databaseHelper.insertTable(new AllPlacesData("Cầu Rồng","Hải Châu","24/24h",R.drawable.caurong1,R.drawable.caurong2,R.drawable.caurong3,openFile("caurong.txt"),"0",R.drawable.caurong4,4.0));
        databaseHelper.insertTable(new AllPlacesData("Chùa Linh ứng","Sơn Trà","8h - 21h",R.drawable.chualinhung1,R.drawable.chualinhung2,R.drawable.chualinhung3,openFile("linhungpagoda.txt"),"0",R.drawable.chualinhung5,4.5));
        databaseHelper.insertTable(new AllPlacesData("Cù Lao Chàm","Hội An","8h - 21h",R.drawable.culaocham1,R.drawable.culaocham2,R.drawable.culaocham3,openFile("culaotram.txt"),"50.000",R.drawable.culaocham4,5.0));
        databaseHelper.insertTable(new AllPlacesData("Cung văn hóa","Hải Châu","8h - 21h",R.drawable.cungthieunhi1,R.drawable.cungthieunhi2,R.drawable.cungthieunhi3,openFile("cungthieunhi.txt"),"20.000",R.drawable.cungthieunhi5,3.0));
        databaseHelper.insertTable(new AllPlacesData("Đỉnh bàn cờ","Sơn Trà","8h - 21h",R.drawable.banco1,R.drawable.banco2,R.drawable.banco3,openFile("banco.txt"),"50.000",R.drawable.banco4,4.1));
        databaseHelper.insertTable(new AllPlacesData("Ghềnh Bàng","Sơn Trà","8h - 21h",R.drawable.ghenhbang1,R.drawable.ghenhbang2,R.drawable.ghenhbang3,openFile("ghenhbang.txt"),"80.000",R.drawable.ghenhbang4,4.5));
        databaseHelper.insertTable(new AllPlacesData("Làng bích họa","Tam kỳ","8h - 21h",R.drawable.bichhoa1,R.drawable.bichhoa2,R.drawable.bichhoa3,openFile("bichhoa.txt"),"50.000",R.drawable.bichhoa5,4.2));
        databaseHelper.insertTable(new AllPlacesData("Núi Ngũ Hành Sơn","Ngũ Hành Sơn","24/24h",R.drawable.nguhanhson1,R.drawable.nguhanhson2,R.drawable.nguhanhson3,openFile("nguhanhson.txt"),"0",R.drawable.nguhanhson4,3.8));
        databaseHelper.insertTable(new AllPlacesData("Núi thần tài","Hòa Vang","24/24h",R.drawable.nuithantai1,R.drawable.nuithantai2,R.drawable.nuithantai3,openFile("nuithantai.txt"),"60.000",R.drawable.nuithantai5,4.8));
        databaseHelper.insertTable(new AllPlacesData("Rạng Nam Ô","Liên Chiểu","8h - 21h",R.drawable.namo1,R.drawable.namo2,R.drawable.namo3,openFile("namo.txt"),"40.000",R.drawable.namo4,3.4));
        databaseHelper.insertTable(new AllPlacesData("Thánh địa Mỹ Sơn","Duy Xuyên","8h - 21h",R.drawable.myson1,R.drawable.myson2,R.drawable.myson3,openFile("myson.txt"),"80.000",R.drawable.myson5,4.3));


        allPlacesDataList = databaseHelper.getAll();
        //allPlacesDataList = new ArrayList<>();


        //List<RecentsData> recentsDataList = new ArrayList<>();


        setRecentRecycler(allPlacesDataList);



        setTopPlaceRecycler(allPlacesDataList);


        final Intent it = new Intent(this, AllPlacesActivity.class);

            searchbar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    String temp = searchbar.getText().toString();
                    it.putExtra("onwrite",temp);
                    startActivity(it);
                }
            });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //it.putExtra("onwrite"," ");
                startActivity(it);
            }
        });
    }


    private void setRecentRecycler(List<AllPlacesData> allPlacesDataList){
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, allPlacesDataList);
        recentsAdapter.recentsFilter();
        recentRecycler.setAdapter(recentsAdapter);
    }
    private void setTopPlaceRecycler(List<AllPlacesData> allPlacesDataList){
        topPlaceRecycler = findViewById(R.id.top_place_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlaceRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, allPlacesDataList);
        topPlacesAdapter.topPlacesFilter();
        topPlaceRecycler.setAdapter(topPlacesAdapter);
    }
    public String openFile(String a) {
        String text = "";
        try {
            InputStream is = getAssets().open(a);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}