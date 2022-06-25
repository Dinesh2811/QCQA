package com.dinesh.qcqa.z;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.qcqa.R;
import com.dinesh.qcqa.activity.NavigationDrawer;
import com.dinesh.qcqa.api.ApiMain;
import com.dinesh.qcqa.api.model.ApiModel;
import com.dinesh.qcqa.rv.RvMain;

import java.util.List;

public class MainActivity extends NavigationDrawer {
    private static final String TAG = "log_MainActivity_z";
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<ApiModel> dataList;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.z_rv_search_activity_main);

        toolbar = findViewById(R.id.toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.z_rv_search_activity_main, null, false);
        drawerLayout.addView(contentView, 0);


        dataList = ApiMain.bodytest;

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(dataList);
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        Log.i(TAG, "onCreate: "+ RvMain.Rvquery);
        recyclerAdapter.getFilter().filter(RvMain.Rvquery);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_search:


                        SearchView searchView = (SearchView) item.getActionView();
                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {

                                Log.i(TAG, "onQueryTextChange: typing");
                                recyclerAdapter.getFilter().filter(newText);
                                return false;
                            }
                        });



                        break;
                }
                return false;
            }
        });
    }

}
