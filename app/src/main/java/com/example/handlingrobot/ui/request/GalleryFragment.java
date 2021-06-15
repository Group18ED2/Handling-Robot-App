package com.example.handlingrobot.ui.request;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.handlingrobot.R;
import com.example.handlingrobot.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputLayout;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    private TextInputLayout textInputLayout;

    private AutoCompleteTextView autoCompleteTextView;

    String robotname;
    String stationname;
    String prioritylevel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        //add robot options
        textInputLayout = root.findViewById(R.id.menu1);
        autoCompleteTextView = root.findViewById(R.id.auto_menu1);
        String[] robot_name = new String[]{
          "Robot S",
          "Robot 3",
          "Robot X",
          "Robot Y",
        };
        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if Item selected
                robotname = (String) parent.getItemAtPosition(position);
//                Toast.makeText(getContext(), position, Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing
            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(requireContext(), R.layout.list_items, robot_name);
        autoCompleteTextView.setAdapter(adapter1);

        //Station
        textInputLayout = root.findViewById(R.id.menu2);
        autoCompleteTextView = root.findViewById(R.id.auto_menu2);
        String[] station_name = new String[]{
                "Docking Station",
                "Front Door",
                "Side Door",
                "Back Door",
        };
        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if Item selected
                stationname = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing
            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(requireContext(), R.layout.list_items, station_name);
        autoCompleteTextView.setAdapter(adapter2);

        //Priority
        textInputLayout = root.findViewById(R.id.menu3);
        autoCompleteTextView = root.findViewById(R.id.auto_menu3);
        String[] priority = new String[]{
                "High",
                "Medium",
                "Low",
        };
        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if Item selected
                prioritylevel = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing
            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(requireContext(), R.layout.list_items, priority);
        autoCompleteTextView.setAdapter(adapter3);

        //button on click
        Button reqButton = (Button)root.findViewById(R.id.request);
        reqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //once on click
                //show text for now
                //need to get variable

                Toast.makeText(getContext(), "Request Added!", Toast.LENGTH_SHORT).show();
                //take to dashboard again
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new HomeFragment());
                fr.commit();


            }
        });
        return root;
    }
}
