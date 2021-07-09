package com.ayush.parsedata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
TextView textView;
String url="https://www.google.com";
String apiUrl="https://jsonplaceholder.typicode.com/todos";
String objectApiUrl="https://jsonplaceholder.typicode.com/todos/1";
    //RequestQueue queue;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        requestQueue=MySingleton.getInstance(this).getRequestQueue();
        //queue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, objectApiUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    textView.setText(response.getString("title"));
                    Log.d("jsonObj",response.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("jsonObj","Failed");
            }
        });
        requestQueue.add(jsonObjectRequest);
        //queue.add(jsonObjectRequest);
        //getJsonArrayRequest();
        //getString(queue);
    }

    private void getJsonArrayRequest() {
        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, apiUrl, null, response ->
        {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject=response.getJSONObject(i);

                    Log.d("JSON",jsonObject.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        },error -> Log.d("JSON","Failed"));
       // queue.add(jsonObjectRequest);
    }

    /*private void getString(RequestQueue queue) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, response -> Log.d("MainData",response.substring(0,500)), new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MainData","Failed to get info");
            }
        });
        queue.add(stringRequest);
    }*/
}