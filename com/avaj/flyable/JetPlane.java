package com.avaj.flyable;

import com.avaj.tower.WeatherTower;
import com.avaj.exception.InvalidCoordException;
import com.avaj.flyable.Aircraft;
import com.avaj.flyable.Coordinates;
import com.avaj.logger.Logger;

class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String currentWeather;

	JetPlane(String name, Coordinates coordinates) {

		super(name, coordinates);
		this.weatherTower = null;
	}

	public String toString()
	{
		return "JetPlane#" + super.name + "(" + super.id + ")";
	}

	private void changeWeather(String newWeather) {
		this.currentWeather = newWeather;
		switch(newWeather) {
			case "SUN":
				Logger.log(this.toString() + ": The sky is perfect! Let's do some loops");
				break;
			case "RAIN":
				Logger.log(this.toString() + ": It's raining, i'll watch out for lightings");
				break;
			case "FOG":
				Logger.log(this.toString() + ": Too much fog, i'll slow down");
				break;
			case "SNOW":
				Logger.log(this.toString() + ": Brace yourself, snow is comming");
				break;
		}
	}

	public void updateConditions() throws InvalidCoordException {
		String weather = weatherTower.getWeather(super.coordinates);
		if (weather != this.currentWeather)
			this.changeWeather(weather);
		Coordinates newCoords;
		switch (weather) {
			case "SUN":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude() + 10, super.coordinates.getHeight() + 2);
				break;
			case "RAIN":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude() + 5, super.coordinates.getHeight());
				break;
			case "FOG":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude() + 1, super.coordinates.getHeight());
				break;
			case "SNOW":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude(), super.coordinates.getHeight() - 7);
				break;
			default:
				throw new Error("Weather type " + weather + " is unknown");
		}
		if (newCoords.getHeight() <= 0) {
			Logger.log(this.toString() + ": Landing, pos: " + newCoords.toString());
			this.registerTower(null);
		}
		super.coordinates = newCoords;
	}

	public void registerTower(WeatherTower weatherTower) {
		if (this.weatherTower != null && weatherTower != null)
			throw new Error ("This flyable " + this.toString() + "has already registered to a tower");
		if (weatherTower == null)
			this.weatherTower.unregister(this);
		else
			weatherTower.register(this);
		this.weatherTower = weatherTower;
	}
}