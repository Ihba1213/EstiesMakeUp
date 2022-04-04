package com.esties.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.esties.android.R;
import com.esties.android.model.GalleryModel;
import com.esties.android.model.TopImageModel;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    public List<GalleryModel.GalleryDataModel> mValues;
    public GalleryAdapter(@NonNull Context context,List<GalleryModel.GalleryDataModel> values) {

        mValues = values;
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.gallery_data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData((GalleryModel.GalleryDataModel) mValues.get(position));
    }

    @Override
    public int getItemCount() {
        if (mValues == null) {
            return 0;
        } else {
            return mValues.size();
        }
    }
    private class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView before,after;
        GalleryModel.GalleryDataModel item;

        public MyViewHolder(View view) {
            super(view);

            before = view.findViewById(R.id.before);
            after = view.findViewById(R.id.after);
        }

        public void setData(GalleryModel.GalleryDataModel item) {
            this.item = item;
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/before/"+item.getBeforeImage())
                    .into(before);
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/after/"+item.getAfterImages())
                    .into(after);

        }
    }
}
