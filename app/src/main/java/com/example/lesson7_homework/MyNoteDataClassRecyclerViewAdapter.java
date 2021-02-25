package com.example.lesson7_homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MyNoteDataClassRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteDataClassRecyclerViewAdapter.ViewHolder> {

    private ArrayList<NoteDataClass> mValues;
    NotesListFragment fragment;

    public MyNoteDataClassRecyclerViewAdapter(ArrayList<NoteDataClass> items, NotesListFragment fragment) {
        this.fragment = fragment;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.name.setText(mValues.get(position).name);
        holder.date.setText(mValues.get(position).date);
        holder.itemView.setOnClickListener(v -> {
            fragment.onClickListItem(position);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView date;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.item_name);
            date = view.findViewById(R.id.item_date);

        }

    }
}