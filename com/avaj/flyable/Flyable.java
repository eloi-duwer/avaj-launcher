package com.avaj.flyable;

import com.avaj.tower.WeatherTower;

public interface Flyable {

	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);

}