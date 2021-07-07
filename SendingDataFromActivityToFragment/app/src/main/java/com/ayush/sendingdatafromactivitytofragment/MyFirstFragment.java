package com.ayush.sendingdatafromactivitytofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFirstFragment extends Fragment {
TextView result;
    public MyFirstFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_first, container, false);
        result=view.findViewById(R.id.textViewResult);
        Bundle bundle=getArguments();
        int weight=bundle.getInt("weight");
        int height=bundle.getInt("height");
        double bmi=(weight*1000)/(height*height);
        result.setText("Your Bmi is "+bmi);
        return view;
    }
}