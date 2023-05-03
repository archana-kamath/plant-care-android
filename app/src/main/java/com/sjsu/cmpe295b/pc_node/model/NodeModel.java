package com.sjsu.cmpe295b.pc_node.model;

public class NodeModel {

    private String user_id;
    private String project_id;
    private String node_id;
    private String plant_type;
    private String moisture_threshold;
    private String temperature_threshold;
    private String humidity_threshold;
    private String latitude;
    private String longitude;

    public NodeModel() {
    }
    public NodeModel(String node_id) {
        this.node_id = node_id;
    }

    public NodeModel(String user_id, String project_id, String node_id, String plant_type, String moisture_threshold, String temperature_threshold, String humidity_threshold, String latitude, String longitude) {
        this.user_id = user_id;
        this.project_id = project_id;
        this.node_id = node_id;
        this.plant_type = plant_type;
        this.moisture_threshold = moisture_threshold;
        this.temperature_threshold = temperature_threshold;
        this.humidity_threshold = humidity_threshold;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getPlant_type() {
        return plant_type;
    }

    public void setPlant_type(String plant_type) {
        this.plant_type = plant_type;
    }

    public String getMoisture_threshold() {
        return moisture_threshold;
    }

    public void setMoisture_threshold(String moisture_threshold) {
        this.moisture_threshold = moisture_threshold;
    }

    public String getTemperature_threshold() {
        return temperature_threshold;
    }

    public void setTemperature_threshold(String temperature_threshold) {
        this.temperature_threshold = temperature_threshold;
    }

    public String getHumidity_threshold() {
        return humidity_threshold;
    }

    public void setHumidity_threshold(String humidity_threshold) {
        this.humidity_threshold = humidity_threshold;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "NodeModel{" +
                "user_id='" + user_id + '\'' +
                ", project_id='" + project_id + '\'' +
                ", node_id='" + node_id + '\'' +
                ", plant_type='" + plant_type + '\'' +
                ", moisture_threshold='" + moisture_threshold + '\'' +
                ", temperature_threshold='" + temperature_threshold + '\'' +
                ", humidity_threshold='" + humidity_threshold + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
