package com.esties.android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.esties.android.adapter.BottomImageLessonAdapter;
import com.esties.android.adapter.TopImageLessonAdapter;
import com.esties.android.apiInterface.RestApiCalls;
import com.esties.android.model.LessonAfterAndBeforeImageList;
import com.esties.android.model.LessonDataModel;
import com.esties.android.model.LessonSliderImagesList;
import com.esties.android.model.LessonsModel;
import com.esties.android.network.RetrofitInstance;
import com.esties.android.utility.ProgressDialog;
import com.esties.android.utility.SnapHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LessonActivity extends AppCompatActivity {
    private TextView content,desc;
    private Context mContext;
    private RecyclerView makeupRecycler,imageRecycler;
    MediaController mediaController;
    private VideoView playVideo;
    ImageButton play_button;
    private ImageView thumbnail;
    private TopImageLessonAdapter topImageLessonAdapter;
    private BottomImageLessonAdapter bottomImageLessonAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessonlayout);
        mContext = this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }
    public void init(){
        desc = findViewById(R.id.description);
        playVideo = findViewById(R.id.video_view);
        thumbnail = findViewById(R.id.thumbnail);
        play_button = findViewById(R.id.play_button);
        imageRecycler = findViewById(R.id.imageRecycler);
        makeupRecycler = findViewById(R.id.makeupRecyclerImages);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(playVideo);
        LinearSnapHelper linearSnapHelper = new SnapHelper();
        playVideo.setMediaController(mediaController);
        playVideo.seekTo(1);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo.start();
                play_button.setVisibility(View.GONE);
                thumbnail.setVisibility(View.GONE);
            }
        });
        makeupRecycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        imageRecycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        linearSnapHelper.attachToRecyclerView(imageRecycler);
        getLessons();

    }


        public void getLessons(){
            ProgressDialog.showProgressBar(mContext);
            RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
            Call<LessonsModel> call = service.getLessonData(((MyApp) this.getApplication()).getLanguageType());
            call.enqueue(new Callback<LessonsModel>() {
                @Override
                public void onResponse(Call<LessonsModel> call, Response<LessonsModel> response) {
                    try {
                        ProgressDialog.hideProgressBar();
                        if (response.code() == 200 && response.isSuccessful()){
                            desc.setText(response.body().getPayload().get(0).getDescription());
                            onTop(response.body().getPayload().get(0).getLessonSliderImagesList());
                            onBottomList(response.body().getPayload().get(0).getLessonAfterAndBeforeImageList());
                            playVideo.setVideoURI(Uri.parse("https://rldevelopment.in/makeup/public/uploads/lessonVideo/"+response.body().getPayload().get(0).getVideoUrl()));


                        }
                    }catch (NullPointerException exception){
                        exception.getMessage();
                    }
                }

                @Override
                public void onFailure(Call<LessonsModel> call, Throwable t) {
                    Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
        public void onTop(List<LessonSliderImagesList> list){
            topImageLessonAdapter = new TopImageLessonAdapter(mContext,list);
            makeupRecycler.setAdapter(topImageLessonAdapter);

        }
    public void onBottomList(List<LessonAfterAndBeforeImageList> list){
        bottomImageLessonAdapter = new BottomImageLessonAdapter(mContext,list);
        imageRecycler.setAdapter(bottomImageLessonAdapter);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
