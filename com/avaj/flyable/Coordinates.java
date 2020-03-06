package com.avaj.flyable;

import com.avaj.exception.InvalidCoordException;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) throws InvalidCoordException {
		if (longitude < 0)
			throw new InvalidCoordException("Longitude must be a positive number");
		if (latitude < 0)
			throw new InvalidCoordException("Latitude must be a positive number");
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = (height <= 100 ? (height >= 0 ? height : 0) : 100);
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public String toString() {
		return "Longitude: " + this.getLongitude() + ", latitude: " + this.getLatitude() + ", height: " + this.getHeight(); 
	}
}
