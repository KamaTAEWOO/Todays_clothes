package com.example.todayclothes.myCodyPage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Image_adapter extends BaseAdapter {

    MyCodyPage ma = new MyCodyPage();

    private Context mContext;

    public Image_adapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return ma.MainImageArray.size();
    }

    @Override
    public Object getItem(int position) {
        return ma.MainImageArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(mContext);
        imageView.setImageBitmap(ma.MainImageArray.get(position));
        //imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setCropToPadding(true);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(340,350));
        return imageView;
    }
}
