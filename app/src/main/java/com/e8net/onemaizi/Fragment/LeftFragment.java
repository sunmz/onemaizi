package com.e8net.onemaizi.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.e8net.onemaizi.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by maizi on 15/7/7.
 */

public class LeftFragment extends Fragment
{
    private View mView;
    private ListView mCategories;
    private List<String> mDatas = Arrays.asList("首页", "微博", "聊天", "发现", "我", "设置");
    private ListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        if (mView == null)
        {
            initView(inflater, container);
        }
        return mView;
    }

    private void initView(LayoutInflater inflater, ViewGroup container)
    {
        mView = inflater.inflate(R.layout.left_menu, container, false);
        mCategories = (ListView) mView
                .findViewById(R.id.id_listview_categories);
        mAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.left_menu_item, mDatas);
        mCategories.setAdapter(mAdapter);
    }
}

