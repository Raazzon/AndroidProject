package com.example.razzon.sdpp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageSlider extends PagerAdapter {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image_slider);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    //}

    //    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return false;
//
    private int[] imageResources = {R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5};
    private Context context;
    private LayoutInflater layoutInflater;

    public ImageSlider(Context c) {
        context = c;
    }

    @Override
    public int getCount() {

        return imageResources.length;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.activity_image_slider, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        TextView textView = (TextView) itemView.findViewById(R.id.imageCount);
        imageView.setImageResource(imageResources[position]);
        textView.setText("Image Counter :" + position);
        container.addView(itemView);
        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == object);
    }
}
