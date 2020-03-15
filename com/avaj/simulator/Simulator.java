package com.avaj.simulator;

import com.avaj.flyable.Flyable;
import com.avaj.exception.InvalidFileException;
import com.avaj.flyable.AircraftFactory;
import com.avaj.tower.WeatherTower;
import com.avaj.logger.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.Exception;

class Simulator {
	public static void main(String[] argv) {
		if (argv.length != 1) {
			System.out.println("Usage: java com.avaj.reader.Reader <scenario_file>");
			return;
		}
		try {
			//Initialisation du logger
			Logger.initLogger("simulation.txt");
			BufferedReader reader = new BufferedReader(new FileReader(argv[0]));
			WeatherTower tower = new WeatherTower();
			AircraftFactory factory = new AircraftFactory();
			
			int nbSimu;
			try {
				nbSimu = Integer.parseInt(reader.readLine());
				if (nbSimu < 0)
					throw new Exception();
			} catch(Exception e) {
				throw new InvalidFileException("Error line 1: The first line must be a positive number specifying the number of rounds for the simulation");
			}
			
			//Parsing de toutes les lignes du fichier
			int lineNumber = 2;
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split(" ");
				if (split.length != 5)
					throw new InvalidFileException("Error Line " + lineNumber + ": Must have format TYPE NAME LONGITUDE LATITUDE HEIGHT");
				int longitude, latitude, height;
				try {
					longitude = Integer.parseInt(split[2]);
					latitude = Integer.parseInt(split[3]);
					height = Integer.parseInt(split[4]);
					if (longitude < 0 || latitude < 0 || height < 0)
						throw new NumberFormatException();
				} catch(NumberFormatException e) {
					throw new InvalidFileException("Error line "+ lineNumber + ": Longitude, latitude and height must be positive numbers");
				}
				Flyable plane = factory.newAircraft(split[0], split[1], longitude, latitude, height);
				plane.registerTower(tower);
				++lineNumber;
			}
			for (int i = 0; i < nbSimu; i++)
				tower.changeWeather();

		} catch (Exception e) {
			e.printStackTrace(System.out);
			return;
		} finally {
			Logger.closeLog();
		}
	}
}
