package com.example.todayclothes.myCloset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.todayclothes.R;

import java.util.List;

public class GridArrayAdapter1 extends ArrayAdapter<GridItem1> {
    private static final int LAYOUT_RESOURCE_ID = R.layout.activity_my_closet1_grid;

    private final Context mContext;
    private final List<GridItem1> mItemList;

    public GridArrayAdapter1(Context a_context, List<GridItem1> a_itemList) {
        super(a_context, LAYOUT_RESOURCE_ID, a_itemList);

        mContext = a_context;
        mItemList = a_itemList;
    }

    @Override
    public View getView(int a_position, View a_convertView, ViewGroup a_parent) {
        GridItemViewHolder1 viewHolder;
        if (a_convertView == null) {
            a_convertView = LayoutInflater.from(mContext).inflate(LAYOUT_RESOURCE_ID, a_parent, false);

            viewHolder = new GridItemViewHolder1(a_convertView);
            a_convertView.setTag(viewHolder);
        } else {
            viewHolder = (GridItemViewHolder1) a_convertView.getTag();
        }

        final GridItem1 countryItem = mItemList.get(a_position);

        // Icon 설정
        viewHolder.ivIcon.setImageBitmap(countryItem.getImageResId());

        return a_convertView;
    }
}

