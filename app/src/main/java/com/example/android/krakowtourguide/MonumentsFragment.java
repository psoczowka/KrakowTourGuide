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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentsFragment extends Fragment {

    public MonumentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_monuments, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.wawel1), getString(R.string.wawel2), getString(R.string.wawel), R.drawable.wawel, "https://www.google.pl/maps/place/Zamek+Kr%C3%B3lewski+na+Wawelu/@50.0540529,19.9332236,17z/data=!3m1!4b1!4m5!3m4!1s0x47165b6d053619f5:0xacb9dfc4d67fa598!8m2!3d50.0540495!4d19.9354123"));
        places.add(new Place(getString(R.string.kosciuszko1), getString(R.string.kosciuszko2), getString(R.string.kosciuszko), R.drawable.kosciuszko, "https://www.google.pl/maps/place/Zamek+Kr%C3%B3lewski+na+Wawelu/@50.0540529,19.9332236,17z/data=!3m1!4b1!4m5!3m4!1s0x47165b6d053619f5:0xacb9dfc4d67fa598!8m2!3d50.0540495!4d19.9354123"));
        places.add(new Place(getString(R.string.armoury1), getString(R.string.armoury2), getString(R.string.arm_museum), R.drawable.armory, "https://goo.gl/maps/j4UATyuicGA2"));
        places.add(new Place(getString(R.string.dragon1), getString(R.string.dragon2), getString(R.string.dragon), R.drawable.dragon, "https://goo.gl/maps/2fBqWVL9YbE2"));
        places.add(new Place(getString(R.string.stmary), getString(R.string.basilica), getString(R.string.mariacki), R.drawable.mariacki, "https://goo.gl/maps/QQkH3cSo7TU2"));
        places.add(new Place(getString(R.string.mainmarket), getString(R.string.square), getString(R.string.market), R.drawable.market, "https://goo.gl/maps/uCBkhHJ86xp"));
        places.add(new Place(getString(R.string.kosciuszko01), getString(R.string.kosciuszko02), getString(R.string.mound), R.drawable.kopiec, "https://goo.gl/maps/StEoeHmDu442"));
        places.add(new Place(getString(R.string.stfrancis), (getString(R.string.basilica)), getString(R.string.francis), R.drawable.franc, "https://goo.gl/maps/xaPdAMGRLFA2"));

        //create an {@link LocationAdapter}, whose data source is a list of {@link Place}
        LocationAdapter adapter = new LocationAdapter(getActivity(), places);
        // Find the {@link ListView} object
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
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