package com.example.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";
    String primaryLocation;
    String locationOffset;

    public Adapter( Context context,  ArrayList<Earthquake> arrayList) {
        super(context, 0, arrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if (view ==null)
        {
            view=LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);

        }
        Earthquake earthquake=getItem(position);
        TextView text_mag=view.findViewById(R.id.magnitude);
        TextView text_location_set=view.findViewById(R.id.locationofset);

        text_mag.setText(earthquake.getMagnitude());
        TextView text_location=view.findViewById(R.id.location);
        String originalLocation=earthquake.getLocation();
        if(originalLocation.contains(LOCATION_SEPARATOR))
        {
            String [] part=originalLocation.split(LOCATION_SEPARATOR);
            locationOffset =part[0]+LOCATION_SEPARATOR;
            primaryLocation=part[1];
        }
        else
        {
            locationOffset=getContext().getString(R.string.near_the);
            primaryLocation=originalLocation;
        }



        text_location.setText(locationOffset);
        text_location_set.setText(primaryLocation);
        TextView text_Data=view.findViewById(R.id.data);
        String dataold=earthquake.getData();
        Date date=new Date(Long.parseLong(dataold));
        String dateformat=formatDate(date);

        text_Data.setText(dateformat);
        String time_data=formatTime(date);
        TextView text_time=view.findViewById(R.id.time);
        text_time.setText(time_data);


        return view;
    }

    private String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(date);
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");

        return dateFormat.format(date);
    }
}
