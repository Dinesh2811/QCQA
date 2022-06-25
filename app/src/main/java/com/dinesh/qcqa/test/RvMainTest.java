package com.dinesh.qcqa.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.qcqa.R;

import java.util.ArrayList;
import java.util.List;

public class RvMainTest extends AppCompatActivity implements RvInterfaceTest {
    private static final String TAG = "log_RvMainTest";

    List<RvModelTest> rvModelTestList = new ArrayList<>();
    RvAdapterTest rvAdapterTest;
    RecyclerView recyclerView;
    Button checkoutBuyNow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_rv_main);
        recyclerView = findViewById(R.id.test_recyclerView);
        checkoutBuyNow = findViewById(R.id.checkoutBuyNow);

//sample Model data
//        for (int i = 0; i < 50; i++) {
//            rvModelTestList.add(new RvModelTest("" + i, "Dinesh" + i, "dk" + i + "@gmail.com", "866" + i));
//        }

        rvModelTestList.add(new RvModelTest());
        rvModelTestList.add(new RvModelTest());
        rvModelTestList.add(new RvModelTest());
        rvModelTestList.add(new RvModelTest());
        rvModelTestList.add(new RvModelTest());
        rvModelTestList.add(new RvModelTest());

        rvAdapterTest = new RvAdapterTest(rvModelTestList, RvMainTest.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(rvAdapterTest);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        checkoutBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i(TAG, "onClick: "+);
            }
        });
    }

    //OnClickListner Using Interface
    @Override
    public void onItemClick(View view, int position, String[] passData) {
//        Intent intent = new Intent(this, NewLayoutTest.class);
//        intent.putExtra("ID", rvModelTestList.get(position).id);
//        intent.putExtra("NAME", rvModelTestList.get(position).name);
//        intent.putExtra("Email", rvModelTestList.get(position).name);
//        intent.putExtra("Mobile", rvModelTestList.get(position).email);
//        startActivity(intent);

        Log.i(TAG, "onClick: "+passData);
        Toast.makeText(this, "njnj", Toast.LENGTH_SHORT).show();

    }
}
