package com.example.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class Fragment_Example extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("Fragment","onCreateView");
        return inflater.inflate(R.layout.fragment_new,container,false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("Fragment","onAttach");
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment","onCreate");
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Fragment","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Fragment","onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Fragment","onStop");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Fragment","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Fragment","onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Fragment","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Fragment","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Fragment","onDetach");
    }
}
