package com.example.stan_mode.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stan_mode.R;

public class CustomAdapter extends BaseAdapter {
    int[] mImageIds;
    String[] mlistName;
    Context mContext;

    public CustomAdapter(Context context, int[] imageIds, String[] listName) {
        mlistName = listName;
        mContext = context;
        mImageIds = imageIds;
    }
    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_list_view, parent, false);
            imageView = convertView.findViewById(R.id.listImage);
            textView = convertView.findViewById(R.id.listName);
        } else {
            imageView = convertView.findViewById(R.id.listImage);
            textView = convertView.findViewById(R.id.listName);
        }

        imageView.setImageResource(mImageIds[position]);
        textView.setText(mlistName[position]);
        return convertView;
    }

}
