package com.endless.callmocam.adapter;

import com.endless.callmocam.activity.R;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PackageNameAdapter extends BaseAdapter {

    private String[] mName;
    private Context mContext;
    
    public PackageNameAdapter(Context ctx, String names) {
        if (!TextUtils.isEmpty(names)) {
            mName = names.split("!!");
            mContext = ctx;
        }
    }
    
    
    @Override
    public int getCount() {
        return mName.length;
    }

    @Override
    public Object getItem(int position) {
        return mName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_list_item_pkg_name, null);
        TextView tv = (TextView) convertView.findViewById(R.id.textView_pkg_name);
        tv.setText(mName[position]);
        return convertView;
    }

}
