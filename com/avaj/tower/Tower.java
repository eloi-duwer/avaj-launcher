package com.avaj.tower;

import java.util.ArrayList;
import com.avaj.flyable.Flyable;

class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
		int index = this.observers.indexOf(flyable);
		this.observers.get(index).registerTower(null);
	}

	protected void conditionsChanged() {
		for (Flyable observer : this.observers) {
			observer.updateConditions();
		}
	}
}