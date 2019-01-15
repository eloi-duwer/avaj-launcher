package com.avaj.flyable;

public class AircraftFactory {
	public Flyable newAircraft(String type,
			String name,
			int longitude,
			int latitude,
			int height) {
		
		Coordinates coords = new Coordinates(longitude, latitude, height);
		switch (type) {
			case "JetPlane":
				return new JetPlane(name, coords);
			case "Helicopter":
				return new Helicopter(name, coords);
			case "Baloon":
				return new Baloon(name, coords);
			default:
				return null;
		}
	}
}