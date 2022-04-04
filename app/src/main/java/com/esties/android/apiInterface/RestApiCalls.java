package com.esties.android.apiInterface;

import com.esties.android.model.AboutusModel;
import com.esties.android.model.EyeBrowsModel;
import com.esties.android.model.EyesModel;
import com.esties.android.model.FaceModel;
import com.esties.android.model.FinalImageDataModel;
import com.esties.android.model.FinalImageModel;
import com.esties.android.model.GalleryModel;
import com.esties.android.model.LessonsModel;
import com.esties.android.model.LipsModel;
import com.esties.android.model.NoseModel;
import com.esties.android.model.WrinkleModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApiCalls {
    @GET("api/getAllAboutDataList")
    Call<AboutusModel> getList(@Query("language") String language);

    @GET("api/getHomeDataList")
    Call<AboutusModel> getHomeBanner(@Query("language") String language);

    @GET("api/getGalleryData")
    Call<GalleryModel> getGalleryImage(@Query("language") String language);

    @GET("api/getEyeImageList")
    Call<EyesModel> getEyeImageList();

    @GET("api/getFaceImageList")
    Call<FaceModel> getFaceImageList();

    @GET("api/getLipImageList")
    Call<LipsModel> getLipsImageList();

    @GET("api/getEyeBrowsImageList")
    Call<EyeBrowsModel> getEyeBrowsImageList();

    @GET("api/getNoseImageList")
    Call<NoseModel> getNoseBrowsImageList();

    @GET("api/getLessonData")
    Call<LessonsModel> getLessonData(@Query("language") String language);

    @GET("api/wrinkles")
    Call<WrinkleModel> getWrinkle();

    @GET("api/getModelImageDescription")
    Call<FinalImageModel> getFinalMakeUpImage(@Query("face_id") int faceid, @Query("type") int type, @Query("eye_id") int eye,
                                              @Query("eye_brows_id") int eye_brows_id, @Query("nose_id") int nose_id,
                                              @Query("lip_id") int lip_id, @Query("chin") int chin, @Query("cheek") int cheek, @Query("forhead") int forhead, @Query("language") String language);

}
