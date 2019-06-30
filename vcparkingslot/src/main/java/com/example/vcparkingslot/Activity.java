package com.example.vcparkingslot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity extends AppCompatActivity {

    LinearLayout layout;
    LinearLayout _layout;

    ListView listView;
    ProgressBar spinner;
    Model model;

    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.linear_layout);

        _layout = new LinearLayout(this);
        _layout.setOrientation(LinearLayout.HORIZONTAL);

        layout.addView(_layout);

        listView = new ListView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        spinner = new ProgressBar(this);
        spinner.setLayoutParams(params);
        listView.setLayoutParams(params);
        spinner.setVisibility(View.VISIBLE);

        _layout.addView(spinner);

        model = new Model();

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        String formattedTime = timeFormat.format(date);

        new HttpRequest("https://api.data.gov.sg/v1/transport/carpark-availability?date_time=" + formattedDate + "T" + formattedTime.replace(":", "%3A"),
                new Runnable() {
                    @Override
                    public void run() {
                        GetFromPool(new Runnable() {
                            @Override
                            public void run() {
                                _layout.removeView(spinner);
                                _layout.addView(listView);

                                adapter = new CustomAdapter(model.parkList, getApplicationContext());
                                listView.setAdapter(adapter);
                            }
                        });
                    }
                }).execute();
    }

    private void GetFromPool(Runnable Callback) {
        System.out.println(Pool.Instance.Data);
        try {
            model.Deserialize(Pool.Instance.Data, Callback);
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }

}
