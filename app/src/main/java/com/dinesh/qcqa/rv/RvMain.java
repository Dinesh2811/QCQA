package com.dinesh.qcqa.rv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.qcqa.activity.CheckInternetConnection;
import com.dinesh.qcqa.activity.NavigationDrawer;
import com.dinesh.qcqa.R;
import com.dinesh.qcqa.activity.PaymentActivity;
import com.dinesh.qcqa.z.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class RvMain extends NavigationDrawer implements RvClickInterface {
    private static final String TAG = "log_Rv_Main";

    RecyclerView recyclerView;
    ParentAdapter parentAdapter;
    List<ParentModelClass> parentModelClassList = new ArrayList<>();
    List<ChildModelClass> childModelClassList = new ArrayList<>();

    public static String Rvquery;

    List<ChildModelClass> favList = new ArrayList<>();
    List<ChildModelClass> recentList = new ArrayList<>();
    List<ChildModelClass> latestList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.rv_main);

        new CheckInternetConnection(this).checkInternetConnection();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.rv_main, null, false);
        drawerLayout.addView(contentView, 0);

        recyclerView = findViewById(R.id.rv_parent);

//        for (int i = 0; i < 50; i++) {
//            latestList.add(new ChildModelClass("https://picsum.photos/" + (i + 250)));
//            recentList.add(new ChildModelClass("https://picsum.photos/" + (i + 300)));
//            favList.add(new ChildModelClass("https://picsum.photos/" + (i + 350)));
//        }
//
//        parentModelClassList.add(new ParentModelClass("Latest Movies", latestList));
//        parentModelClassList.add(new ParentModelClass("Recent Movies", recentList));
//        parentModelClassList.add(new ParentModelClass("Favorite Movies", favList));
//        parentAdapter = new ParentAdapter(parentModelClassList, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(parentAdapter);


        parentAdapter = new ParentAdapter(RvData.getRvData().getRvDataList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(parentAdapter);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu1:
                        Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_search:

                        SearchView searchView = (SearchView) item.getActionView();
                        searchView.hasFocus();
                        searchView.getInputType();
                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                Rvquery = query;
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(RvMain.this, query, Toast.LENGTH_SHORT).show();
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {

//                                Toast.makeText(NavigationDrawer.this, "searching 123...", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        });



                        break;
                }
                return false;
            }
        });



    }

    //    Parent onOnClickListener (using Interface)
    @Override
    public void onItemClick(View view, int position) {
//        Log.i(TAG, "Parent OnClickListener: parentRvPosition = " + position);
    }
}
