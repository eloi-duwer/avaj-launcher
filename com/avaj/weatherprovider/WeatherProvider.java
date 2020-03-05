package com.avaj.weatherprovider;

import java.lang.Math;
import com.avaj.coordinates.Coordinates;

public class WeatherProvider {
	
	private static WeatherProvider weatherprovider = null;
	private static String[] weather;

	private WeatherProvider() {
		this.weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
	}

	public static WeatherProvider getProvider() {
		if (weatherprovider == null)
			WeatherProvider.weatherprovider = new WeatherProvider();
		return WeatherProvider.weatherprovider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		return (WeatherProvider.weather[(Math.abs(coordinates.getLongitude() / 25)
			+ Math.abs(coordinates.getLatitude() / 25)
			+ Math.abs(coordinates.getHeight() / 10)) % 4]);
	}
}