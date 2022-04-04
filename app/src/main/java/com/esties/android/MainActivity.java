package com.esties.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.esties.android.adapter.BottomImageHomeScreenAdapter;
import com.esties.android.adapter.HomeScreenBannerAdapter;
import com.esties.android.adapter.HomeScreenItemAdapter;
import com.esties.android.adapter.TopImageListAboutUsAdapter;
import com.esties.android.apiInterface.RestApiCalls;
import com.esties.android.model.AboutusModel;
import com.esties.android.model.BottomProductModel;
import com.esties.android.model.HomeBannerList;
import com.esties.android.model.HomeScreenMenuModel;
import com.esties.android.model.TopImageModel;
import com.esties.android.network.RetrofitInstance;
import com.esties.android.utility.ProgressDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements HomeScreenItemAdapter.ItemListener{
    private RecyclerView home_recyclerView,bottomRecycler;
    private BottomImageHomeScreenAdapter bottomImageHomeScreenAdapter;
    private Context mContext;
    public List<HomeScreenMenuModel> menuList = new ArrayList<>();
    private HomeScreenItemAdapter homeScreenItemAdapter;
    public List<BottomProductModel> productModels = new ArrayList<>();
    ViewPager2 homescreenBannerpager;
    MediaController mediaController;
    private HomeScreenBannerAdapter viewAdapter;
    private ImageView[] dots;
    private LinearLayout dotsLayout;
    private VideoView playVideo;
    private ImageView fb,insta,yelp;
    TextView text,heading,subheading,description,book_appointment,bespoke;
    ImageButton play_button;
    private ImageView thumbnail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        init();
    }
    public void init(){
        playVideo = findViewById(R.id.video_view);
        homescreenBannerpager = findViewById(R.id.viewpager);
        homescreenBannerpager.setNestedScrollingEnabled(false);
        text = findViewById(R.id.text);
        heading = findViewById(R.id.heading);
        thumbnail = findViewById(R.id.thumbnail);
        book_appointment = findViewById(R.id.book_appointment);
        play_button = findViewById(R.id.play_button);
        bottomRecycler = findViewById(R.id.bottomRecycler);
        subheading = findViewById(R.id.subheading);
        fb = findViewById(R.id.fb);
        yelp = findViewById(R.id.yelp);
        insta = findViewById(R.id.insta);
        description = findViewById(R.id.description);
        bespoke = findViewById(R.id.bespoke);
        homescreenBannerpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        bottomRecycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        homescreenBannerpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                addBottomDots(position);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                Log.e("Selected_Page", String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        home_recyclerView = findViewById(R.id.home_item_recycler);
        home_recyclerView.setNestedScrollingEnabled(false);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        book_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.estiesinternational.com/book"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/estiesinternational"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/estiesinternational/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        yelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.yelp.com/biz/esties-international-san-diego"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        bespoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this,EditorActivity.class));
            }
        });
        BottomProductModel customerReviewModel = new BottomProductModel(R.drawable.concelar,"https://www.estiesinternational.com/shop?category=Concealers",
                "Dual Action Concealer","$ 16.00");
        productModels.add(customerReviewModel);
         customerReviewModel = new BottomProductModel(R.drawable.eyeliner,"https://www.estiesinternational.com/shop?category=Eye+Liners",
                "Automatic Long Lasting Eyeliner","$ 14.00");
        productModels.add(customerReviewModel);
         customerReviewModel = new BottomProductModel(R.drawable.mascara,"https://www.estiesinternational.com/shop/luxury-waterproof-mascara",
                "Luxury Waterproof Mascara","$ 16.00");
        productModels.add(customerReviewModel);
         customerReviewModel = new BottomProductModel(R.drawable.scrub,"https://www.estiesinternational.com/shop/pure-enzyme-scrub",
                "Pure Enzyme Scrub With Aloe & Papain","$ 35.00");
        productModels.add(customerReviewModel);
         customerReviewModel = new BottomProductModel(R.drawable.sparay,"https://www.estiesinternational.com/shop/flexible-working-spray",
                "Flexible Working Spray","$ 18.00");
        productModels.add(customerReviewModel);
         customerReviewModel = new BottomProductModel(R.drawable.powder,"https://www.estiesinternational.com/shop/contour-powder-duo",
                "Contour Powder Duo","$ 23.00");
        productModels.add(customerReviewModel);

        home_recyclerView.setLayoutManager(new  LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        HomeScreenMenuModel homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.home,"Home");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.item,"About");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.lessons,"Lessons");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.gallery,"Gallery");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.editor,"Editor");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.language,"Language");
        menuList.add(homeScreenMenuModel);
        homeScreenItemAdapter = new HomeScreenItemAdapter(mContext,menuList,this);
        home_recyclerView.setAdapter(homeScreenItemAdapter);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(playVideo);
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
        getBanner();

    }

    @Override
    public void onIconSleected(HomeScreenMenuModel item) {
        if (item.getTitle().equals("Home")){
            startActivity(new Intent(this,MainActivity.class)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }else if (item.getTitle().equals("About")){
            startActivity(new Intent(this,AboutUsActivity.class));
        }else if (item.getTitle().equals("Gallery")){
            startActivity(new Intent(this,GalleryActivity.class));
        }else if (item.getTitle().equals("Editor")){
            startActivity(new Intent(this,EditorActivity.class));
        }else if (item.getTitle().equals("Lessons")){
            startActivity(new Intent(this,LessonActivity.class));
        }else if (item.getTitle().equals("Language")){
            startActivity(new Intent(this,LanguageActivity.class));
        }
    }
    private void addBottomDots(int currentPage) {
        dots = new ImageView[viewAdapter.getItemCount()];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 0);
            dotsLayout.addView(dots[i], params);
        }

        if (dots.length > 0)
            dots[currentPage].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

    }


    public void getBanner() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<AboutusModel> call = service.getHomeBanner(((MyApp) this.getApplication()).getLanguageType());
        call.enqueue(new Callback<AboutusModel>() {
            @Override
            public void onResponse(Call<AboutusModel> call, Response<AboutusModel> response) {
                try {
                    ProgressDialog.hideProgressBar();
                    if (response.code() == 200 && response.isSuccessful()){
                        onTop(response.body().getPayload().get(0).getBannersList());
                        onBottom(response.body().getPayload().get(0).getHomegallerybottomsList());
                        heading.setText(response.body().getPayload().get(0).getHeading());
                        subheading.setText("Customized Professional Guide");
                        description.setText(response.body().getPayload().get(0).getContent());
                        playVideo.setVideoURI(Uri.parse("https://rldevelopment.in/makeup/public/uploads/homeVideo/"+response.body().getPayload().get(0).getVideoUrl()));
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
    public void onTop(List<HomeBannerList> list){
        viewAdapter = new HomeScreenBannerAdapter(mContext,list);
        homescreenBannerpager.setAdapter(viewAdapter);
        addBottomDots(0);

    }
    public void onBottom(List<TopImageModel> list){

        bottomImageHomeScreenAdapter = new BottomImageHomeScreenAdapter(mContext,productModels);
        bottomRecycler.setAdapter(bottomImageHomeScreenAdapter);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getBanner();
    }
}