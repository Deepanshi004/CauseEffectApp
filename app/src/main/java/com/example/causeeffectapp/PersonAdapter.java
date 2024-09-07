package com.example.causeeffectapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private final List<Person> people;
    private final OnItemClickListener listener;


    public interface OnItemClickListener{
        void onItemClick(Person person,int position);
    }

    public PersonAdapter(List<Person> people,OnItemClickListener listener){
        this.people =people;
        this.listener= listener;
    }
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person,parent,false);
        return new PersonViewHolder(view);
    }

    public void onBindViewHolder(@NonNull PersonViewHolder holder,int position) {
        Person person = people.get(position);
        Log.d("PersonAdapter", "Binding person at position " + position + ": " + person.getName());
        holder.namesTextView.setText(person.getName());
        holder.itemView.setOnClickListener(view -> listener.onItemClick(person,position));

    }

    public int getItemCount(){
        return people.size();
    }


    static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView namesTextView;

        public PersonViewHolder(View itemView) {
            super(itemView);
            namesTextView = itemView.findViewById(R.id.person_name);

        }
    }
}
