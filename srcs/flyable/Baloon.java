package flyable;

import tower.WeatherTower;

class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {

		super(name, coordinates);
		this.weatherTower = null;
	}

	public void updateConditions() {
		System.out.println("Coucou depuis Baloon!");
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}