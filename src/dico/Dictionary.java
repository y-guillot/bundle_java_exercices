package dico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dictionary {

	private static final Logger LOGGER = LogManager.getLogger(Dictionary.class);
	private final List<String> words;

	public Dictionary() {
		this.words = new LinkedList<>();
	}
	
	public void initialize(final InputStream is) {
		
		try(final BufferedReader reader = new BufferedReader(
				new InputStreamReader(is, Charset.forName("UTF-8")))) {
			
			String line;
			while((line = reader.readLine()) != null) {
				final String word = line.trim();
				if (!word.isEmpty()) {
					this.words.add(word);
				}
			}
		} catch (IOException e) {
			Dictionary.LOGGER.error("Erreur pendant la recuperation des données du dico", e);
		}
	}

	public List<String> getWords() {
		return words;
	}
}
