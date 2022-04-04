package com.esties.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.esties.android.R;
import com.esties.android.model.BottomImageModel;
import com.esties.android.model.BottomProductModel;
import com.esties.android.model.TopImageModel;

import java.util.List;

public class BottomImageHomeScreenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<BottomProductModel> mValuesBottom;
    public Context mContext;
    public BottomImageHomeScreenAdapter(@NonNull Context context, List<BottomProductModel> values) {

        mValuesBottom = values;
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_image_homedata_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData((BottomProductModel) mValuesBottom.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(mValuesBottom.get(position).getProductLink()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mContext.startActivity(intent);
            }
        });
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

        public ImageView imageBottom;
        public TextView productName,productPrice;
        BottomProductModel item;

        public MyViewHolder(View view) {
            super(view);
            imageBottom = view.findViewById(R.id.imageBottom);
            productName = view.findViewById(R.id.productName);
            productPrice = view.findViewById(R.id.productPrice);
        }

        public void setData(BottomProductModel item) {
            this.item = item;
            Glide.with(mContext)
                    .load(item.getProductImage())
                    .into(imageBottom);
            productName.setText(item.getProductName());
            productPrice.setText(item.getProductPrice());

        }
    }
}
