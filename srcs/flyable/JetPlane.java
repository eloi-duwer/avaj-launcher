package flyable;

import tower.WeatherTower;

class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {

		super(name, coordinates);
		this.weatherTower = null;
	}

	public void updateConditions() {
		System.out.println("Coucou depuis JetPlane!");
		return;
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}