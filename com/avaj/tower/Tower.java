package com.avaj.tower;

import java.util.ArrayList;

import com.avaj.exception.InvalidWeatherTypeException;
import com.avaj.exception.InvalidCoordException;
import com.avaj.flyable.Flyable;
import com.avaj.logger.Logger;

class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	private ArrayList<Flyable> lstDel;

	public void register(Flyable flyable) {
		this.observers.add(flyable);
		Logger.log("Tower says: " + flyable.toString() + " registered to weather tower.");
	}

	public void unregister(Flyable flyable) {
		int index = this.observers.indexOf(flyable);
		if (index == -1)
			throw new Error("This flyable " + flyable.toString() + " is not registered to this tower");
		this.lstDel.add(flyable);
		Logger.log("Tower says: " + flyable.toString() + " unregistered from weather tower.");
	}

	protected void conditionsChanged() throws InvalidWeatherTypeException, InvalidCoordException {
		this.lstDel = new ArrayList<Flyable>();
		for (Flyable observer : this.observers) {
			observer.updateConditions();
		}
		this.observers.removeAll(this.lstDel);
	}
}