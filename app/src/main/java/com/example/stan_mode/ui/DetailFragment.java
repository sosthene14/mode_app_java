package com.example.stan_mode.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stan_mode.R;

public class DetailFragment extends Fragment {
    private static final String ARG_IMAGE_ID = "image_id";
    private static final String ARG_NAME = "name";

    private int mImageId;
    private String mName;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(int imageId, String name) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_ID, imageId);
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImageId = getArguments().getInt(ARG_IMAGE_ID);
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail_fragment, container, false);

        ImageView imageView = view.findViewById(R.id.detail_image_view);
        TextView textView = view.findViewById(R.id.detail_text_view);
        imageView.setImageResource(mImageId);
        textView.setText(mName);

        return view;
    }
}
