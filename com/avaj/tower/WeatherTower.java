package com.avaj.tower;

import com.avaj.weatherprovider.WeatherProvider;
import com.avaj.exception.InvalidCoordException;
import com.avaj.exception.InvalidWeatherTypeException;
import com.avaj.flyable.Coordinates;

public class WeatherTower extends Tower {
	
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void changeWeather() throws InvalidCoordException, InvalidWeatherTypeException {
		this.conditionsChanged();
	}
}