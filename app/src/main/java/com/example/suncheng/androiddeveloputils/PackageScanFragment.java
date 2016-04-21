package com.example.suncheng.androiddeveloputils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bean.AppInfo;

import java.util.List;

/**
 * Created by suncheng on 2016/4/17.
 */
public class PackageScanFragment extends Fragment {
    private List<AppInfo> mList;
    private ListView mListView;

    public void setData(List<AppInfo> list) {
        mList = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        mListView = (ListView) root.findViewById(R.id.package_scan_listview);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PackageScanAdapter adapter = new PackageScanAdapter(getActivity(), mList);
        if(mListView != null) {
            mListView.setAdapter(adapter);
        }
    }
}
