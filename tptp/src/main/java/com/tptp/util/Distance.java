package com.tptp.util;

public class Distance {
	public static double distanceInKilometerByHaversine(double lat1, double lng1, double lat2, double lng2) {
	    double distance;
	    double radius = 6371;
	    double toRadian = Math.PI / 180;

	    double deltaLatitude = Math.abs(lat1 - lat2) * toRadian;
	    double deltaLongitude = Math.abs(lng1 - lng2) * toRadian;

	    double sinDeltaLat = Math.sin(deltaLatitude / 2);
	    double sinDeltaLng = Math.sin(deltaLongitude / 2);
	    double squareRoot = Math.sqrt(
	        sinDeltaLat * sinDeltaLat +
	        Math.cos(lat1 * toRadian) * Math.cos(lat2 * toRadian) * sinDeltaLng * sinDeltaLng);

	    distance = 2 * radius * Math.asin(squareRoot);

	    return distance;
	}

}
