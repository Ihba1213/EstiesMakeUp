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
import com.esties.android.model.LessonAfterAndBeforeImageList;
import com.esties.android.model.LessonSliderImagesList;

import java.util.List;

public class TopImageLessonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<LessonSliderImagesList> mValuesBottom;
    public Context mContext;
    public TopImageLessonAdapter(@NonNull Context context, List<LessonSliderImagesList> values) {

        mValuesBottom = values;
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lesson_makeup_data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData((LessonSliderImagesList) mValuesBottom.get(position));
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

        public ImageView lessonAfter;
        LessonSliderImagesList item;

        public MyViewHolder(View view) {
            super(view);
            lessonAfter = view.findViewById(R.id.lessonAfter);
        }

        public void setData(LessonSliderImagesList item) {
            this.item = item;
            Glide.with(mContext)
                    .load("https://rldevelopment.in/makeup/public/uploads/lessonGallery/"+item.getImage())
                    .into(lessonAfter);

        }
    }
}
