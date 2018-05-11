package com.mxin.android.viewpager_fuction.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mxin.android.viewpager_fuction.R;
import com.mxin.android.viewpager_fuction.entity.HomeIconInfo;

import java.util.ArrayList;
import java.util.List;

public class MyGrideAdapter extends BaseAdapter {

        private List<HomeIconInfo> itemData = new ArrayList<>();
        private Context mContext;

    public MyGrideAdapter(List<HomeIconInfo> itemData, Context context) {
        this.itemData = itemData;
        mContext = context;
    }

    @Override
        public int getCount() {
            return itemData.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View inflate = LayoutInflater.from(mContext).inflate(R.layout.gride_item, null);
            ImageView imageView = inflate.findViewById(R.id.iv);
            imageView.setImageResource(itemData.get(i).getIconID());
            TextView textView = inflate.findViewById(R.id.tv);
            textView.setText(itemData.get(i).getIconName());


            return inflate;
        }
    }