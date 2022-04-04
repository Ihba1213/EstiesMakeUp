package com.esties.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.esties.android.adapter.EyeBrowAdapter;
import com.esties.android.adapter.EyesAdapter;
import com.esties.android.adapter.FaceAdapter;
import com.esties.android.adapter.HomeScreenItemAdapter;
import com.esties.android.adapter.LipsAdapter;
import com.esties.android.adapter.NoseAdapter;
import com.esties.android.adapter.wrinkles.CheekWrinklesAdapter;
import com.esties.android.adapter.wrinkles.DoubleChinAdapter;
import com.esties.android.adapter.wrinkles.EyesWrinkleAdapter;
import com.esties.android.adapter.wrinkles.ForeHeadChinWrinklesAdapter;
import com.esties.android.adapter.wrinkles.LipsCornerAdapter;
import com.esties.android.adapter.wrinkles.LipsNoseWrinkleAdapter;
import com.esties.android.adapter.wrinkles.LipsTopWrinklesAdapter;
import com.esties.android.apiInterface.RestApiCalls;

import com.esties.android.databinding.EditorLayoutBinding;
import com.esties.android.model.CheekWrinkle;
import com.esties.android.model.DoubleChinWrinkle;
import com.esties.android.model.EyeBrowsModel;
import com.esties.android.model.EyebrowsWrinkle;
import com.esties.android.model.EyesModel;
import com.esties.android.model.EyesWrinkle;
import com.esties.android.model.FaceModel;
import com.esties.android.model.FinalImageDataModel;
import com.esties.android.model.FinalImageModel;
import com.esties.android.model.ForheadWrinkle;
import com.esties.android.model.HomeScreenMenuModel;
import com.esties.android.model.LipsCornerWrinkle;
import com.esties.android.model.LipsModel;
import com.esties.android.model.LipsNoseWrinkle;
import com.esties.android.model.LipsTopWrinkle;
import com.esties.android.model.NoseModel;
import com.esties.android.model.WrinkleModel;
import com.esties.android.network.RetrofitInstance;
import com.esties.android.utility.ProgressDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity implements HomeScreenItemAdapter.ItemListener, EyeBrowAdapter.ItemListener
        , EyesAdapter.ItemListener, LipsAdapter.ItemListener, NoseAdapter.ItemListener,
        FaceAdapter.ItemListener, DoubleChinAdapter.ItemListener, CheekWrinklesAdapter.ItemListener
        , LipsCornerAdapter.ItemListener, LipsNoseWrinkleAdapter.ItemListener, LipsTopWrinklesAdapter.ItemListener,
        ForeHeadChinWrinklesAdapter.ItemListener, EyesWrinkleAdapter.ItemListener {
    private Context mContext;
    private FaceAdapter faceAdapter;
    private EditorLayoutBinding binding;
    private int xDelta;
    private int yDelta;
    private HomeScreenItemAdapter homeScreenItemAdapter;
    public List<HomeScreenMenuModel> menuList = new ArrayList<>();
    private BottomSheetBehavior eyebrowsheet,
            eyesheet, lipsSheet, noseSheet, btCheekWrinkles, btDoubleChin,
            btForeHeadChin, btLipsTopWrinkles, btEyesErinkles, btLipsNoseWrinkles, btLipsCornerWrinkles;
    private int noseId,lipId,eyeid,eyebrowid,faceid,
            doubleChinWrinkleId, chickWrinkleId;
    private String lefteyebrowWM, righteyeBrowWM, lefteyeWM, righteyeWM,
            noseWM, lipsWM, defaultFaceWM,
            leftCheekWrinklesWM, rightCheekWrinklesWm,
            doubleChinWrinklesWm, foreHeadWrinklesWm, lipsTopWrinklesWm, lipsNoseWrinklesWm, leftEyeWrinklesWm, rightEyeWrinkleWm,
            leftLipsCornerWrinklesWm;
    private final List<CheekWrinkle> cheekWrinkles = new ArrayList<>();
    private final List<DoubleChinWrinkle> doubleChin = new ArrayList<>();
    private final List<ForheadWrinkle> foreheadWrinkles = new ArrayList<>();
    private final List<LipsTopWrinkle> lipsTopWrinkles = new ArrayList<>();
    private final List<LipsNoseWrinkle> lipsNoseWrinkles = new ArrayList<>();
    private final List<EyesWrinkle> eyesWrinkles = new ArrayList<>();
    private final List<LipsCornerWrinkle> lipsCornerWrinkles = new ArrayList<>();
    private final List<EyebrowsWrinkle> eyebrowWrinkles = new ArrayList<>();
    private int foreheadWrinklesId;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.editor_layout);
        mContext = this;
        faceid = 18;
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Glide.with(mContext).load("https://rldevelopment.in/makeup/public/uploads/face/hta5J39.jpg").into(binding.defaultFace);
        defaultFaceWM = "https://rldevelopment.in/makeup/public/uploads/face/YEAIdOh.png";
        setBottomSheetBehaviour();
        setTouchListener();
        setLayoutManagerForWrinkle();
        setLayoutMangerForRemaingData();
        setHomeScreenModelData();
        setClickListener();
        getFace(1);
    }

    private void setLayoutMangerForRemaingData() {
        binding.bsEyebrow.eyebrowRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        binding.bsEye.eyeRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        binding.makeupSelectionRecycler.setLayoutManager(new LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL,
                false)
        );
        GridLayoutManager mGridLips = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridNoses = new GridLayoutManager(mContext, 2);
        binding.bsLipsBottom.lipsRecycler.setLayoutManager(mGridLips);
        binding.bsNoseBottom.noseRecycler.setLayoutManager(mGridNoses);
    }

    private void setClickListener() {
        binding.cancelButton.setOnClickListener(view -> {
            if (faceAdapter != null) {
                binding.makeupSelectionRecycler.setAdapter(homeScreenItemAdapter);
            } else {
                finish();
            }
        });

        binding.finalMakeUp.setOnClickListener(view -> {
            finalMakeUpImage();
//                startActivity(new Intent(EditorActivity.this, FinalMakeUpActivity.class)
//                        .putExtra("lefteyebrowWM", lefteyebrowWM)
//                        .putExtra("righteyeBrowWM", righteyeBrowWM)
//                        .putExtra("lefteyeWM", lefteyeWM)
//                        .putExtra("righteyeWM", righteyeWM)
//                        .putExtra("defaultFaceWM", defaultFaceWM)
//                        .putExtra("noseWM", noseWM)
//                        .putExtra("lefteyeid", lefteyeid)
//                        .putExtra("lefteyebrowid", lefteyebrowid)
//                        .putExtra("noseId", noseId)
//                        .putExtra("faceid", faceid)
//                        .putExtra("cheeck", chickWrinkleId)
//                        .putExtra("chin", doubleChinWrinkleId)
//                        .putExtra("forhead", foreheadWrinklesId)
//                        .putExtra("lptop", lipsTopWrinkleId)
//                        .putExtra("eyeWrinkle", eyeWrinkleId)
//                        .putExtra("lpnose", lipsNoseWrinklesId)
//                        .putExtra("lpcorner", lipsCornerWrinklesId)
//                        .putExtra("leftCheekWrinklesWM", leftCheekWrinklesWM)
//                        .putExtra("rightCheekWrinklesWm", rightCheekWrinklesWm)
//                        .putExtra("doubleChinWrinklesWm", doubleChinWrinklesWm)
//                        .putExtra("foreHeadWrinklesWm", foreHeadWrinklesWm)
//                        .putExtra("lipsTopWrinklesWm", lipsTopWrinklesWm)
//                        .putExtra("leftEyeWrinklesWm", leftEyeWrinklesWm)
//                        .putExtra("rightEyeWrinkleWm", rightEyeWrinkleWm)
//                        .putExtra("leftLipsCornerWrinklesWm", leftLipsCornerWrinklesWm)
//                        .putExtra("rightLipsCornerWrinklesWm", rightLipsCornerWrinklesWm)
//                        .putExtra("leftEyeBrowWrinkleWm", leftEyeBrowWrinkleWm)
//                        .putExtra("rightEyeBrowWrinkleWm", rightEyeBrowWrinkleWm)
//                        .putExtra("lipsWM", lipsWM));
        });
    }

    private void setHomeScreenModelData() {
        HomeScreenMenuModel homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Faces");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "EyeBrow");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Eyes");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Noses");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Lips");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Cheek Wrinkles");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Double Chin");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Forehead Wrinkles");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Lips Top Wrinkles");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Eyes Wrinkles");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Lips Nose Wrinkles");
        menuList.add(homeScreenMenuModel);
        homeScreenMenuModel = new HomeScreenMenuModel(R.drawable.ic_baseline_catching_pokemon_24, "Lips Corner Wrinkles");
        menuList.add(homeScreenMenuModel);
        homeScreenItemAdapter = new HomeScreenItemAdapter(mContext, menuList, this);
        binding.makeupSelectionRecycler.setAdapter(homeScreenItemAdapter);
    }

    private void setBottomSheetBehaviour() {
        eyebrowsheet = BottomSheetBehavior.from(binding.bsEyebrow.bottomSheetEyebrow);
        eyesheet = BottomSheetBehavior.from(binding.bsEye.bottomSheetEye);
        lipsSheet = BottomSheetBehavior.from(binding.bsLipsBottom.bottomSheetLips);
        noseSheet = BottomSheetBehavior.from(binding.bsNoseBottom.bottomSheetNose);
        btCheekWrinkles = BottomSheetBehavior.from(binding.bsCheekWrinkles.bottomSheetCheekWrinkles);
        btForeHeadChin = BottomSheetBehavior.from(binding.bsForeHeadWrinkles.bottomSheetForeheadwrinkles);
        btDoubleChin = BottomSheetBehavior.from(binding.bsDoubleChin.bottomSheetDoubleChin);
        btEyesErinkles = BottomSheetBehavior.from(binding.bsEyesWrinkles.bottomSheetEyesWrinkles);
        btLipsCornerWrinkles = BottomSheetBehavior.from(binding.bsLipsCornerWrinkles.bottomSheetLipsCornerWrinkles);
        btLipsTopWrinkles = BottomSheetBehavior.from(binding.bsLipsTopWrinkle.bottomSheetLipsTopWrinkles);
        btLipsNoseWrinkles = BottomSheetBehavior.from(binding.bsLipsNoseWrinkle.bottomSheetLipsNoseWrinkle);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setTouchListener() {
        binding.lefteyebrow.setOnTouchListener(onTouchListener());
        binding.righteyeBrow.setOnTouchListener(onTouchListener());
        binding.lefteye.setOnTouchListener(onTouchListener());
        binding.righteye.setOnTouchListener(onTouchListener());
        binding.nose.setOnTouchListener(onTouchListener());
        binding.lips.setOnTouchListener(onTouchListener());
        binding.ivLeftCheekWrinkles.setOnTouchListener(onTouchListener());
        binding.ivRightCheekWrinkles.setOnTouchListener(onTouchListener());
        binding.ivForeHeadWrinkles.setOnTouchListener(onTouchListener());
        binding.ivLipsLeftCornerWrinkles.setOnTouchListener(onTouchListener());
        binding.ivLipsRightCornerWrinkles.setOnTouchListener(onTouchListener());
        binding.ivLipsTopCornerWrinkles.setOnTouchListener(onTouchListener());
        binding.ivDoubleChinWrinkles.setOnTouchListener(onTouchListener());
        binding.ivLipsTopCornerWrinkles.setOnTouchListener(onTouchListener());
        binding.ivLeftEyeWrinkles.setOnTouchListener(onTouchListener());
        binding.ivRightEyeWrinkles.setOnTouchListener(onTouchListener());
        binding.ivLipsNoseCornerWrinkles.setOnTouchListener(onTouchListener());
    }

    private void finalMakeUpImage() {
        binding.beforeMakeupContainer.setVisibility(View.GONE);
        binding.afterViewMakeupContainer.setVisibility(View.VISIBLE);
        getDescriptionData(lipId,noseId, eyeid,eyebrowid,faceid,chickWrinkleId,doubleChinWrinkleId,foreheadWrinklesId);
    }

    public void getDescriptionData(int lipid, int noseid, int eyyid, int eyebroid, int faceid,int chinID,int cheekID,int forhead) {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<FinalImageModel> call = service.getFinalMakeUpImage(faceid, 1, eyyid, eyebroid,
                noseid, lipid, chinID,cheekID,forhead,((MyApp) this.getApplication()).getLanguageType());
        call.enqueue(new Callback<FinalImageModel>() {
            @Override
            public void onResponse(Call<FinalImageModel> call, Response<FinalImageModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        onCall(response.body().getPayload());
                        setAfterImage();


                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<FinalImageModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCall(List<FinalImageDataModel> finalImageDataModels) {
        if (finalImageDataModels.get(0).getEyeBrowContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getEyeBrowContentList().get(0).getDescription();
            binding.EyebrowDesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            binding.Eyebrowlayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getNoseContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getNoseContentList().get(0).getDescription();
            binding.NoseDesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            binding.Noselayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getEyesContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getEyesContentList().get(0).getDescription();
            binding.Eyedesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            binding.Eyelayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getFaceContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getFaceContentList().get(0).getDescription();
            binding.facedesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            binding.facelayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getLipsContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getLipsContentList().get(0).getDescription();
            binding.LipDesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            binding.Liplayout.setVisibility(View.GONE);
        }

    }

    private void setAfterImage() {
        Glide.with(mContext).load(defaultFaceWM).into(binding.defaultFace);
        Glide.with(mContext).load(lefteyebrowWM).into(binding.lefteyebrow);
        Glide.with(mContext).load(righteyeBrowWM).into(binding.righteyeBrow);
        Glide.with(mContext).load(lefteyeWM).into(binding.lefteye);
        Glide.with(mContext).load(righteyeWM).into(binding.righteye);
        Glide.with(mContext).load(noseWM).into(binding.nose);
        Glide.with(mContext).load(lipsWM).into(binding.lips);
        Glide.with(mContext).load(leftCheekWrinklesWM).into(binding.ivLeftCheekWrinkles);
        Glide.with(mContext).load(rightCheekWrinklesWm).into(binding.ivRightCheekWrinkles);
        Glide.with(mContext).load(doubleChinWrinklesWm).into(binding.ivDoubleChinWrinkles);
        Glide.with(mContext).load(foreHeadWrinklesWm).into(binding.ivForeHeadWrinkles);
        Glide.with(mContext).load(lipsTopWrinklesWm).into(binding.ivLipsTopCornerWrinkles);
        Glide.with(mContext).load(leftEyeWrinklesWm).into(binding.ivLeftEyeWrinkles);
        Glide.with(mContext).load(rightEyeWrinkleWm).into(binding.ivRightEyeWrinkles);
        Glide.with(mContext).load(lipsNoseWrinklesWm).into(binding.ivLipsNoseCornerWrinkles);
        Glide.with(mContext).load(leftLipsCornerWrinklesWm).into(binding.ivLipsLeftCornerWrinkles);
        setDescriptionDataRv();


    }

    private void setDescriptionDataRv() {
    }

    private void setLayoutManagerForWrinkle() {
        GridLayoutManager mGridCheekWrinkles = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridDoubleChin = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridEyesWrinkles = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridLipsCornerWrinkles = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridLipsTopWrinkles = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridLipsNoseWrinkles = new GridLayoutManager(mContext, 2);
        GridLayoutManager mGridForeHeadChin = new GridLayoutManager(mContext, 2);
        binding.bsCheekWrinkles.cheekWrinklesRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        binding.bsDoubleChin.doubleChinRecycler.setLayoutManager(mGridDoubleChin);
        binding.bsEyesWrinkles.eyesWrinklesRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        binding.bsLipsCornerWrinkles.lipsCornerWrinklesRecycler.setLayoutManager(mGridLipsTopWrinkles);
        binding.bsLipsNoseWrinkle.lipsNoseWrinkleRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        binding.bsForeHeadWrinkles.foreheadwrinklesRecycler.setLayoutManager(mGridForeHeadChin);
    }


    public void getFace(int show) {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<FaceModel> call = service.getFaceImageList();
        call.enqueue(new Callback<FaceModel>() {
            @Override
            public void onResponse(Call<FaceModel> call, Response<FaceModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        onTop(response.body().getPayload(), show);
                        // getAllWrinkles for First Time
                        getWrinkles();
                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<FaceModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onTop(List<FaceModel.FaceDataModel> list, int show) {
        faceAdapter = new FaceAdapter(mContext, list, this);
        if (show == 0) {
            binding.makeupSelectionRecycler.setAdapter(faceAdapter);
        }
    }

    public void getEyes() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<EyesModel> call = service.getEyeImageList();
        call.enqueue(new Callback<EyesModel>() {
            @Override
            public void onResponse(Call<EyesModel> call, Response<EyesModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        eyeList(response.body().getPayload());
                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<EyesModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void eyeList(List<EyesModel.EyesDataModel> list) {
        EyesAdapter eyesAdapter = new EyesAdapter(mContext, list, this);
        binding.bsEye.eyeRecycler.setAdapter(eyesAdapter);
        eyesheet.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void getNose() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<NoseModel> call = service.getNoseBrowsImageList();
        call.enqueue(new Callback<NoseModel>() {
            @Override
            public void onResponse(Call<NoseModel> call, Response<NoseModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        noseList(response.body().getPayload());
                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<NoseModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void noseList(List<NoseModel.NoseDataModel> list) {
        NoseAdapter noseAdapter = new NoseAdapter(mContext, list, this);
        binding.bsNoseBottom.noseRecycler.setAdapter(noseAdapter);
        noseSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void getLips() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<LipsModel> call = service.getLipsImageList();
        call.enqueue(new Callback<LipsModel>() {
            @Override
            public void onResponse(Call<LipsModel> call, Response<LipsModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        lipList(response.body().getPayload());
                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<LipsModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void lipList(List<LipsModel.LipsDataModel> list) {
        LipsAdapter lipsAdapter = new LipsAdapter(mContext, list, this);
        binding.bsLipsBottom.lipsRecycler.setAdapter(lipsAdapter);
        lipsSheet.setState(BottomSheetBehavior.STATE_EXPANDED);

    }

    public void getEyeBrows() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired()
                .create(RestApiCalls.class);
        Call<EyeBrowsModel> call = service.getEyeBrowsImageList();
        call.enqueue(new Callback<EyeBrowsModel>() {
            @Override
            public void onResponse(Call<EyeBrowsModel> call, Response<EyeBrowsModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        eyeBrowsList(response.body().getPayload());

                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<EyeBrowsModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void eyeBrowsList(List<EyeBrowsModel.EyeBrowsDataModel> list) {
        EyeBrowAdapter eyeBrowAdapter = new EyeBrowAdapter(mContext, list, this);
        binding.bsEyebrow.eyebrowRecycler.setAdapter(eyeBrowAdapter);
        eyebrowsheet.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void getWrinkles() {
        ProgressDialog.showProgressBar(mContext);
        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
        Call<WrinkleModel> call = service.getWrinkle();
        call.enqueue(new Callback<WrinkleModel>() {
            @Override
            public void onResponse(Call<WrinkleModel> call, Response<WrinkleModel> response) {
                try {
                    if (response.code() == 200 && response.isSuccessful()) {
                        ProgressDialog.hideProgressBar();
                        clearWrinkles();
                        setDataForAllWrinkle(response.body());

                    } else if (response.code() == 400) {
                        ProgressDialog.hideProgressBar();
                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException exception) {
                    exception.getMessage();
                }
            }

            @Override
            public void onFailure(Call<WrinkleModel> call, Throwable t) {
                ProgressDialog.hideProgressBar();
                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDataForAllWrinkle(WrinkleModel body) {
        cheekWrinkles.addAll(body.getCheek_wrinkles());
        doubleChin.addAll(body.getDouble_chin());
        foreheadWrinkles.addAll(body.getForehead_wrinkles());
        lipsTopWrinkles.addAll(body.getLips_top_wrinkles());
        lipsNoseWrinkles.addAll(body.getLips_nose_wrinkles());
        eyesWrinkles.addAll(body.getEyes_wrinkles());
        lipsCornerWrinkles.addAll(body.getLips_corner_wrinkles());
        eyebrowWrinkles.addAll(body.getEyebrow_wrinkles());
    }

    private void clearWrinkles() {
        cheekWrinkles.clear();
        doubleChin.clear();
        foreheadWrinkles.clear();
        lipsTopWrinkles.clear();
        lipsNoseWrinkles.clear();
        eyesWrinkles.clear();
        lipsCornerWrinkles.clear();
        eyebrowWrinkles.clear();
    }

    public void getCheekWrinkle(List<CheekWrinkle> cheekWrinkles) {
        CheekWrinklesAdapter cheekWrinklesAdapter = new CheekWrinklesAdapter(mContext, cheekWrinkles, this);
        binding.bsCheekWrinkles.cheekWrinklesRecycler.setAdapter(cheekWrinklesAdapter);
        btCheekWrinkles.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void getDoubleChinWrinkle(List<DoubleChinWrinkle> doubleChin) {
        DoubleChinAdapter doubleChinAdapter = new DoubleChinAdapter(mContext, doubleChin, this);
        binding.bsDoubleChin.doubleChinRecycler.setAdapter(doubleChinAdapter);
        btDoubleChin.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private void getLipsCornerWrinkles(List<LipsCornerWrinkle> lipsCornerWrinkles) {
        LipsCornerAdapter lipsCornerWrinkle = new LipsCornerAdapter(mContext, lipsCornerWrinkles, this);
        binding.bsLipsCornerWrinkles.lipsCornerWrinklesRecycler.setAdapter(lipsCornerWrinkle);
        btLipsCornerWrinkles.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private void getLipsNoseWrinkles(List<LipsNoseWrinkle> lipsNoseWrinkles) {
        LipsNoseWrinkleAdapter lipsNoseWrinkleAdapter = new LipsNoseWrinkleAdapter(mContext, lipsNoseWrinkles, this);
        binding.bsLipsNoseWrinkle.lipsNoseWrinkleRecycler.setAdapter(lipsNoseWrinkleAdapter);
        btLipsNoseWrinkles.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private void getEyesWrinkles(List<EyesWrinkle> eyesWrinkles) {
        EyesWrinkleAdapter eyesWrinkleAdapter = new EyesWrinkleAdapter(mContext, eyesWrinkles, this);
        binding.bsEyesWrinkles.eyesWrinklesRecycler.setAdapter(eyesWrinkleAdapter);
        btEyesErinkles.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private void getLipsTopWrinkles(List<LipsTopWrinkle> lipsTopWrinkles) {
        LipsTopWrinklesAdapter lipsTopWrinklesAdapter = new LipsTopWrinklesAdapter(mContext, lipsTopWrinkles, this);
        binding.bsLipsTopWrinkle.lipsTopWrinklesRecycler.setAdapter(lipsTopWrinklesAdapter);
        btLipsTopWrinkles.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private void getForeHeadWrinkles(List<ForheadWrinkle> foreheadWrinkles) {
        ForeHeadChinWrinklesAdapter foreHeadChinWrinklesAdapter = new ForeHeadChinWrinklesAdapter(mContext, foreheadWrinkles, this);
        binding.bsForeHeadWrinkles.foreheadwrinklesRecycler.setAdapter(foreHeadChinWrinklesAdapter);
        btForeHeadChin.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void onIconSleected(HomeScreenMenuModel item) {
        switch (item.getTitle()) {
            case "EyeBrow":
                getEyeBrows();
                break;
            case "Eyes":
                getEyes();
                break;
            case "Noses":
                getNose();
                break;
            case "Lips":
                getLips();
                break;
            case "Faces":
                getFace(0);
                break;
            case "Eyes Wrinkles":
                getEyesWrinkles(eyesWrinkles);
                break;
            case "Cheek Wrinkles":
                getCheekWrinkle(cheekWrinkles);
                break;
            case "Double Chin":
                getDoubleChinWrinkle(doubleChin);
                break;
            case "Forehead Wrinkles":
                getForeHeadWrinkles(foreheadWrinkles);
                break;
            case "Lips Top Wrinkles":
                getLipsTopWrinkles(lipsTopWrinkles);
                break;

            case "Lips Nose Wrinkles":
                getLipsNoseWrinkles(lipsNoseWrinkles);
                break;
            case "Lips Corner Wrinkles":
                getLipsCornerWrinkles(lipsCornerWrinkles);
                break;
        }
    }

    @Override
    public void onEyeBrowSelected(EyeBrowsModel.EyeBrowsDataModel item) {
        eyebrowid = item.getEyeBrowId();
        binding.lefteyebrow.setVisibility(View.VISIBLE);
        binding.righteyeBrow.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/eyeBrows/" + item.getRightEyeBrow())
                .into(binding.lefteyebrow);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/eyeBrows/" + item.getLeftEyeBrow())
                .into(binding.righteyeBrow);
        lefteyebrowWM = "https://rldevelopment.in/makeup/public/uploads/eyeBrows/" + item.getLeftEyeBrowWithMakeUp();
        righteyeBrowWM = "https://rldevelopment.in/makeup/public/uploads/eyeBrows/" + item.getRightEyeBrowWithMakeUp();
        eyebrowsheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        Toast.makeText(mContext, "" + lefteyebrowWM, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEyeSelected(EyesModel.EyesDataModel item) {
        eyeid = item.getEyeId();
        binding.righteye.setVisibility(View.VISIBLE);
        binding.lefteye.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/eyes/" + item.getRightEyeImage())
                .into(binding.lefteye);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/eyes/" + item.getLeftEyeImage())
                .into(binding.righteye);
        lefteyeWM = "https://rldevelopment.in/makeup/public/uploads/eyes/" + item.getLeftEyeWithMakeUpImage();
        righteyeWM = "https://rldevelopment.in/makeup/public/uploads/eyes/" + item.getRightWithMakeUpImage();
        eyesheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onLipSelected(LipsModel.LipsDataModel item) {
        lipId = item.getLipId();
        binding.lips.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/lip/" + item.getLipImage())
                .into(binding.lips);
        lipsWM = "https://rldevelopment.in/makeup/public/uploads/lip/" + item.getLipImageWithMakeUp();
        lipsSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onNoseSelected(NoseModel.NoseDataModel item) {
        noseId = item.getNoseId();
        binding.nose.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/nose/" + item.getNoseImage())
                .into(binding.nose);
        noseWM = "https://rldevelopment.in/makeup/public/uploads/nose/" + item.getNoseImageWithMakeup();
        noseSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onFaceSelected(FaceModel.FaceDataModel item) {
        faceid = item.getFaceId();
        Glide.with(mContext).load("https://rldevelopment.in/makeup/public/uploads/face/" + item.getFaceImage()).into(binding.defaultFace);
        defaultFaceWM = "https://rldevelopment.in/makeup/public/uploads/face/" + item.getFaceImageWithMakeUp();

    }

    @Override
    public void onDoubleChinkWrinkles(DoubleChinWrinkle item) {
        doubleChinWrinkleId = item.getId();
        binding.ivDoubleChinWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivDoubleChinWrinkles);
        doubleChinWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getGetBefor_img_makeup();
        btDoubleChin.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onChickWrinkleSelected(CheekWrinkle item) {
        chickWrinkleId = item.getId();
        binding.ivLeftCheekWrinkles.setVisibility(View.VISIBLE);
        binding.ivRightCheekWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivLeftCheekWrinkles);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getAfter_img())
                .into(binding.ivRightCheekWrinkles);
        leftCheekWrinklesWM = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefor_img_makeup();
        rightCheekWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getAfter_img_makeup();
        btCheekWrinkles.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onLipsCornerSelected(LipsCornerWrinkle item) {
        binding.ivLipsLeftCornerWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivLipsLeftCornerWrinkles);
        leftLipsCornerWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefor_img_makeup();
        btLipsCornerWrinkles.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onLipsNoseWrinkle(LipsNoseWrinkle item) {
        binding.ivLipsNoseCornerWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivLipsNoseCornerWrinkles);
        lipsNoseWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefor_img_makeup();
        btLipsNoseWrinkles.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onLipsTopWrinkles(LipsTopWrinkle item) {
        binding.ivLipsTopCornerWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivLipsTopCornerWrinkles);
        lipsTopWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefor_img_makeup();
        btLipsTopWrinkles.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onForeHeadWrinkle(ForheadWrinkle item) {
        foreheadWrinklesId = item.getId();
        binding.ivForeHeadWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivForeHeadWrinkles);
        foreHeadWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefor_img_makeup();
        btForeHeadChin.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onEyesRinkleSelected(EyesWrinkle item) {
        binding.ivLeftEyeWrinkles.setVisibility(View.VISIBLE);
        binding.ivRightEyeWrinkles.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                .into(binding.ivLeftEyeWrinkles);
        Glide.with(mContext)
                .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getAfter_img_makeup())
                .into(binding.ivRightEyeWrinkles);
        leftEyeWrinklesWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefor_img_makeup();
        rightEyeWrinkleWm = "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getAfter_img_makeup();
        btEyesErinkles.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @SuppressLint("ClickableViewAccessibility")
    private View.OnTouchListener onTouchListener() {
        return (view, event) -> {

            final int x = (int) event.getRawX();
            final int y = (int) event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                            view.getLayoutParams();

                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    break;

                case MotionEvent.ACTION_UP:
                    break;

                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                            .getLayoutParams();
                    layoutParams.leftMargin = x - xDelta;
                    layoutParams.topMargin = y - yDelta;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    view.setLayoutParams(layoutParams);
                    break;
            }

            binding.editor.invalidate();
            return true;
        };
    }


}
