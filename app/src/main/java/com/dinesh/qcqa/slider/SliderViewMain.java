package com.dinesh.qcqa.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.dinesh.qcqa.R;
import com.dinesh.qcqa.activity.NavigationDrawer;
import com.dinesh.qcqa.slider.SliderAdapter;
import com.dinesh.qcqa.slider.SliderModelClass;
import com.dinesh.qcqa.test.RvMainTest;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class SliderViewMain extends NavigationDrawer {
    TextView buy_now;

    Button btnOder;

    View bottomSheetLayout;


    private BottomSheetDialog orderBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.product_details);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.product_details, null, false);
        drawerLayout.addView(contentView, 0);


        buy_now = (TextView) findViewById(R.id.btn_buy_now);



        ArrayList<SliderModelClass> sliderModelClassArrayList = new ArrayList<>();

        SliderView sliderView = findViewById(R.id.product_detail_img);
//        SliderView sliderView = findViewById(R.id.product_detail_img);

        for (int i= 0;i<10;i++){
            sliderModelClassArrayList.add(new SliderModelClass("https://picsum.photos/50"+i));
        }

        SliderAdapter adapter = new SliderAdapter(this, sliderModelClassArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        sliderView.setSliderAdapter(adapter);

        sliderView.setScrollTimeInSec(3);

        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();



        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SliderViewMain.this, "gnhgbn", Toast.LENGTH_SHORT).show();

                //Current Layout id
                LinearLayout id_product_details =  findViewById(R.id.id_product_details);

                LayoutInflater layoutInflater = getLayoutInflater();

//                id_product_details.removeAllViewsInLayout();
                View view1 = layoutInflater.inflate(R.layout.layout_checkout_bottom_sheet,null);
                ImageView imageView = view1.findViewById(R.id.order_product_img);
                ConstraintLayout c = view1.findViewById(R.id.c);
                c.removeView(view1);
                id_product_details.addView(view1);


//
//                Intent intent = new Intent(getApplicationContext(), RvMainTest.class);
//                startActivity(intent);



            }
        });
    }
}
