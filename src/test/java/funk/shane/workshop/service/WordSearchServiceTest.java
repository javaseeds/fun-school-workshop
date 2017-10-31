package funk.shane.workshop.service;

import org.junit.Test;
import org.springframework.context.annotation.Profile;

/**
 * ©2017 Spring Venture Group - fun-school-workshop
 */
@Profile("test")
public class WordSearchServiceTest {

	@Test
	public void runTest() {
		WordSearchService searchService = new WordSearchService(null);
		searchService.generatePDF();
	}
}