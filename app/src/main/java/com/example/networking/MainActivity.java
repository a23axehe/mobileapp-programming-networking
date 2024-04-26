package com.example.networking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    //private final String JSON_URL = "mountains.json";
    private final String JSON_FILE = "mountains.json";



    private RecyclerView.Adapter<RecyclerView.ViewHolder> recyclerAdapter;
    private final ArrayList<Mountain> mountainArrayList = new ArrayList<>();
    ArrayList<RecyclerViewItem> items = new ArrayList<>(Arrays.asList(
            new RecyclerViewItem("Matterhorn"),
            new RecyclerViewItem("Mont Blanc"),
            new RecyclerViewItem("Denali")
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this, items, new MyAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recyclerview1);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
        getJson();
    }
    private void getJson() {
        new JsonFile(this, this).execute(JSON_FILE);
    }
    private ArrayList<Mountain> parseJson(String json){
        ArrayList<Mountain> mountains = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("ID");
                String name = jsonObject.getString("name");
                String type = jsonObject.getString("type");
                String location = jsonObject.getString("location");
                int size = jsonObject.getInt("size");
                int cost = jsonObject.getInt("cost");
                JSONObject auxData = jsonObject.getJSONObject("auxdata");
                String wiki = auxData.getString("wiki");
                String imgUrl = auxData.optString("img", ""); // Use optString to handle optional img property
                Mountain mountain = new Mountain(id, name, type, location, size, cost, wiki, imgUrl);
                mountains.add(mountain);
            }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return mountains;

        }


    @Override
    public void onPostExecute(String json) {

    }
}






