package com.example.darazfourthassign.api;

public interface UserAPI {
    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @GET("users/me")
    Call<Users> getUserDetails(@Header("Authorization") String token);
}

