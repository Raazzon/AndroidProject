package com.example.razzon.smarthealthpredictor;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageSlider extends PagerAdapter {

    private int [] imageResources ={R.drawable.download,R.drawable.d,R.drawable.e,R.drawable.images,R.drawable.one};
    private Context context;
    private LayoutInflater layoutInflater;

    public HomePageSlider(Context c) {
        context=c;
    }

    @Override
    public int getCount() {

        return imageResources.length;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.activity_home_page_slider,container,false);
        ImageView imageView=(ImageView) itemView.findViewById(R.id.image_view);
        TextView textView=(TextView) itemView.findViewById(R.id.imageCount);
        imageView.setImageResource(imageResources[position]);
        textView.setText("Image Counter :"+position);
        container.addView(itemView);
        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return  (view==object);
    }

//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return false;
//    }
}

