package com.example.android.krakowtourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_events, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.chopin_concerts), getString(R.string.chopin_choncerts_date), getString(R.string.chopin), R.drawable.chopin, "https://goo.gl/maps/uCBkhHJ86xp"));
        places.add(new Place(getString(R.string.festival1), getString(R.string.festival2), getString(R.string.festival), R.drawable.festival, "https://goo.gl/maps/uCBkhHJ86xp"));
        places.add(new Place(getString(R.string.erotic1), getString(R.string.erotic2), getString(R.string.exhibit), R.drawable.ex, "https://goo.gl/maps/uCBkhHJ86xp"));
        places.add(new Place(getString(R.string.jazz1), getString(R.string.jazz2), getString(R.string.jazz), R.drawable.jazz, "https://goo.gl/maps/uCBkhHJ86xp"));
        places.add(new Place(getString(R.string.orchestra1), getString(R.string.orchestra2), getString(R.string.orchestra), R.drawable.orchestra, "https://goo.gl/maps/NQ9QSwBZfPz"));

        LocationAdapter adapter = new LocationAdapter(getActivity(), places);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Place place = places.get(position);

                //find proper ImageView for google maps intents
                ImageView mapButton = (ImageView) view.findViewById(R.id.open_map_button);
                //set OnClickListener for ImageView
                mapButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        //open intent to google maps for every location
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(place.getMapUrl()));
                        startActivity(i);
                    }
                });

                //find view that will be set to visible after clicking on the item
                TextView locationDetailTextView = (TextView) view.findViewById(R.id.location_details);
                if (locationDetailTextView.getVisibility() == View.GONE) {
                    //show more information and location button after pressing list
                    locationDetailTextView.setVisibility(View.VISIBLE);
                    mapButton.setVisibility(View.VISIBLE);
                } else {
                    //hide information and location button
                    locationDetailTextView.setVisibility(View.GONE);
                    mapButton.setVisibility(View.GONE);
                }

            }
        });

        return rootView;
    }

}