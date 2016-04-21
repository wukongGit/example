package com.example.suncheng.androiddeveloputils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suncheng on 2016/4/17.
 */
public class PackageScanAdapter extends BaseAdapter {
    private Context mContext;
    private List<AppInfo> mList = new ArrayList<AppInfo>();

    public PackageScanAdapter(Context context, List<AppInfo> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.package_list_item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.info = (TextView) convertView.findViewById(R.id.info);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        AppInfo info = mList.get(position);
        holder.img.setImageDrawable(info.getIcon());
        holder.title.setText(info.getAppName());
        holder.info.setText(info.getPackageName());

        return convertView;
    }

    static class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView info;
    }
}
