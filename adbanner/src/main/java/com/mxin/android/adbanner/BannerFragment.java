package com.mxin.android.adbanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment {

    private int imgRes;


    public BannerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_banner, container, false);

        ImageView iv_banner = inflate.findViewById(R.id.iv_banner);
        iv_banner.setImageResource(imgRes);

        return inflate;
    }

    //设置一个广告资源接受的方法
    public void setImage(int imgRes){
        this.imgRes = imgRes;
    }

}
