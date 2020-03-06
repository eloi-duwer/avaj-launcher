package com.avaj.flyable;

import com.avaj.exception.InvalidFileException;
import com.avaj.exception.InvalidCoordException;
import com.avaj.flyable.Coordinates;

public class AircraftFactory {
	public Flyable newAircraft(
		String type,
		String name,
		int longitude,
		int latitude,
		int height
	) throws InvalidFileException, InvalidCoordException {
		
		Coordinates coords = new Coordinates(longitude, latitude, height);
		switch (type) {
			case "JetPlane":
				return new JetPlane(name, coords);
			case "Helicopter":
				return new Helicopter(name, coords);
			case "Baloon":
				return new Baloon(name, coords);
			default:
				throw new InvalidFileException("Type " + type + " is not valid. List of valid types: JetPlane, Helicopter, Baloon");
		}
	}
}