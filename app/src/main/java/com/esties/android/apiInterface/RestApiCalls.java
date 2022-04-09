package com.esties.android.apiInterface;

import com.esties.android.model.AboutusModel;
import com.esties.android.model.EyeBrowsModel;
import com.esties.android.model.EyesModel;
import com.esties.android.model.FaceModel;
import com.esties.android.model.FinalImageModel;
import com.esties.android.model.FinalMakeupModel;
import com.esties.android.model.GalleryModel;
import com.esties.android.model.LessonsModel;
import com.esties.android.model.LipsModel;
import com.esties.android.model.NoseModel;
import com.esties.android.model.WrinkleModel;

import retrofit2.Call;
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
    Call<FinalMakeupModel> getFinalMakeUpImage(@Query("face_id") int faceid, @Query("type") int type, @Query("eye_id") int eye,
                                               @Query("eye_brows_id") int eye_brows_id, @Query("nose_id") int nose_id,
                                               @Query("lip_id") int lip_id, @Query("chin") int chin, @Query("cheek") int cheek,
                                               @Query("forhead") int forhead,


                                               @Query("language") String language,
                                               @Query("lips_nose_wrinkles_id") int lips_nose_wrinkles_id,
                                               @Query("double_chin_id") int double_chin_id,
                                               @Query("eyebrow_wrinkle_id") int eyebrow_wrinkle_id,
                                               @Query("lips_corner_wrinkles_id") int lips_corner_wrinkles_id,
                                               @Query("forehead_wrinkle_id") int forehead_wrinkle_id,
                                               @Query("cheek_wrinkles_id") int cheek_wrinkles_id,
                                               @Query("eye_wrinkles_id") int eye_wrinkles_id,
                                               @Query("lips_top_wrinkles_id") int lips_top_wrinkles_id);


}
