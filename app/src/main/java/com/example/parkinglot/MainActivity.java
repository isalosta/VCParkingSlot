package com.example.parkinglot;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.example.vcparkingslot.VCParkingSlot;

public class MainActivity extends AppCompatActivity {

    VCParkingSlot slotPlugins;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.linear_layout);

        slotPlugins = new VCParkingSlot();

        CreateTitle();
        CreateButton();

    }

    private void CreateTitle() {
        LinearLayout _layout = new LinearLayout(this);
        _layout.setOrientation(LinearLayout.HORIZONTAL);

        layout.addView(_layout);

        TextView text = new TextView(this);
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setTextSize(24);

        text.setText("VC Parking Slot");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, convertDpToPixel(37));

        params.setMargins(convertDpToPixel(128),
                convertDpToPixel(64),
                0, 0
        );


        text.setTextColor(Color.BLACK);
        text.setLayoutParams(params);

        _layout.addView(text);
    }

    private void CreateButton() {
        LinearLayout _layout = new LinearLayout(this);
        _layout.setOrientation(LinearLayout.HORIZONTAL);

        layout.addView(_layout);

        Button button = new Button(this);
        button.setText("START");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Starting();
            }
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                convertDpToPixel(124), convertDpToPixel(49));

        params.setMargins(convertDpToPixel(145),
                convertDpToPixel(64),
                0, convertDpToPixel(8)
        );

        button.setLayoutParams(params);
        _layout.addView(button);
    }

    private int convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public void Starting() {
        System.out.println(slotPlugins.Title());
        Intent intent = new Intent(this, slotPlugins.Activity_().getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
       // this.finish();
    }
}
