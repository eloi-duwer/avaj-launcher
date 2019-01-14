package com.avaj.Aircraft;

class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
}

class Aircraft {
	protected int id;
	protected String name;
	protected Coordinates coordinates;
	static private long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {

	}

	private long nextId() {
		return this.idCounter + 1;
	}
}