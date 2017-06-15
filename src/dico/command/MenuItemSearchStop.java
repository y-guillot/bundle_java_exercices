package dico.command;

import dico.Menu;

public class MenuItemSearchStop extends MenuItemSearch {
	
	public MenuItemSearchStop(Menu menu, short id) {
		
		super(menu, "Rechercher tous les mots qui finissent par une valeur", id);
	} 

	@Override
	protected boolean matches(String word, String saisie) {
		return word.endsWith(saisie);
	} 

}
