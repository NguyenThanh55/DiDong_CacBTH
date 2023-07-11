package com.example.farmmarket.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.farmmarket.Domain.SlideItem;
import com.example.farmmarket.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;

public class SlideAdaptor extends RecyclerView.Adapter<SlideAdaptor.SlideViewHolder>{
    private List<SlideItem> slideItems;
    private ViewPager2 viewPager2;

    public SlideAdaptor(List<SlideItem> slideItems, ViewPager2 viewPager2) {
        this.slideItems = slideItems;
        this.viewPager2 = viewPager2;
    }


    @NonNull
    @Override
    public SlideAdaptor.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
        holder.setImage(slideItems.get(position));
        if (position == slideItems.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slideItems.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;

        public SlideViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (RoundedImageView) itemView.findViewById(R.id.imageSlide);
        }

        void setImage(SlideItem slideItem) {

            // Can put code here using glide or piccaso
            imageView.setImageResource(slideItem.getImage());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideItems.addAll(slideItems);
            notifyDataSetChanged();
        }
    };
}
