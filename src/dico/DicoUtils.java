package dico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DicoUtils implements Runnable {
	
	//Best practices : 1 logger by class.
	private static final Logger LOGGER = LogManager.getLogger(DicoUtils.class);

	public static void main(String[] args) {
 
		//DicoUtils.class.getClassLoader().getResourceAsStream("./log4j2.propoerties);
		new DicoUtils().run();
	}

	@Override
	public void run() {
		
		
		LOGGER.info("Dico Utils starts");
		LOGGER.error("oops i did it again");
		// Construction et Affichage du menu.
		// R�cup�ration du dictionnaire
		// R�cup�rer le choix utilisateur
		// Tant que ul'utilisateur ne cchoisi pas de quiter :
		// 		Si erreur, recommencer
		//		Sinon acc�der � la fonctionnalit� demand�e puis recommencer
		
	}

}
