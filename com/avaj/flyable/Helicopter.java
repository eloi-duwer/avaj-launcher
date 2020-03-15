package com.avaj.flyable;

import com.avaj.tower.WeatherTower;
import com.avaj.exception.InvalidCoordException;
import com.avaj.exception.InvalidWeatherTypeException;
import com.avaj.flyable.Aircraft;
import com.avaj.flyable.Coordinates;
import com.avaj.logger.Logger;

class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String currentWeather;

	Helicopter(String name, Coordinates coordinates) {

		super(name, coordinates);
		this.weatherTower = null;
	}

	public String toString()
	{
		return "Helicopter#" + super.name + "(" + super.id + ")";
	}

	private void changeWeather(String newWeather) {
		this.currentWeather = newWeather;
		switch(newWeather) {
			case "SUN":
				Logger.log(this.toString() + ": What a beautiful weather! Let's go full speed!!");
				break;
			case "RAIN":
				Logger.log(this.toString() + ": It's raining, let's be careful");
				break;
			case "FOG":
				Logger.log(this.toString() + ": I can't see anything!");
				break;
			case "SNOW":
				Logger.log(this.toString() + ": My rotor is freezing! We're going to crash!");
				break;
		}
	}

	public void updateConditions() throws InvalidWeatherTypeException, InvalidCoordException {
		String weather = weatherTower.getWeather(super.coordinates);
		if (weather != this.currentWeather)
			this.changeWeather(weather);
		Coordinates newCoords;
		switch (weather) {
			case "SUN":
				newCoords = new Coordinates(super.coordinates.getLongitude() + 10, super.coordinates.getLatitude(), super.coordinates.getHeight() + 2);
				break;
			case "RAIN":
				newCoords = new Coordinates(super.coordinates.getLongitude() + 5, super.coordinates.getLatitude(), super.coordinates.getHeight());
				break;
			case "FOG":
				newCoords = new Coordinates(super.coordinates.getLongitude() + 1, super.coordinates.getLatitude(), super.coordinates.getHeight() - 3);
				break;
			case "SNOW":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude(), super.coordinates.getHeight() - 12);
				break;
			default:
				throw new InvalidWeatherTypeException("Weather type " + weather + " is unknown");
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