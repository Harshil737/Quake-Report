package com.example.patel.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        ArrayList<EarthquakeClass> arrayList = new ArrayList<>();
        arrayList = QueryUtils.extractEarthquakes();
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }
}
