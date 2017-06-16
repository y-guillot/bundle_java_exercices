package dico.command;

import java.util.ArrayList;
import java.util.List;

import dico.Dictionary;
import dico.DictionaryFactory;
import dico.Menu;
import dico.MenuItem;

public class MenuItemSearch extends MenuItem {

	public MenuItemSearch(Menu menu, String name, Integer id) {
		super(menu, name, id);
		
	}
	
	public MenuItemSearch(Menu menu, Integer id) {
		super(menu, "Rechercher un mot contenant une chaine", id);
	}	

	@Override
	public void run() {
		final Dictionary dico = DictionaryFactory.getInstance();
		MenuItem.LOGGER.info("Veuillez siaisr une chaine de caract�re � rechercher : ");
		final String saisie = this.menu.getScanner().next();
		List<String> results = new ArrayList<>();
		
		for (String word : dico.getWords()) {
			if (this.matches(word, saisie)) {
				results.add(word);
				//break;
			}
		}
		
		if (!results.isEmpty()) {
			// TODO afficher le contenu de la liste
			MenuItem.LOGGER.info("Liste des r�sultats trouv�s :");
			for (String word : results) {
				MenuItem.LOGGER.info(word);
			}
		} else {
			// Afficher "Aucun r�sultat"
			MenuItem.LOGGER.info("Aucun r�sultat");
		}
		MenuItem.LOGGER.info("------------------------------------\n");
	}

	protected boolean matches(String word, String saisie) {
		
		return word.contains(saisie);
	}
}
