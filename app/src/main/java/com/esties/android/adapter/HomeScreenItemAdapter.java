package com.esties.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.esties.android.R;
import com.esties.android.model.HomeScreenMenuModel;

import java.util.List;

public class HomeScreenItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    public List<HomeScreenMenuModel> mValues;
    public ItemListener mlistener;
    int selectedPosition = -1;
    public HomeScreenItemAdapter(@NonNull Context context, List<HomeScreenMenuModel> values,ItemListener mListener) {

        mValues = values;
        mContext = context;
        mlistener = mListener;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.homescreen_data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (selectedPosition == position){
            ((MyViewHolder)holder).icon.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.magenta));
        }else {
            ((MyViewHolder)holder).icon.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.black));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                notifyDataSetChanged();
                if (mlistener != null) {
                    mlistener.onIconSleected(mValues.get(position));
                }

            }
        });
        ((MyViewHolder) holder).setData((HomeScreenMenuModel) mValues.get(position));
    }

    @Override
    public int getItemCount() {
        if (mValues == null) {
            return 0;
        } else {
            return mValues.size();
        }
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView menu_item_name;
        public ImageView icon;

        HomeScreenMenuModel item;
        public MyViewHolder(View view) {
            super(view);
            menu_item_name = view.findViewById(R.id.menu_text);
            icon = view.findViewById(R.id.menu_icon_image);
        }
        public void setData(HomeScreenMenuModel item){
            this.item = item;
            menu_item_name.setText(item.getTitle());
            Glide.with(mContext).load(item.getImage_icon()).apply(RequestOptions.circleCropTransform().placeholder(item.getImage_icon())).into(icon);
        }
    }
    public interface ItemListener {
        void onIconSleected(HomeScreenMenuModel item);
    }
}
