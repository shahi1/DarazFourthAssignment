package com.example.darazfourthassign.bll;

import com.example.darazfourthassign.api.UserAPI;
import com.example.darazfourthassign.serverresponse.SignUpResponse;
import com.example.darazfourthassign.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;


public class LoginBll {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

        UserAPI usersAPI = Url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(username, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}

