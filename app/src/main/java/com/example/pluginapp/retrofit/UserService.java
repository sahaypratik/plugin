package com.example.pluginapp.retrofit;

import com.example.pluginapp.model.RespDialogData;
import com.example.pluginapp.model.RespSelector;
import com.example.pluginapp.model.RespUiData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UserService {

   /* @GET("BAsQJTxVKjgyDGxm")
    Call<List<RespUiData>> fetchUiData(@Query("tableName") String tableName);*/

    @POST
    Call<List<RespUiData>> fetchUiData(@Url String tableName);

    @GET
    Call<List<RespDialogData>> fetchDialogData(@Url String tableName);

    @GET
    Call<List<RespSelector>> fetchSelector(@Url String tableName);
}
