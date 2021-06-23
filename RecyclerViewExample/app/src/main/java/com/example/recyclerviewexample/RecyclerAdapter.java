package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.countryViewHolder> {
    private ArrayList<String> countryName;
    private ArrayList<String> countryNameDetails;
    private ArrayList<Integer> imagelist;
    private Context context;

    public RecyclerAdapter(ArrayList<String> countryName, ArrayList<String> countryNameDetails, ArrayList<Integer> imagelist, Context context) {
        this.countryName = countryName;
        this.countryNameDetails = countryNameDetails;
        this.imagelist = imagelist;
        this.context = context;
    }


    @Override
    public countryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new countryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.countryViewHolder holder, int position) {
        holder.textViewCountryNameDetails.setText(countryName.get(position));
        holder.textViewCountryNameDetails.setText(countryNameDetails.get(position));
        holder.imageView.setImageResource(imagelist.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You selected "+countryName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryName.size();
    }

    public class countryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName, textViewCountryNameDetails;
        private ImageView imageView;
        private CardView cardView;

        public countryViewHolder(View itemView) {
            super(itemView);
            textViewCountryName = itemView.findViewById(R.id.countryName);
            textViewCountryNameDetails = itemView.findViewById(R.id.textViewDetail);
            imageView = itemView.findViewById(R.id.imageView);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
