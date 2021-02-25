package com.example.lesson7_homework;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class NotesListFragment extends Fragment {

    ArrayList<NoteDataClass> list;
    boolean isLand;

    public NotesListFragment() {
        list = new ArrayList<>();
        list.add(new NoteDataClass("Заметки дня1", "Описание заметки дня 1", "17.01.2021"));
        list.add(new NoteDataClass("Заметки дня2", "Описание заметки дня 2", "16.01.2021"));
        list.add(new NoteDataClass("Заметки дня3", "Описание заметки дня 3", "15.01.2021"));

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotesListFragment newInstance() {
        NotesListFragment fragment = new NotesListFragment();
        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLand = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new MyNoteDataClassRecyclerViewAdapter(list, this));
        }
        return view;

    }

    public void onClickListItem(int position) {
        if (!isLand) {
            FragmentTransaction fragmentTr = getActivity().getSupportFragmentManager().beginTransaction();
            DetaileFragment dataFragment = DetaileFragment.newInstance(
                    list.get(position).name,
                    list.get(position).description,
                    list.get(position).date
            );
            fragmentTr.addToBackStack("");
            fragmentTr.replace(R.id.Fr_container, dataFragment);
            fragmentTr.commit();
        } else {
            FragmentTransaction fragmentTr = getActivity().getSupportFragmentManager().beginTransaction();
            getActivity().findViewById(R.id.Fr_container2).setVisibility(View.VISIBLE);
            DetaileFragment dataFragment = DetaileFragment.newInstance(
                    list.get(position).name,
                    list.get(position).description,
                    list.get(position).date
            );
            fragmentTr.replace(R.id.Fr_container2, dataFragment);
            fragmentTr.commit();
        }
    }
}