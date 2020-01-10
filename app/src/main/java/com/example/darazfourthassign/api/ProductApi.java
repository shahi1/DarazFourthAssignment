package com.example.darazfourthassign.api;

import com.example.darazfourthassign.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("product/list")
    Call<List<Products>> getProduct();
}
