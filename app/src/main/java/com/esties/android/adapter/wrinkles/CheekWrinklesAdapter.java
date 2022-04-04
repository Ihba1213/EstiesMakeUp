package com.esties.android.adapter.wrinkles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.esties.android.R;
import com.esties.android.model.CheekWrinkle;

import java.util.List;

public class CheekWrinklesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    public List<CheekWrinkle> mValues;
    public ItemListener mlistener;
    int selectedPosition = -1;

    public CheekWrinklesAdapter(@NonNull Context context, List<CheekWrinkle> values, ItemListener mListener) {
        mValues = values;
        mContext = context;
        mlistener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.eyebrow_datalayout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (selectedPosition == position) {
            //((HomeScreenItemAdapter.MyViewHolder)holder).icon.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.magenta));
        } else {
            // ((HomeScreenItemAdapter.MyViewHolder)holder).icon.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.black));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                notifyDataSetChanged();
                if (mlistener != null) {
                    mlistener.onChickWrinkleSelected(mValues.get(position));
                }

            }
        });
        ((MyViewHolder) holder).setData((CheekWrinkle) mValues.get(position));
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
        CheekWrinkle item;

        public MyViewHolder(View view) {
            super(view);
            before = view.findViewById(R.id.before);
            after = view.findViewById(R.id.after);
        }

        public void setData(CheekWrinkle item) {
            this.item = item;
            Log.d("TAGGED_URL", "setData: " +
                    "https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img());
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getBefore_img())
                    .into(before);
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/wrinkle/" + item.getAfter_img())
                    .into(after);
        }
    }

    public interface ItemListener {
        void onChickWrinkleSelected(CheekWrinkle item);
    }
}
