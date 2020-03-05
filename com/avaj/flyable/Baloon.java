package com.avaj.flyable;

import com.avaj.tower.WeatherTower;
import com.avaj.flyable.Aircraft;
import com.avaj.coordinates.Coordinates;

class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.weatherTower = null;
	}

	public void updateConditions() {
		System.out.println("Hi from Baloon!");
		String weather = weatherTower.
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		if (this.weatherTower != null)
			this.weatherTower.unregister(this);
		if (weatherTower != null) {
			weatherTower.register(this);
			System.out.println("Tower says: Baloon#" + super.name + "(" + super.id + ") registered to weather tower");
		}
		else
			System.out.println("Tower says: Baloon#" + super.name + "(" + super.id + ") unregistered to weather tower");
		this.weatherTower = weatherTower;
	}
}