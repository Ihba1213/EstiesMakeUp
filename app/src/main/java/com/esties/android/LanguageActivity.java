package com.esties.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esties.android.adapter.HomeScreenItemAdapter;
import com.esties.android.adapter.LanguageAdapter;
import com.esties.android.model.HomeScreenMenuModel;

import java.util.ArrayList;
import java.util.List;

public class LanguageActivity extends AppCompatActivity implements LanguageAdapter.ItemListener {
    private RecyclerView languageRecycler;
    private Context mContext;
    private LanguageAdapter adapter;
    public List<HomeScreenMenuModel> languageList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);
        getSupportActionBar().hide();
        mContext = this;
        languageRecycler= findViewById(R.id.languageRecycler);
        GridLayoutManager mGridNoses = new GridLayoutManager(mContext, 2);
        languageRecycler.setLayoutManager(mGridNoses);
        HomeScreenMenuModel homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.usa,"English");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.spanish,"Spanish");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.french,"French");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.filipino,"Filipino");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.mandarin,"Mandarin");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.swedish,"Swedish");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ductc,"Dutch");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.farsi,"Farsi");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.italy_falg,"Italian");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.new_japan,"Japanese");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.mandarin,"Chinese");
        languageList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.korean,"Korean");
        languageList.add(homeScreenMenuModel);
        adapter = new LanguageAdapter(mContext,languageList,this);
        languageRecycler.setAdapter(adapter);


    }

    @Override
    public void onIconSleected(HomeScreenMenuModel item) {
        ((MyApp) getApplication()).setLanguageType(item.getTitle());
        startActivity(new Intent(LanguageActivity.this,MainActivity.class));
        finish();
    }
}
