package com.dinesh.qcqa;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;

import com.dinesh.qcqa.activity.NavigationDrawer;


public class Home extends NavigationDrawer {
    private static final String TAG = "log_Home";

    TextView textView3;
//    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_page);

//        Toolbar toolbar = findViewById(R.id.toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.home_page, null, false);
        drawerLayout.addView(contentView, 0);
        textView3 = findViewById(R.id.textView3);


        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: ");
            }
        });
    }
}