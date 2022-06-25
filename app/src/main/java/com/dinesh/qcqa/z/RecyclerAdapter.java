package com.dinesh.qcqa.z;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.qcqa.R;
import com.dinesh.qcqa.api.model.ApiModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "log_RecyclerAdapter";
    List<ApiModel> dataList;
    List<ApiModel> dataListAll;

    public RecyclerAdapter(List<ApiModel> dataList) {
        this.dataList = dataList;
        dataListAll = new ArrayList<>();
        dataListAll.addAll(dataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.z_rv_search_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.rowCountTextView.setText(String.valueOf(position));

        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(dataList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public Filter getFilter() {

        return myFilter;
    }

    Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<ApiModel> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(dataListAll);
            } else {
                for (ApiModel movie: dataListAll) {
                    if (movie.title.toLowerCase().contains(charSequence.toString().toLowerCase())
                            | movie.category.toLowerCase().contains(charSequence.toString().toLowerCase())
                    ) {
                        filteredList.add(movie);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dataList.clear();
            dataList.addAll((Collection<? extends ApiModel>) filterResults.values);
            notifyDataSetChanged();
        }
    };



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView, rowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Log.i(TAG, "onClick: "+ dataList.get(getAdapterPosition()));
        }
    }
}






