package com.e8net.onemaizi.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e8net.onemaizi.R;
import com.e8net.onemaizi.base.BaseFragMent;

/**
 * Created by maizi on 15/7/8.
 */
public class MainFragMent extends BaseFragMent {
    private View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_main, container, false);

        return rootview;
    }
}
