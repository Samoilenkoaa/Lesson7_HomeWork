package com.example.lesson7_homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DetaileFragment extends Fragment {
    TextView name;
    TextView description;
    TextView date;


    public static com.example.lesson7_homework.DetaileFragment newInstance(String name, String description, String date) {
        com.example.lesson7_homework.DetaileFragment fragment = new com.example.lesson7_homework.DetaileFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("description", description);
        args.putString("date", date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detaile, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
        date = view.findViewById(R.id.date);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null){
            name.setText(getArguments().getString("name"));
            description.setText(getArguments().getString("description"));
            date.setText(getArguments().getString("date"));

        }
    }
}