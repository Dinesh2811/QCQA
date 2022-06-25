package com.dinesh.qcqa.slider;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dinesh.qcqa.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {
    private static final String TAG = "log_SliderAdapter";

    List<SliderModelClass> sliderModelClassList;

    public SliderAdapter(Context context, ArrayList<SliderModelClass> sliderModelClassArrayList) {
        this.sliderModelClassList = sliderModelClassArrayList;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
//        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.test, null);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

        Glide.with(viewHolder.itemView)
                .load(sliderModelClassList.get(position).getImgUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SlideViewImgOpen.class);
                intent.putExtra("imgUrl",sliderModelClassList.get(position).getImgUrl());
                Log.i(TAG, "onClick: "+sliderModelClassList.get(position).getImgUrl());
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getCount() {
        return sliderModelClassList.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
//            imageViewBackground = itemView.findViewById(R.id.product_detail_img);
            imageViewBackground = itemView.findViewById(R.id.product_img);
            this.itemView = itemView;

        }
    }
}