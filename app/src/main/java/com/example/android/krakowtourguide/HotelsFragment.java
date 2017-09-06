package com.example.android.krakowtourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_hotels, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.hotel_wawel), getString(R.string.hotel), getString(R.string.wawel_hotel), R.drawable.wawel_hotel, "https://goo.gl/maps/hKtDhBEZGZT2"));
        places.add(new Place(getString(R.string.niebieski1), getString(R.string.niebieski2), getString(R.string.art_blue), R.drawable.blue, "https://goo.gl/maps/q3VomoAZa4G2"));
        places.add(new Place(getString(R.string.komor1), getString(R.string.komor2), getString(R.string.komorowski), R.drawable.komorowski, "https://goo.gl/maps/nFMpWxuZ5qt"));
        places.add(new Place(getString(R.string.pollera1), getString(R.string.hotel), getString(R.string.pollera), R.drawable.pollera, "https://goo.gl/maps/nFMpWxuZ5qt"));
        places.add(new Place(getString(R.string.copernicus1), getString(R.string.hotel), getString(R.string.copernicus), R.drawable.coper, "https://goo.gl/maps/CHAY9PVZ2vG2"));

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