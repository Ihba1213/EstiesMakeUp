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
import com.esties.android.model.EyesModel;
import com.esties.android.model.FaceModel;

import java.util.List;

public class FaceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context mContext;
    public List<FaceModel.FaceDataModel> mValues;
    public ItemListener mlistener;
    int selectedPosition = -1;
    public FaceAdapter(@NonNull Context context, List<FaceModel.FaceDataModel> values, ItemListener mListener) {

        mValues = values;
        mContext = context;
        mlistener = mListener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.facedatalayout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0){
            //((HomeScreenItemAdapter.MyViewHolder)holder).icon.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.magenta));
        }else {
            // ((HomeScreenItemAdapter.MyViewHolder)holder).icon.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.black));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                notifyDataSetChanged();
                if (mlistener != null) {
                    mlistener.onFaceSelected(mValues.get(position));
                }

            }
        });
        ((MyViewHolder) holder).setData((FaceModel.FaceDataModel) mValues.get(position));
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

        public ImageView before;
        FaceModel.FaceDataModel item;

        public MyViewHolder(View view) {
            super(view);

            before = view.findViewById(R.id.face);

        }

        public void setData(FaceModel.FaceDataModel item) {
            this.item = item;
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/face/"+item.getFaceImage())
                    .into(before);


        }
    }
    public interface ItemListener {
        void onFaceSelected( FaceModel.FaceDataModel item);
    }
}
