package com.esties.android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esties.android.adapter.GalleryAdapter;
import com.esties.android.apiInterface.RestApiCalls;
import com.esties.android.model.GalleryModel;
import com.esties.android.network.RetrofitInstance;
import com.esties.android.utility.ProgressDialog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity  extends AppCompatActivity {
    private RecyclerView galleryRecycler;
    private Context mConte;
    private GalleryAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);
        mConte = this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }
    public void init(){
        galleryRecycler = findViewById(R.id.gallery_recycler);
        galleryRecycler.setLayoutManager(new LinearLayoutManager(mConte));
        getGalleryData();

    }

    public void getGalleryData() {
        ProgressDialog.showProgressBar(mConte);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<GalleryModel> call = service.getGalleryImage(((MyApp) this.getApplication()).getLanguageType());
        call.enqueue(new Callback<GalleryModel>() {
            @Override
            public void onResponse(Call<GalleryModel> call, Response<GalleryModel> response) {
                try {
                    ProgressDialog.hideProgressBar();
                    if (response.code() == 200 && response.isSuccessful()){
                        onTop(response.body().getPayload());

                          }
                }catch (NullPointerException exception){
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<GalleryModel> call, Throwable t) {
                Toast.makeText(mConte, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onTop(List<GalleryModel.GalleryDataModel> list){
       adapter = new GalleryAdapter(mConte,list);
       galleryRecycler.setAdapter(adapter);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
