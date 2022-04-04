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
import com.esties.android.model.AboutusDataModel;
import com.esties.android.model.BottomImageModel;
import com.esties.android.model.TopImageModel;

import java.util.List;

public class TopImageListAboutUsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    public List<TopImageModel> mValues;
    public TopImageListAboutUsAdapter(@NonNull Context context, List<TopImageModel> values) {

        mValues = values;
        mContext = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.top_list_about_data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData((TopImageModel) mValues.get(position));
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
        TopImageModel item;

        public MyViewHolder(View view) {
            super(view);
            viewpagerImage = view.findViewById(R.id.imageView);
        }

        public void setData(TopImageModel item) {
            this.item = item;
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/aboutGallery/"+item.getImage())
                    .into(viewpagerImage);

        }
    }

}
