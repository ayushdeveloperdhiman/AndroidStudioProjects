package com.ayush.sendingdatafromfragmentstoactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MyFirstFragment extends Fragment {
    EditText name,email;
    Button send;
    public MyFirstFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_first,container,false);
        name=view.findViewById(R.id.editTextName);
        email=view.findViewById(R.id.editTextEmail);
        send=view.findViewById(R.id.buttonSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.takeData(name.getText().toString(),email.getText().toString());
            }
        });
        return view;
    }
}