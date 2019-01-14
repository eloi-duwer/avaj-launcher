package tower;

import java.util.ArrayList;
import flyable.Flyable;

class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable observer : this.observers) {
			observer.updateConditions();
		}
	}

}