package com.example.todayclothes.myCloset;

import android.graphics.Bitmap;

public class GridItem1 {

    public GridItem1(Bitmap a_imageResId) {
        mImageResId = a_imageResId;

    }

    private final Bitmap mImageResId;


    public Bitmap getImageResId() {
        return mImageResId;
    }
}


