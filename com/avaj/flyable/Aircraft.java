package com.avaj.flyable;

import com.avaj.flyable.Coordinates;

class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	static private long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = this.nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		return ++Aircraft.idCounter;
	}
}