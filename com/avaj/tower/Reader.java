package com.avaj.tower;

import com.avaj.flyable.Flyable;
import com.avaj.flyable.AircraftFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.Exception;

class Reader {
	public static void main(String[] argv) {
		if (argv.length != 1) {
			System.out.println("Usage: java com.avaj.reader.Reader <scenario_file>");
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(argv[0]));
			String string;
			WeatherTower tower = new WeatherTower();
			AircraftFactory factory = new AircraftFactory();
			int nbSimu = Integer.parseInt(reader.readLine());
			while((string = reader.readLine()) != null) {
				//System.out.println(string);
				String[] split = string.split(" ");
				Flyable plane = factory.newAircraft(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
				plane.registerTower(tower);
			}
			tower.changeWeather();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace(System.out);
			return;
		}
	}
}