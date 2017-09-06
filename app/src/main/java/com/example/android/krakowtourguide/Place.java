package com.example.android.krakowtourguide;

/**
 * Created by kiwi on 2017-07-08.
 */

public class Place {

    private int mImageResId = NO_IMAGE_FOUND;

    private static final int NO_IMAGE_FOUND = -1;

    private String mLocationName;
    private String mLocationInformation;
    private String mLocationDetails;
    private String mMapUrl;

    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationInformation() {
        return mLocationInformation;
    }

    public String getLocationDetails() {
        return mLocationDetails;
    }

    public String getMapUrl() {
        return mMapUrl;
    }

    //get image from resource
    public int getImageResId() {
        return mImageResId;
    }

    // create place constructor
    public Place(String locationName, String locationInformation, String locationDetails, int imageResId, String mapUrl ) {
        mLocationName = locationName;
        mLocationInformation = locationInformation;
        mLocationDetails = locationDetails;
        mImageResId = imageResId;
        mMapUrl = mapUrl;
    }

    //return image
    public boolean hasImage() {
        return mImageResId != NO_IMAGE_FOUND;
    }
}