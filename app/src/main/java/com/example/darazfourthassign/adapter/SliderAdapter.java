package com.example.darazfourthassign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.darazfourthassign.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private int count;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView).load(R.drawable.d2).into(viewHolder.imageSlideBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView).load(R.drawable.d3).into(viewHolder.imageSlideBackground);
                break;
            default:
                Glide.with(viewHolder.itemView).load(R.drawable.slider1).into(viewHolder.imageSlideBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return count;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageSlideBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageSlideBackground = itemView.findViewById(R.id.img_slider);
            this.itemView = itemView;
        }
    }
}
