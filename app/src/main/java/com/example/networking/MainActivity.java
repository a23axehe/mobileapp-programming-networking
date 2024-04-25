package com.example.networking;


import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";
    private ArrayList<Mountain> parseJson(String json) {
        return null;
    }
    private RecyclerView.Adapter<RecyclerView.ViewHolder> recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        };
            new JsonFile(this, this).execute(JSON_FILE);

    }

    private void getJson(){
        new JsonTask(new JsonTask.JsonTaskListener() {
            @Override
            public void onPostExecute(String json) {
                try {
                    ArrayList<Mountain> mountainArrayList = parseJson(json);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });




    }




    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }

}
