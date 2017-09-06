package com.example.android.krakowtourguide;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kiwi on 2017-07-08.
 */

public class LocationAdapter extends ArrayAdapter<Place> {

    public LocationAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the place object
        Place currentPlace = getItem(position);

        //find the TextView in the list_item.xml layout with the ID version
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_name);
        //use getLocationName method to currently displayed place
        locationTextView.setText(currentPlace.getLocationName());

        //find the TextView in the list_item.xml layout with the ID version
        TextView locationInfoTextView = (TextView) listItemView.findViewById(R.id.location_information);
        //use getLocationInformation method to currently displayed place
        locationInfoTextView.setText(currentPlace.getLocationInformation());

        //find the TextView in the list_item.xml layout with the ID version
        TextView locationDetailTextView = (TextView) listItemView.findViewById(R.id.location_details);
        //use getLocationInformation method to currently displayed place
        locationDetailTextView.setText(currentPlace.getLocationDetails());
        //set visibility to GONE for more information TextView in order to display only if rootview is clicked
        locationDetailTextView.setVisibility(View.GONE);
        //set visibility to GONE for location button in order to display only if rootview is clicked
        ImageView mapButton = (ImageView) listItemView.findViewById(R.id.open_map_button);
        mapButton.setVisibility(View.GONE);

        //get the image resource ID
        ImageView photoView = (ImageView) listItemView.findViewById(R.id.location_image);
        if (currentPlace.hasImage()) {
            //set the image to photoView
            photoView.setImageResource(currentPlace.getImageResId());
            //make sure the view is visible
            photoView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the photoView
            photoView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}