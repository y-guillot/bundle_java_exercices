package dico.command;

import dico.DicoUtils;
import dico.Menu;
import dico.MenuItem;

public class MenuItemExit extends MenuItem {
	
	public MenuItemExit(Menu menu, short id) {
		
		super(menu, "Quitter l'application", id);
	}

	@Override
	public void run() {
		DicoUtils.RUNNING = false;
		LOGGER.info("Have a nice day...");
	}

}
