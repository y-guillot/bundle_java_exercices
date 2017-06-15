package dico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DicoUtils implements Runnable {
	
	//Best practices : 1 logger by class.
	private static final Logger LOGGER = LogManager.getLogger(DicoUtils.class);
	public static boolean RUNNING = true;
	public static String DICO_PATH = "./resources/dictionnaire.txt";

	public static void main(String[] args) {
 
		//DicoUtils.class.getClassLoader().getResourceAsStream("./log4j2.propoerties);
		new DicoUtils().run();
	}

	@Override
	public void run() {
		
		LOGGER.info("Dico Utils starts");
		LOGGER.error("oops i did it again");
		
		final Menu menu = MenuFactory.getInstance();
		
		while (DicoUtils.RUNNING) {
			
			menu.display();
			boolean inputValid = false;
			
			while(!inputValid) {
				final short id = menu.readChoice();
				if (id >= 0) {
					final MenuItem choosenItem = new MenuItem(id);
					if (menu.getItems().contains(choosenItem)) {
						inputValid = true;
						menu.executeIemById(id);
					} else {
						LOGGER.error("La valeur saisie "+ id + " n'ets pas valide");
					}
				} else {
					LOGGER.error("La valeur saisie "+ id + " n'est pas incluse dans la plage authorisée");
				}
			}
		}
	}
}
