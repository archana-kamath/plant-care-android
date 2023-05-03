package com.sjsu.cmpe295b.pc_node;

import com.sjsu.cmpe295b.pc_node.model.NodeModel;

import android.util.Log;
import android.widget.ArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NodeAdapter extends ArrayAdapter<NodeModel> {
    public NodeAdapter(@NonNull Context context, ArrayList<NodeModel> projectModelArrayList) {
        super(context, 0, projectModelArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_node_card, parent, false);
        }

        NodeModel nodeModel = getItem(position);
        TextView nodeText = listitemView.findViewById(R.id.nodeTextId);

        String nodeTextStr = "\n"+"Node Id : "+ nodeModel.getNode_id()+"\n"+
                             "Plant Type : "+ nodeModel.getPlant_type()+"\n"+
                             "Moisture Threshold : "+ nodeModel.getMoisture_threshold()+"\n"+
                             "Temperature Threshold : "+ nodeModel.getTemperature_threshold()+"\n"+
                             "Humidity Threshold : "+ nodeModel.getHumidity_threshold()+"\n"+
                             "Latitude : "+ nodeModel.getLatitude().substring(10)+"\n"+
                             "Longitude : "+ nodeModel.getLongitude().substring(10);

        Log.i("NodeAdapter ",nodeTextStr);
        nodeText.setText(nodeTextStr);
        return listitemView;
    }

}
