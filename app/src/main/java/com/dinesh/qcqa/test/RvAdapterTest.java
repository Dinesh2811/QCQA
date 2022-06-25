package com.dinesh.qcqa.test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.qcqa.R;

import java.util.ArrayList;
import java.util.List;

public class RvAdapterTest extends RecyclerView.Adapter<RvAdapterTest.MyViewHolder> {
    private static final String TAG = "log_RvAdapterTest";

    List<RvModelTest> rvModelTestList = new ArrayList<>();
    RvInterfaceTest rvInterfaceTest;

    public RvAdapterTest(List<RvModelTest> rvModelTestList, RvInterfaceTest rvInterfaceTest) {
        this.rvModelTestList = rvModelTestList;
        this.rvInterfaceTest = rvInterfaceTest;
    }

    public RvAdapterTest(List<RvModelTest> rvModelTestList) {
        this.rvModelTestList = rvModelTestList;
    }

    public RvAdapterTest() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chechout, parent, false);
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_rv_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.textView.setText(rvModelTestList.get(position).id);
//        holder.textView2.setText(rvModelTestList.get(position).name);
//        holder.textView3.setText(rvModelTestList.get(position).email);
//        holder.textView4.setText(rvModelTestList.get(position).mobile);
    }

    @Override
    public int getItemCount() {
        return rvModelTestList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView textView, textView2, textView3, textView4;
        EditText edt_order_quantity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            textView = itemView.findViewById(R.id.test_textView1);
//            textView2 = itemView.findViewById(R.id.test_textView2);
//            textView3 = itemView.findViewById(R.id.test_textView3);
//            textView4 = itemView.findViewById(R.id.test_textView4);
            edt_order_quantity = itemView.findViewById(R.id.edt_order_quantity);

//itemView doesn't work if layout has scroll view or card view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String passData[] ={String.valueOf(edt_order_quantity.getText())};
                    //Calling Interface method & Passing Values
                    rvInterfaceTest.onItemClick(v, getAdapterPosition(),passData);
                    Log.i(TAG, "onClick: "+edt_order_quantity.getText());
                }
            });
        }
    }
}
