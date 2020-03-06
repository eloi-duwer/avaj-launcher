package com.avaj.weatherprovider;

import java.lang.Math;
import com.avaj.flyable.Coordinates;

public class WeatherProvider {
	
	private static WeatherProvider weatherprovider = null;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		if (weatherprovider == null)
			WeatherProvider.weatherprovider = new WeatherProvider();
		return WeatherProvider.weatherprovider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		return (WeatherProvider.weather[(coordinates.getLongitude() / 25
			+ coordinates.getLatitude() / 25
			+ coordinates.getHeight() / 10) % 4]);
	}
}