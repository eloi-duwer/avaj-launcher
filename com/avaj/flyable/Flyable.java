package com.avaj.flyable;

import com.avaj.exception.InvalidWeatherTypeException;
import com.avaj.exception.InvalidCoordException;
import com.avaj.tower.WeatherTower;

public interface Flyable {

	public void updateConditions() throws InvalidWeatherTypeException, InvalidCoordException;
	public void registerTower(WeatherTower weatherTower);
	public String toString();

}