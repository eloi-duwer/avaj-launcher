package com.avaj.flyable;

import com.avaj.tower.WeatherTower;

class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {

		super(name, coordinates);
		this.weatherTower = null;
	}

	public void updateConditions() {
		System.out.println("Coucou depuis Helicopter!");
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		if (this.weatherTower != null)
			this.weatherTower.unregister(this);
		if (weatherTower != null) {
			weatherTower.register(this);
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower");
		}
		else
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered to weather tower");
		this.weatherTower = weatherTower;
	}
}