package com.example.stan_mode.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.stan_mode.R;
import com.example.stan_mode.custom.CustomAdapter;

import java.util.Objects;

public class ManFragment extends Fragment {

    int[] pictureList = {R.drawable.menclothes1,R.drawable.menclothes2,R.drawable.menclothes3,R.drawable.menclothes4,R.drawable.menclothes5,R.drawable.menclothes6};
    String[] listName = {"T-Shirt", "Sweatshirt", "Hoodie", "Jacket", "Pants", "Socks"};
    ListView listView;

    public static ManFragment newInstance() {
        return new ManFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_man, container, false);
        listView = view.findViewById(R.id.list_view);
        CustomAdapter customAdapter = new CustomAdapter(requireActivity(), pictureList,listName);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            int imageId = pictureList[position];
            String name = listName[position];

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            DetailFragment fragment = DetailFragment.newInstance(imageId, name);
            transaction.replace(R.id.frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
        return view;
    }


}