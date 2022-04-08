package com.esties.android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.bumptech.glide.Glide;
import com.esties.android.apiInterface.RestApiCalls;
import com.esties.android.model.FinalImageDataModel;
import com.esties.android.model.FinalImageModel;
import com.esties.android.network.RetrofitInstance;
import com.esties.android.utility.ProgressDialog;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalMakeUpActivity extends AppCompatActivity {
    private ImageView lefteyebrow, righteyeBrow, lefteye, righteye, nose, lips, defaultFace,
            ivForeHeadWrinkle, ivLeftEyeWrinkle, rightEyeWrinkle, leftChinWrinkle,
            noseWrinkle, rightChinWrinkle, lipsWrinkle, doubleChinWrinkle;
    private Context mContext;
    private TextView Nose, NoseDesc, Eye, Eyedesc, Eyebrow, EyebrowDesc, Lip, LipDesc, Face, facedesc,cheekdesc,chindesc,
    forheaddesc;
    private LinearLayout Noselayout, Eyelayout, Eyebrowlayout, Liplayout, facelayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalmakeup);
        mContext = this;
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initView();
        getDataFromIntent();
    }

    private void initView() {
        lefteyebrow = findViewById(R.id.lefteyebrow);
        righteyeBrow = findViewById(R.id.righteyeBrow);
        lefteye = findViewById(R.id.lefteye);
        righteye = findViewById(R.id.righteye);
        //chindesc = findViewById(R.id.chindesc);
        //forheaddesc = findViewById(R.id.forheaddesc);
        nose = findViewById(R.id.nose);
       // cheekdesc = findViewById(R.id.cheekdesc);
        lips = findViewById(R.id.lips);
        Nose = findViewById(R.id.Nose);
        NoseDesc = findViewById(R.id.NoseDesc);
        Eye = findViewById(R.id.Eye);
        Eyedesc = findViewById(R.id.Eyedesc);
        Eyebrow = findViewById(R.id.Eyebrow);
        EyebrowDesc = findViewById(R.id.EyebrowDesc);
        Lip = findViewById(R.id.Lip);
        LipDesc = findViewById(R.id.LipDesc);
        Face = findViewById(R.id.Face);
        facedesc = findViewById(R.id.facedesc);
        defaultFace = findViewById(R.id.defaultFace);
        facelayout = findViewById(R.id.facelayout);
        Noselayout = findViewById(R.id.Noselayout);
        Eyelayout = findViewById(R.id.Eyelayout);
        Eyebrowlayout = findViewById(R.id.Eyebrowlayout);
        Liplayout = findViewById(R.id.Liplayout);

        //WrinkleIntialized
        ivForeHeadWrinkle = findViewById(R.id.fore_headwrinkle);
        ivLeftEyeWrinkle = findViewById(R.id.left_eye_wrinkle);
        rightEyeWrinkle = findViewById(R.id.right_eye_wrinkle);
        leftChinWrinkle = findViewById(R.id.left_chin_wrinkle);
        noseWrinkle = findViewById(R.id.nose_wrinkle);
        rightChinWrinkle = findViewById(R.id.right_chin_wrinkle);
        lipsWrinkle = findViewById(R.id.lips_wrinkle);
        doubleChinWrinkle = findViewById(R.id.double_chin_wrinkle);
    }

    private void getDataFromIntent() {
        String ss = getIntent().getStringExtra("defaultFaceWM");
        if (getIntent().getStringExtra("defaultFaceWM") != null) {
            Glide.with(mContext).load(ss).into(defaultFace);
        } else {

        }
        if (getIntent().getStringExtra("foreHeadWrinklesWm") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("foreHeadWrinklesWm")).into(ivForeHeadWrinkle);

        } else {
            ivForeHeadWrinkle.setVisibility(View.INVISIBLE);
        }
        if (getIntent().getStringExtra("lefteyebrowWM") != null) {
            Log.d("data", "getDataFromIntent: " + getIntent().getStringExtra("lefteyebrowWM"));
            Glide.with(mContext).load(getIntent().getStringExtra("lefteyebrowWM")).into(righteyeBrow);

        } else {
            lefteyebrow.setVisibility(View.INVISIBLE);
        }
        if (getIntent().getStringExtra("righteyeBrowWM") != null) {
            Log.d("data", "getDataFromIntent: " + getIntent().getStringExtra("righteyeBrowWM"));
            Glide.with(mContext).load(getIntent().getStringExtra("righteyeBrowWM")).into(lefteyebrow);

        } else {
            righteyeBrow.setVisibility(View.INVISIBLE);
        }
        if (getIntent().getStringExtra("righteyeWM") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("righteyeWM")).into(lefteye);

        } else {
            lefteye.setVisibility(View.INVISIBLE);
        }
        if (getIntent().getStringExtra("lefteyeWM") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("lefteyeWM")).into(righteye);

        } else {
            righteye.setVisibility(View.INVISIBLE);
        }
//
        if (getIntent().getStringExtra("noseWM") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("noseWM")).into(nose);

        } else {
            nose.setVisibility(View.INVISIBLE);
        }
        if (getIntent().getStringExtra("lipsWM") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("lipsWM")).into(lips);

        } else {
            lips.setVisibility(View.INVISIBLE);
        }
        if (getIntent().getStringExtra("lipsTopWrinklesWm") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("lipsTopWrinklesWm")).into(lipsWrinkle);
        } else {
            lipsWrinkle.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("leftCheekWrinklesWM") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("leftChinWrinkle")).into(leftChinWrinkle);

        } else {
            leftChinWrinkle.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("rightCheekWrinklesWm") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("rightCheekWrinklesWm")).into(rightChinWrinkle);

        } else {
            rightChinWrinkle.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("doubleChinWrinklesWm") != null) {
            Log.d("DOUBLECHIN", "getDataFromIntent: " + getIntent().getStringExtra("doubleChinWrinklesWm"));
            Glide.with(mContext).load(getIntent().getStringExtra("doubleChinWrinklesWm")).into(doubleChinWrinkle);

        } else {
            doubleChinWrinkle.setVisibility(View.GONE);
        }
//
        if (getIntent().getStringExtra("leftEyeBrowWrinkleWm") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("leftEyeBrowWrinkleWm")).into(ivLeftEyeWrinkle);

        } else {
            ivLeftEyeWrinkle.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("rightEyeBrowWrinkleWm") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("leftEyeWrinklesWm")).into(rightEyeWrinkle);

        } else {
            rightEyeWrinkle.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("noseWrinkleWm") != null) {
            Glide.with(mContext).load(getIntent().getStringExtra("rightEyeWrinkleWm")).into(noseWrinkle);

        } else {
            noseWrinkle.setVisibility(View.GONE);
        }
//        finalMakeUpImage(getIntent().getIntExtra("lipId", 0), getIntent().getIntExtra("noseId", 0), getIntent().getIntExtra("lefteyeid", 0),
//                getIntent().getIntExtra("lefteyebrowid", 0), getIntent().getIntExtra("faceid", 0),getIntent().getIntExtra("cheek", 0),getIntent().getIntExtra("chin", 0),getIntent().getIntExtra("forhead", 0));

    }

//    public void finalMakeUpImage(int lipid, int noseid, int eyyid, int eyebroid, int faceid,int chinID,int cheekID,int forhead) {
//        ProgressDialog.showProgressBar(mContext);
//        RestApiCalls service = RetrofitInstance.getRetrofitInstanceBeforeAuthToekenNotRequired().create(RestApiCalls.class);
//        Call<FinalImageModel> call = service.getFinalMakeUpImage(faceid, 1, eyyid, eyebroid,
//                noseid, lipid, chinID,cheekID,forhead,((MyApp) this.getApplication()).getLanguageType());
//        call.enqueue(new Callback<FinalImageModel>() {
//            @Override
//            public void onResponse(Call<FinalImageModel> call, Response<FinalImageModel> response) {
//                try {
//                    if (response.code() == 200 && response.isSuccessful()) {
//                        ProgressDialog.hideProgressBar();
//                        onCall(response.body().getPayload());
//
//
//                    } else if (response.code() == 400) {
//                        ProgressDialog.hideProgressBar();
//                        Toast.makeText(mContext, "Something Went Wrong", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (NullPointerException exception) {
//                    exception.getMessage();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<FinalImageModel> call, Throwable t) {
//                ProgressDialog.hideProgressBar();
//                Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void onCall(List<FinalImageDataModel> finalImageDataModels) {
        if (finalImageDataModels.get(0).getEyeBrowContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getEyeBrowContentList().get(0).getDescription();
            EyebrowDesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            Eyebrowlayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getNoseContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getNoseContentList().get(0).getDescription();
            NoseDesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            Noselayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getEyesContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getEyesContentList().get(0).getDescription();
            Eyedesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            Eyelayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getFaceContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getFaceContentList().get(0).getDescription();
            facedesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            facelayout.setVisibility(View.GONE);
        }
        if (finalImageDataModels.get(0).getLipsContentList().size() > 0) {
            String ss = finalImageDataModels.get(0).getLipsContentList().get(0).getDescription();
            LipDesc.setText(HtmlCompat.fromHtml(ss, 0));

        } else {
            Liplayout.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
