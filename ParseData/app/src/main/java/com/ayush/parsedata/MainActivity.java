package com.ayush.parsedata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

String url="https://www.google.com";
String apiUrl="https://jsonplaceholder.typicode.com/todos";
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, apiUrl, null, response -> Log.d("JSON",response.toString().substring(0,500)), error -> Log.d("JSON","Failed"));
        queue.add(jsonObjectRequest);
        getString(queue);
    }

    private void getString(RequestQueue queue) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, response -> Log.d("MainData",response.substring(0,500)), new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MainData","Failed to get info");
            }
        });
        queue.add(stringRequest);
    }
}