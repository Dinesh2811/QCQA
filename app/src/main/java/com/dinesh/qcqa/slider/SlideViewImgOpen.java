package com.dinesh.qcqa.slider;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.dinesh.qcqa.R;
import com.dinesh.qcqa.activity.NavigationDrawer;

public class SlideViewImgOpen extends NavigationDrawer {

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.slide_view_img_open);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.slide_view_img_open, null, false);
        drawerLayout.addView(contentView, 0);

        imageView = findViewById(R.id.SA_imageView);
        String imgUrl = getIntent().getExtras().getString("imgUrl");

        Glide.with(this)
                .load(imgUrl)
                .fitCenter()
                .into(imageView);
    }
}
