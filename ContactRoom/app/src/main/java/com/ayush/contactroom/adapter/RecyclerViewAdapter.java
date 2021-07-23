package com.ayush.contactroom.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.ayush.contactroom.R;
import com.ayush.contactroom.model.Contact;
import com.ayush.contactroom.model.ContactViewModel;

import java.util.List;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {
    private Context context;
    private List<Contact> listLiveData;
    private OnContactClickListener onContactClickListener;

    public RecyclerViewAdapter(Context context, List<Contact> listLiveData,OnContactClickListener onContactClickListener) {
        this.context = context;
        this.listLiveData = listLiveData;
        this.onContactClickListener=onContactClickListener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new Viewholder(view,onContactClickListener);
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

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name,occupation;
        OnContactClickListener onContactClickListener;
        public Viewholder(@NonNull View itemView,OnContactClickListener onContactClickListener) {
            super(itemView);
            name=itemView.findViewById(R.id.row_name_textview);
            occupation=itemView.findViewById(R.id.row_occupation_textview);
            this.onContactClickListener=onContactClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            onContactClickListener.onContactClick(getAdapterPosition());
        }
    }

    public interface OnContactClickListener {
        void onContactClick(int position);
    }
}