package com.example.vcparkingslot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Model {
    public ArrayList<ParkData> parkList = new ArrayList<ParkData>();
    //public String rawData;

    public void Deserialize(String rawData, Runnable Callback)
        throws JSONException {

            JSONObject json = new JSONObject(rawData);
            JSONArray json_arr = json.getJSONArray("items").getJSONObject(0).getJSONArray("carpark_data");

            int len = json_arr.length();

            for(int i = 0; i < len; i++) {
                ParkData data = new ParkData();
                JSONObject parent_content = json_arr.getJSONObject(i);
                data.car_park_number = parent_content.getString("carpark_number");
                JSONObject child_content = parent_content.getJSONArray("carpark_info").getJSONObject(0);
                data.lot_type = child_content.getString("lot_type");
                data.total_lots = child_content.getString("total_lots");
                parkList.add(data);
            }

            Callback.run();
    }
}
