package com.example.vcparkingslot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ParkData> {

    ArrayList<ParkData> dataset;
    Context mContext;

    private static class ViewHolder {
        TextView slot;
        TextView total;
        TextView type;
    }

    public CustomAdapter(ArrayList<ParkData> data, Context context) {
        super(context, R.layout.activity_item, data);
        this.dataset = data;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ParkData dataModel = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_item, parent, false);
            viewHolder.slot = convertView.findViewById(R.id.slot);
            viewHolder.total = convertView.findViewById(R.id.total);
            viewHolder.type = convertView.findViewById(R.id.type);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.slot.setText("Slot: "+ dataModel.car_park_number);
        viewHolder.type.setText(dataModel.lot_type);
        viewHolder.total.setText("Total: "+dataModel.total_lots);

        return convertView;
    }
}
