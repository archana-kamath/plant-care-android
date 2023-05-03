package com.sjsu.cmpe295b.pc_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.sjsu.cmpe295b.pc_node.model.NodeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.jvm.internal.TypeReference;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button addNode;
    GridView nodeGV;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    ArrayList<NodeModel> nodeList = new ArrayList<NodeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNode = (Button) findViewById(R.id.addNode);
        addNode.setOnClickListener(this);

        nodeGV = findViewById(R.id.gridIdNode);

        getNodeDetails();
        NodeAdapter adapter = new NodeAdapter(this, nodeList );
        nodeGV.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
//            case R.id.viewNode:
//                Log.i("MainActivity","Pressed the node view button");
//                Toast.makeText(MainActivity.this, "View Nodes !!", Toast.LENGTH_LONG).show();
//                getNodeDetails();
//                break;
            case R.id.addNode:
                Log.i("MainActivity","Pressed the node add button");
                Toast.makeText(MainActivity.this, "Add Node !!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, AddNodeActivity.class);
                startActivity(i);
                break;
        }
    }

    private void getNodeDetails() {
        mRequestQueue = Volley.newRequestQueue(this);

      String project_id = "9e28bc84-714c-4223-a58c-6873ed4067d5";
        String url = "https://o1hd2bxh00.execute-api.us-east-1.amazonaws.com/dev/node/listNode?name="+project_id;
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArr = new JSONArray(response);

                    for (int i = 0; i < jsonArr.length(); i++) {

                        JSONObject jsonObj = jsonArr.getJSONObject(i);
                        NodeModel data = new NodeModel();
                        data.setNode_id(jsonObj.getString("node_id"));
                        data.setProject_id(jsonObj.getString("project_id"));
                        data.setUser_id(jsonObj.getString("user_id"));
                        data.setPlant_type(jsonObj.getString("plant_type"));
                        data.setMoisture_threshold(jsonObj.getString("moisture_threshold"));
                        data.setHumidity_threshold(jsonObj.getString("humidity_threshold"));
                        data.setTemperature_threshold(jsonObj.getString("temperature_threshold"));
                        data.setLatitude(jsonObj.getString("latitude"));
                        data.setLongitude(jsonObj.getString("longitude"));
                        Log.i("data",data.toString());
                        nodeList.add(data);

                    }
                    Log.i("node len", String.valueOf(nodeList.size()));
                    NodeAdapter adapter = new NodeAdapter(MainActivity.this, nodeList );
                    nodeGV.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("JSON node response",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("MainActivity","Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
        return;
    }

}