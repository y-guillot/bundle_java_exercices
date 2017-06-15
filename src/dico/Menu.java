package dico;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {

	private static final Logger LOGGER = LogManager.getLogger(Menu.class);
	
	private final Scanner scanner;
	private final List<MenuItem> items;
	
	
	public Menu() {
		this.items = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}
	
	public Scanner getScanner() {
		return scanner;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void display() {
		
		Menu.LOGGER.info("Liste des fonctionnalités disponibles :");
		for (final MenuItem item : this.items) {
			Menu.LOGGER.info("\t" + item.toString());
		}
	}
	
	public short readChoice() {
		short result = -1;
		Menu.LOGGER.info("Veuillez choisir une fonctionnalité correspondant au numéro correspondant : ");
		try {
			result = this.scanner.nextShort();
		} catch(InputMismatchException e) {
			Menu.LOGGER.trace("Saisie du coix du menuItem invalide : ", e);
			// replacer le curseur à la fin du flux
			this.scanner.next();
		}
		return result;
	}
	
	/**
	 * Execution de la recherche spécifique.
	 * 
	 * @param id l'identifiant correspondant au {@link MenuItem} à appeler
	 */
	public void executeIemById(final short id) {
		this.items.get(this.items.indexOf(new MenuItem(id))).run();
	}
}
