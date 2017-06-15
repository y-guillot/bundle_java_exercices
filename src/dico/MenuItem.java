package dico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuItem implements Runnable {

	// Menu menu
	private final String name;
	protected final Menu menu;
	private final short id;
	
	protected static final Logger LOGGER = LogManager.getLogger(MenuItem.class);
	
	public MenuItem(final short id) {
		
		this.menu = null;
		this.name = null;
		this.id = id;
	}
	
	public MenuItem(final Menu menu, final String name, final short id) {
		
		this.menu = menu;
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public short getId() {
		return id;
	}

	@Override
	public void run() {
		throw new IllegalAccessError(); // On lève une error Throwable
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MenuItem)) {
			return false;
		}
		MenuItem other = (MenuItem) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.name;
	}

	
	
}
