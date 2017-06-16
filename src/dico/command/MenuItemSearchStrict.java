package dico.command;

import dico.Menu;

public class MenuItemSearchStrict extends MenuItemSearch {
	
	public MenuItemSearchStrict(Menu menu, Integer id) {
		
		super(menu, "Rechercher la présence d'un mot exacte", id);
	}

	@Override
	protected boolean matches(String word, String saisie) {
		return word.equals(saisie);
	} 

}
