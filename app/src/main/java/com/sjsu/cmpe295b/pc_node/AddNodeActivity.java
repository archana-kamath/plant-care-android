package com.sjsu.cmpe295b.pc_node;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class AddNodeActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText plant_type;
    private EditText moisture_threshold;
    private EditText temperature_threshold;
    private EditText humidity_threshold;
    private EditText latitude;
    private EditText longitude;

    Button nodeSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_node);

        plant_type = (EditText) findViewById(R.id.plantType);
        moisture_threshold = (EditText) findViewById(R.id.moistureThreshold);
        temperature_threshold = (EditText) findViewById(R.id.temperatureThreshold);
        humidity_threshold = (EditText) findViewById(R.id.humidityThreshold);
        latitude = (EditText) findViewById(R.id.latitude);
        longitude = (EditText) findViewById(R.id.longitude);
        nodeSubmit = (Button) findViewById(R.id.nodeSubmit);
        nodeSubmit.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.nodeSubmit:
                Log.i("MainActivity","Pressed the node submit button");
                Toast.makeText(AddNodeActivity.this, "Node data submitted !!", Toast.LENGTH_LONG).show();
                //submitNodeData();
                sendJsonPostRequest();
                break;
        }
    }

    private void sendJsonPostRequest(){

        try {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("user_id", "mobile_user");
            jsonParams.put("project_id", "mobile_project");
            jsonParams.put("node_id", java.util.UUID.randomUUID().toString());
            jsonParams.put("plant_type",plant_type.getText().toString());
            jsonParams.put("moisture_threshold",moisture_threshold.getText().toString());
            jsonParams.put("temperature_threshold",temperature_threshold.getText().toString());
            jsonParams.put("humidity_threshold",humidity_threshold.getText().toString());
            jsonParams.put("latitude",latitude.getText().toString());
            jsonParams.put("longitude", longitude.getText().toString());
            String postNode = "https://o1hd2bxh00.execute-api.us-east-1.amazonaws.com/dev/node";
            Log.i("request parameter",String.valueOf(jsonParams));
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,postNode,
                    jsonParams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(AddNodeActivity.this, "Node data submitted !!", Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("MainActivity","Error response");
                        }
                    });

            Volley.newRequestQueue(getApplicationContext()).add(request);
            Log.i("MainActivity","Button press");

        } catch(Exception ex){
            Log.e("MainActivity","Error response");
        }
    }
}