package flyable;

import tower.WeatherTower;

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
		if (weatherTower != null)
			weatherTower.register(this);
		this.weatherTower = weatherTower;
	}
}