package com.example.lesson7_homework;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EditFragment extends Fragment {
    private EditText name;
    private EditText description;
    private EditText date;
    private Button buttonSave;
    private boolean isLand;

    public static EditFragment newInstance(int position) {
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();
        args.putInt("key", position);
        fragment.setArguments(args);
        return fragment;
    }


    private void initView(View view) {
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
        date = view.findViewById(R.id.date);
        buttonSave = view.findViewById(R.id.button_save);

        buttonSave.setOnClickListener(v -> {
            ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).date = date.getText().toString();
            ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).description = description.getText().toString();
            ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).name = name.getText().toString();
            if (!isLand) {
                FragmentTransaction fragmentTr = getActivity().getSupportFragmentManager().beginTransaction();
                DetaileFragment dataFragment = DetaileFragment.newInstance(
                        ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).name,
                        ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).description,
                        ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).date,
                        getArguments().getInt("key")
                );
//                fragmentTr.addToBackStack("");
                fragmentTr.replace(R.id.Fr_container, dataFragment);
                fragmentTr.commit();
            } else {
                FragmentTransaction fragmentTr = getActivity().getSupportFragmentManager().beginTransaction();
                getActivity().findViewById(R.id.Fr_container2).setVisibility(View.VISIBLE);
                DetaileFragment dataFragment = DetaileFragment.newInstance(
                        ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).name,
                        ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).description,
                        ((MainActivity)getActivity()).list.get(getArguments().getInt("key")).date,
                        getArguments().getInt("key")
                );
                fragmentTr.replace(R.id.Fr_container2, dataFragment);
                fragmentTr.commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_fragmet, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            ///TODO
            name.setText(((MainActivity)getActivity()).list.get(getArguments().getInt("key")).name);
            description.setText(((MainActivity)getActivity()).list.get(getArguments().getInt("key")).description);
            date.setText(((MainActivity)getActivity()).list.get(getArguments().getInt("key")).date);

        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLand = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}