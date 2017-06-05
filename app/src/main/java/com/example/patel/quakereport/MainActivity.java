package com.example.patel.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EarthquakeClass data = (EarthquakeClass) parent.getItemAtPosition(position);
                Uri EarthQuakeUri = Uri.parse(data.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW,EarthQuakeUri);
                startActivity(websiteIntent);
            }
        });
    }
}
