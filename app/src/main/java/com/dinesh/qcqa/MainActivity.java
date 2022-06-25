package com.dinesh.qcqa;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dinesh.qcqa.activity.CheckInternetConnection;
import com.dinesh.qcqa.activity.NavigationDrawer;
import com.dinesh.qcqa.activity.signin.SignInHome;
import com.dinesh.qcqa.api.ApiMain;
import com.dinesh.qcqa.slider.SliderViewMain;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends NavigationDrawer {
    private static final String TAG = "log_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: MainActivity 1");

//        Check Internet
        new CheckInternetConnection(this).checkInternetConnection();

        Toolbar toolbar = findViewById(R.id.toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_main, null, false);
        drawerLayout.addView(contentView, 0);

//        Intent intent = new Intent(getApplicationContext(),GoogleSignInActivity.class);
//        Intent intent = new Intent(getApplicationContext(),SignInHome.class);
//        startActivity(intent);

//        Intent intent = new Intent(getApplicationContext(), SliderViewMain.class);
//            Intent intent = new Intent(getApplicationContext(), ApiMain.class);
//        startActivity(intent);
        finish();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            new CheckInternetConnection(this).checkInternetConnection();

//            Intent intent = new Intent(getApplicationContext(), Home.class);
            Intent intent = new Intent(getApplicationContext(), ApiMain.class);
//            Intent intent = new Intent(getApplicationContext(), SliderViewMain.class);
            startActivity(intent);
        } else {
            new CheckInternetConnection(this).checkInternetConnection();
            Intent intent = new Intent(getApplicationContext(), SignInHome.class);
            startActivity(intent);
        }

    }

}