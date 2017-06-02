package com.example.patel.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Patel on 01-06-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeClass> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeClass> earthquakeClasses) {
        super(context, 0, earthquakeClasses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null, false);
        }

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeView = (TextView) listItemView.findViewById(R.id.TimeInMilliseconds);

        EarthquakeClass earthquakeClass = getItem(position);

        double mag = earthquakeClass.getMagnitude();
        magnitudeView.setText(formatMagnitude(mag));

        String originalLocation = earthquakeClass.getLocation();
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        primaryLocationView.setText(primaryLocation);
        locationOffsetView.setText(locationOffset);

        Date dateObject = new Date(earthquakeClass.getTimeInMilliseconds());
        dateView.setText(formatDate(dateObject));
        timeView.setText(formatTime(dateObject));

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL d, y");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}