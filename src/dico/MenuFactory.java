package dico;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuFactory {

	private final static Logger LOGGER = LogManager.getLogger(MenuFactory.class);
	private final static String SEARCH_PACKAGE_NAME = "dico.command";
	private static List<String> REFLECTED_CLASSES = new LinkedList<>();

	private final static String[] menus = { "MenuItemExit", "MenuItemSearch", "MenuItemSearchStart",
			"MenuItemSearchEnd" };

	private static Menu instance;

	public static Menu getInstance() {
		if (MenuFactory.instance == null) {
			// Create menu
			MenuFactory.instance = new Menu();
			// Populate menu with MenuItems
			MenuFactory.retreiveClassesFromPackage();
			MenuFactory.populateMenu();
		}
		return MenuFactory.instance;
	}

	private static void populateMenu() {

		// short itemId = 0;
		//
		// MenuFactory.instance.getItems().add(new
		// MenuItemExit(MenuFactory.instance, itemId++));
		// MenuFactory.instance.getItems().add(new
		// MenuItemSearch(MenuFactory.instance, itemId++));
		// MenuFactory.instance.getItems().add(new
		// MenuItemSearchEnd(MenuFactory.instance, itemId++));
		// MenuFactory.instance.getItems().add(new
		// MenuItemSearchStart(MenuFactory.instance, itemId++));

		// parcour de la liste des menus
//		for (int itemId = 0; itemId < menus.length; ++itemId) {
		int itemId = 0;
		for (String className : MenuFactory.REFLECTED_CLASSES) {
			
			try {
//				Class<?> clazz = Class.forName(className);
				Class<?> clazz = Class.forName(MenuFactory.SEARCH_PACKAGE_NAME + "." + className);
				Constructor<?> constructor = clazz.getConstructor(Menu.class, Integer.class);
				MenuItem clazzInstance = (MenuItem) constructor.newInstance(MenuFactory.instance, itemId);
				MenuFactory.instance.getItems().add(clazzInstance);

			} catch (ClassNotFoundException e) {
				MenuFactory.LOGGER.error("La classe " + className + " n'existe pas", e);
			} catch (NoSuchMethodException e) {
				MenuFactory.LOGGER.error("Le constructeur de la classe " + className + " n'existe pas", e);
			} catch (SecurityException e) {
				MenuFactory.LOGGER.error("problèmes de sécurité sur la classe " + className, e);
			} catch (InstantiationException e) {
				MenuFactory.LOGGER.error("Impossible d'instancier la classe " + className, e);
			} catch (IllegalAccessException e) {
				MenuFactory.LOGGER.error("Violation d'accès à la classe " + className, e);
			} catch (IllegalArgumentException e) {
				MenuFactory.LOGGER.error("Les arguments passés à classe " + className + " ne sont pas conformes", e);
			} catch (InvocationTargetException e) {
				MenuFactory.LOGGER.error("La méthode d'invocation de la classe " + className + " pose problème", e);
			}
			
			++itemId;
		}

	}

	private static void retreiveClassesFromPackage() {
		try {
			ClassLoader cl = MenuFactory.class.getClassLoader();
			URL pathUrl = cl.getResource(MenuFactory.SEARCH_PACKAGE_NAME.replace(".", "/"));
			File repository = new File(new URI(pathUrl.toString()));
			File[] repositoryContent = repository.listFiles();
			for (File file : repositoryContent) {
				String className = file.getName().substring(0, file.getName().lastIndexOf("."));
				MenuFactory.REFLECTED_CLASSES.add(className);
			}
		} catch (URISyntaxException e) {
			MenuFactory.LOGGER.error("Le chemin ciblé par le package n'est pas conforme.", e);
		}
	}

}
