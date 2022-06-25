package com.dinesh.qcqa.api;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dinesh.qcqa.R;
import com.dinesh.qcqa.activity.CheckInternetConnection;
import com.dinesh.qcqa.rv.RvMain;
import com.dinesh.qcqa.api.model.ApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiMain extends AppCompatActivity {
    private static final String TAG = "log_ApiMain";
    public static List<ApiModel> bodytest;


    ApiInterface apiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ApiMain 2");

        new CheckInternetConnection(this).checkInternetConnection();
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);


        Intent intent = new Intent(getApplicationContext(), RvMain.class);
        startActivity(intent);
        getModelAsList();
    }

    public void getModelAsList() {
        Call<List<ApiModel>> call = apiInterface.getModelAsList();
        call.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                Log.i(TAG, "onResponse: " + response.code());

                bodytest = response.body();

//                testMethod1(response.code());
                testMethod2();
                testMethod3(response);


                Intent intent = new Intent(getApplicationContext(), RvMain.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
                Intent intent = new Intent(getApplicationContext(), RvMain.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void testMethod3(Response<List<ApiModel>> response) {
        Log.i(TAG, "testMethod3: "+response.code());
    }

    public static List<ApiModel> testMethod2() {
////        Log.i(TAG, "testMethod2: "+body);
//        List<ApiModel> bodytest = body;
        Log.i(TAG, "testMethod2: "+bodytest);
        return bodytest;
    }

//    public void testMethod1(int code) {
//        Log.i(TAG, "testMethod2: "+code);
//    }
}
