package com.ayush.contactroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.ayush.contactroom.R;
import com.ayush.contactroom.model.Contact;
import java.util.List;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {
    private Context context;
    private List<Contact> listLiveData;

    public RecyclerViewAdapter(Context context, List<Contact> listLiveData) {
        this.context = context;
        this.listLiveData = listLiveData;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Contact contact= Objects.requireNonNull(listLiveData.get(position));
        holder.name.setText(contact.getName());
        holder.occupation.setText(contact.getOccupation());
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(listLiveData.size());
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView name,occupation;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_name_textview);
            occupation=itemView.findViewById(R.id.row_occupation_textview);

        }
    }
}