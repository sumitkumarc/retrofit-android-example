package com.skyzone18.demo1stchoise.RestClient;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by kevalt on 22-04-2017.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("web_service.php?f=get_post_all_subcategory")
    Call<Responce> Getcatwisesubcat(@Field("cat_id") String catid);

    @GET("web_service.php?f=my_sub_category")
    Call<Responce> GetOffersubcategory();

}
