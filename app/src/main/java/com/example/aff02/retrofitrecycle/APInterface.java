package com.example.aff02.retrofitrecycle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by AFF02 on 12-Sep-17.
 */

public interface APInterface {

    String BASE_URL = "http://27.109.20.118/SilverPixelz/api/categories/";

    @Headers("Content-Type: application/json")
    @GET("4/products")
    Call<RetrofitModel> getData();
}
