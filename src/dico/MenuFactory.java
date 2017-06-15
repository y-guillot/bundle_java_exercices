package dico;

import dico.command.MenuItemExit;
import dico.command.MenuItemSearch;
import dico.command.MenuItemSearchStart;
import dico.command.MenuItemSearchStop;

public class MenuFactory {

	private static Menu instance;
	
	public static Menu getInstance() {
		if (MenuFactory.instance == null) {
			// Create menu
			MenuFactory.instance = new Menu();
			short itemId = 0;
			// Populate menu with MenuItems
			MenuFactory.instance.getItems().add(new MenuItemExit(MenuFactory.instance, itemId++));
			MenuFactory.instance.getItems().add(new MenuItemSearch(MenuFactory.instance, itemId++));
			MenuFactory.instance.getItems().add(new MenuItemSearchStop(MenuFactory.instance, itemId++));
			MenuFactory.instance.getItems().add(new MenuItemSearchStart(MenuFactory.instance, itemId++));
		}
		return MenuFactory.instance;
	}
}
