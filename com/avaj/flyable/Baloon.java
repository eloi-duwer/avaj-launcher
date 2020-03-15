package com.avaj.flyable;

import com.avaj.tower.WeatherTower;
import com.avaj.exception.InvalidCoordException;
import com.avaj.exception.InvalidWeatherTypeException;
import com.avaj.flyable.Aircraft;
import com.avaj.flyable.Coordinates;
import com.avaj.logger.Logger;

class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String currentWeather = null;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.weatherTower = null;
	}

	public String toString() {
		return "Baloon#" + super.name + "(" + super.id + ")";
	}

	private void changeWeather(String newWeather) {
		this.currentWeather = newWeather;
		switch(newWeather) {
			case "SUN":
				Logger.log(this.toString() + ": It's quite hot here! We're moving up!");
				break;
			case "RAIN":
				Logger.log(this.toString() + ": Too much rain! We're going down");
				break;
			case "FOG":
				Logger.log(this.toString() + ": It's foggy! Better be careful...");
				break;
			case "SNOW":
				Logger.log(this.toString() + ": The snow broke my baloon! rip");
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
				newCoords = new Coordinates(super.coordinates.getLongitude() + 2, super.coordinates.getLatitude(), super.coordinates.getHeight() + 4);
				break;
			case "RAIN":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude(), super.coordinates.getHeight() - 5);
				break;
			case "FOG":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude(), super.coordinates.getHeight() - 3);
				break;
			case "SNOW":
				newCoords = new Coordinates(super.coordinates.getLongitude(), super.coordinates.getLatitude(), super.coordinates.getHeight() - 15);
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