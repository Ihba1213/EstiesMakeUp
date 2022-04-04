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
import com.esties.android.model.HomeBannerList;
import com.esties.android.model.HomeScreenMenuModel;
import com.esties.android.model.TopImageModel;

import java.util.List;

public class HomeScreenBannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    public List<HomeBannerList> mValues;
    public HomeScreenBannerAdapter(Context context,List<HomeBannerList> values) {
        this.context = context;
        this.mValues = values;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData((HomeBannerList) mValues.get(position));
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

        public ImageView viewpagerImage;
        HomeBannerList item;

        public MyViewHolder(View view) {
            super(view);
            viewpagerImage = view.findViewById(R.id.image);
        }

        public void setData(HomeBannerList item) {
            this.item = item;
            Glide.with(context)
                    .load("https://rldevelopment.in/makeup/public/uploads/banner/"+item.getBannerImage())
                    .into(viewpagerImage);

        }
    }
}
