package dico.command;

import dico.Menu;

public class MenuItemSearchEnd extends MenuItemSearch {
	
	public MenuItemSearchEnd(Menu menu, Integer id) {
		
		super(menu, "Rechercher tous les mots qui finissent par une valeur", id);
	} 

	@Override
	protected boolean matches(String word, String saisie) {
		return word.endsWith(saisie);
	} 

}
