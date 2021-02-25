package com.example.lesson7_homework;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
//        Bundle args = new Bundle();
//
//        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}