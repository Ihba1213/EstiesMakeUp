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
import com.esties.android.model.BottomImageModel;
import com.esties.android.model.TopImageModel;

import java.util.List;

public class BottomImageListAboutUsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<BottomImageModel> mValuesBottom;
    public Context mContext;
    public BottomImageListAboutUsAdapter(@NonNull Context context, List<BottomImageModel> values) {

        mValuesBottom = values;
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_list_about_data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData((BottomImageModel) mValuesBottom.get(position));
    }

    @Override
    public int getItemCount() {
        if (mValuesBottom == null) {
            return 0;
        } else {
            return mValuesBottom.size();
        }
    }
    private class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView viewpagerImage;
        BottomImageModel item;

        public MyViewHolder(View view) {
            super(view);
            viewpagerImage = view.findViewById(R.id.imageView);
        }

        public void setData(BottomImageModel item) {
            this.item = item;
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/aboutGallery/"+item.getImage())
                    .into(viewpagerImage);

        }
    }

}
