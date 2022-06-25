package com.dinesh.qcqa;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.dinesh.qcqa.activity.NavigationDrawer;

public class NewActivity extends NavigationDrawer {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.new_activity);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.new_activity, null, false);
        drawerLayout.addView(contentView, 0);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);


        String intentImgUrl = getIntent().getStringExtra("ImgUrl");
        String intentTitle = getIntent().getStringExtra("Title");

        Glide.with(this)
                .load(intentImgUrl)
                .into(imageView);

        textView.setText(intentTitle);


    }
}
