package dico.command;

import dico.Menu;

public class MenuItemSearchStart extends MenuItemSearch {
	
	public MenuItemSearchStart(Menu menu, short id) {
		
		super(menu, "Rechercher tous les mots qui commencent par une valeur", id);
	} 

	@Override
	protected boolean matches(String word, String saisie) {
		return word.startsWith(saisie);
	} 

}
