package com.avaj.flyable;

import com.avaj.exception.InvalidCoordException;
import com.avaj.tower.WeatherTower;

public interface Flyable {

	public void updateConditions() throws InvalidCoordException;
	public void registerTower(WeatherTower weatherTower);
	public String toString();

}