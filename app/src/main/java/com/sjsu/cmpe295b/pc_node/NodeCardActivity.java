package com.sjsu.cmpe295b.pc_node;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.sjsu.cmpe295b.pc_node.model.NodeModel;

import java.util.ArrayList;

public class NodeCardActivity extends AppCompatActivity {
    GridView nodeGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_card);

        nodeGV = findViewById(R.id.gridIdNode);
        ArrayList<NodeModel> courseModelArrayList = new ArrayList<NodeModel>();

        courseModelArrayList.add(new NodeModel("node10"));
        courseModelArrayList.add(new NodeModel("node20"));
        courseModelArrayList.add(new NodeModel("node30"));
        courseModelArrayList.add(new NodeModel("node40"));

        NodeAdapter adapter = new NodeAdapter(this, courseModelArrayList);
        nodeGV.setAdapter(adapter);

    }
}