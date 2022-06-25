package com.dinesh.qcqa.activity;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.Toast;

import com.dinesh.qcqa.R;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

public class CheckInternetConnection{

    Context ctx;

    public CheckInternetConnection(Context context){
        ctx=context;
    }

    public void checkInternetConnection(){

        if(!isInternetConnected()) {
            FancyAlertDialog.Builder
                    .with(ctx)
                    .setTitle("Check your Internet")
                    .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                    .setMessage("Do you really want to Exit ?")
                    .setNegativeBtnText("Cancel")
                    .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                    .setPositiveBtnText("Ok")
                    .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                    .setAnimation(Animation.POP)
                    .isCancellable(true)
                    .setIcon(R.drawable.ic_baseline_signal_cellular_connected_no_internet_4_bar_24, View.VISIBLE)
                    .onPositiveClicked(dialog -> Toast.makeText(ctx, "Ok", Toast.LENGTH_SHORT).show())
                    .onNegativeClicked(dialog -> Toast.makeText(ctx, "Cancel", Toast.LENGTH_SHORT).show())
                    .build()
                    .show();
        }
    }

    private boolean isInternetConnected() {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isConnectedOrConnecting();

    }
}


/**
*
*
*    //     Check Internet
*    //     new CheckInternetConnection(this).checkInternetConnection();
*
*
*/
