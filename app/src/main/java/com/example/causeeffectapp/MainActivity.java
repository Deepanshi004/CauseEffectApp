package com.example.causeeffectapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnItemClickListener {
    private TextView name;
    private TextView address;
    private TextView telephone;
    private TextView birthday;
    private PersonAdapter adapter;

    private List<Person> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        telephone=findViewById(R.id.telephone);
        birthday=findViewById(R.id.birthday);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         people=new ArrayList<>();
         people.add(new Person("John Doe", "123 Elm St", "Springfield", "IL", "USA", "555-1234", "1990-01-01"));
         people.add(new Person("Jane Smith", "456 Oak St", "Metropolis", "NY", "USA", "555-5678", "1985-05-15"));
         people.add(new Person("Emily Johnson", "789 Pine St", "Gotham", "NJ", "USA", "555-8765", "1992-09-30"));

         adapter =new PersonAdapter(people,this);
        recyclerView.setAdapter(adapter);

    }

    public void onItemClick (Person person,int position) {

        person.setName(person.getName()+" ");
        adapter.notifyItemChanged(position);
        name.setText(person.getName());
        address.setText(String.format("%s,%s,%s,%s", person.getStreet(),person.getCity(),person.getState(),person.getCountry()));
        telephone.setText(person.getTelephone());
        birthday.setText(person.getBirthday());

    }
}
