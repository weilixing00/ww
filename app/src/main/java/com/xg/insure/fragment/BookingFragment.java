package com.xg.insure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xg.insure.R;
import com.xg.insure.base.BaseFragment;

/**
 * Created by server on 2016/6/22.
 * 理财中的预约页面
 */

public class BookingFragment extends BaseFragment {


    public static  BookingFragment newInstance(){
        BookingFragment bookingFragment=new BookingFragment();
        return bookingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_booking,container,false);
        return view;
    }
}
