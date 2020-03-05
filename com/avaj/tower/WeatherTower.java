package com.avaj.tower;

import com.avaj.weatherprovider.WeatherProvider;
import com.avaj.coordinates.Coordinates;

public class WeatherTower extends Tower {
	
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void changeWeather() {
		this.conditionsChanged();
	}
}