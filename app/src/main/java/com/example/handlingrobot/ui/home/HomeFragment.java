package com.example.handlingrobot.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.handlingrobot.R;
import com.example.handlingrobot.ui.locate.Locate;
import com.example.handlingrobot.ui.request.GalleryFragment;
import com.example.handlingrobot.ui.scan.SlideshowFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //button to switch to request
        Button requestButton = (Button)root.findViewById(R.id.req_button);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new GalleryFragment());
                fr.commit();
            }
        });
        //button to switch to scan fragment
        Button scanButton = (Button)root.findViewById(R.id.scan_button);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new SlideshowFragment());
                fr.commit();
            }
        });
        //button to switch to locate fragment
        Button locateButton = (Button)root.findViewById(R.id.locate_button);
        locateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new Locate());
                fr.commit();
            }
        });

        return root;
    }
}