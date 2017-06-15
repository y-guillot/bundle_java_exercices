package dico;

import java.io.InputStream;

public class DictionaryFactory {

	private static Dictionary instance;
	public static final String EMBEDED_DATA_PATH = "./resources/dictionnaire.txt";
	
	public static Dictionary getInstance() {
		
		if (DictionaryFactory.instance == null) {
			DictionaryFactory.instance = new Dictionary();
			final InputStream is = DictionaryFactory.fetchEmbeddedData();
			DictionaryFactory.instance.initialize(is);
		}
		
		return DictionaryFactory.instance;
	}

	private static InputStream fetchEmbeddedData() {
		
		return DictionaryFactory.class.getClassLoader().getResourceAsStream(DictionaryFactory.EMBEDED_DATA_PATH);
	}
}
