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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_restaurants, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.korale1), getString(R.string.restaurant), getString(R.string.korale), R.drawable.korale, "https://goo.gl/maps/wBARPqTVPRQ2"));
        places.add(new Place(getString(R.string.l13conc), getString(R.string.l13conc2), getString(R.string.bar13), R.drawable.bar13, "https://goo.gl/maps/b7FDrpkQHUL2"));
        places.add(new Place(getString(R.string.bohema1), getString(R.string.restaurant), getString(R.string.pierogi), R.drawable.bohema, "https://goo.gl/maps/cKPdsBD7MZ42"));
        places.add(new Place(getString(R.string.baroq1), getString(R.string.baroq2), getString(R.string.baroque), R.drawable.baroque, "https://goo.gl/maps/c6W7FVLEoPH2"));
        places.add(new Place(getString(R.string.nad_greg1), getString(R.string.nad_greg2), getString(R.string.bakery), R.drawable.bakery,"https://goo.gl/maps/nq1MtQYj2T22"));
        places.add(new Place(getString(R.string.moja1), getString(R.string.moja2), getString(R.string.cafe), R.drawable.cafe, "https://goo.gl/maps/TtL26f4kuTm"));

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