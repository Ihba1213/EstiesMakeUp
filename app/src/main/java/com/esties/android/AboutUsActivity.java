package com.esties.android;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.esties.android.adapter.BottomImageListAboutUsAdapter;
import com.esties.android.adapter.TopImageListAboutUsAdapter;
import com.esties.android.apiInterface.RestApiCalls;
import com.esties.android.model.AboutusModel;
import com.esties.android.model.BottomImageModel;
import com.esties.android.model.TopImageModel;
import com.esties.android.network.RetrofitInstance;
import com.esties.android.utility.ProgressDialog;
import com.esties.android.utility.SnapHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutUsActivity extends AppCompatActivity {
    private Context mContext;
    private RecyclerView topList,bottom_recycler_aboutus;
    private TextView desc;
    private ArrayList<String> TopList = new ArrayList<String>();
    private TopImageListAboutUsAdapter topImageListAboutUsAdapter;
    private BottomImageListAboutUsAdapter bottomImageListAboutUsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        mContext = this;
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        desc = findViewById(R.id.description);
        LinearSnapHelper linearSnapHelper = new SnapHelper();
        topList = findViewById(R.id.top_recycler_aboutus);
        bottom_recycler_aboutus = findViewById(R.id.bottom_recycler_aboutus);
        topList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        bottom_recycler_aboutus.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        linearSnapHelper.attachToRecyclerView(bottom_recycler_aboutus);
        getTopList();

    }

    public void getTopList() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<AboutusModel> call = service.getList(((MyApp) this.getApplication()).getLanguageType());
        call.enqueue(new Callback<AboutusModel>() {
            @Override
            public void onResponse(Call<AboutusModel> call, Response<AboutusModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()){
                        ProgressDialog.hideProgressBar();
                        desc.setText(response.body().getPayload().get(0).getDescription());
                        onTop(response.body().getPayload().get(0).getAboutTopImageList());
                        onBottom(response.body().getPayload().get(0).getAboutBottomImageList());
                    }else if (response.code() == 400){
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }catch (NullPointerException exception){
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<AboutusModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onTop(List<TopImageModel> list){
        topImageListAboutUsAdapter = new TopImageListAboutUsAdapter(mContext,list);
        topList.setAdapter(topImageListAboutUsAdapter);

    }
    public void onBottom(List<BottomImageModel> listBottom){
        bottomImageListAboutUsAdapter = new BottomImageListAboutUsAdapter(mContext,listBottom);
        bottom_recycler_aboutus.setAdapter(bottomImageListAboutUsAdapter);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
