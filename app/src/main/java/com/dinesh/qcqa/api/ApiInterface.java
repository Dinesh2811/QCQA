package com.dinesh.qcqa.api;

import com.dinesh.qcqa.api.model.ApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
//    http://localhost:80/products
//    http://localhost/products

    String url = "products";

    @GET(url)
    Call<List<ApiModel>> getModelAsList();

}
