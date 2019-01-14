package flyable;

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