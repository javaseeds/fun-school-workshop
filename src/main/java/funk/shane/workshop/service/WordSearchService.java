package funk.shane.workshop.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * © Fun-School-Workshop
 */
@Service
public class WordSearchService {
	private static final Logger logger = LoggerFactory.getLogger(WordSearchService.class);

	private ObjectMapper objectMapper;

	public WordSearchService(@Qualifier("jsonBean") ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	void generatePDF() {
		// review https://github.com/heksemann/HexPDF for useful ideas
		String tmp = "/Tools/data/pdfbox";
		File file = new File(tmp + "/test.pdf");
		logger.debug("Sending to {}", file.getAbsolutePath());

		final PDPage pdPage = new PDPage();

		try(final PDDocument document = new PDDocument()) {
			document.addPage(pdPage);
			final PDPageContentStream stream = new PDPageContentStream(document, pdPage);

			stream.beginText();
			stream.setFont(PDType1Font.COURIER, 14);
			stream.newLineAtOffset(10, 10);
			stream.showText("A C A T X F");
			stream.endText();

			stream.beginText();
			stream.setFont(PDType1Font.COURIER, 14);
			stream.newLineAtOffset(10, 20);
			stream.showText("G C F W R O");
			stream.endText();

			stream.beginText();
			stream.setFont(PDType1Font.COURIER, 14);
			stream.newLineAtOffset(10, 30);
			stream.showText("E R L E A X");
			stream.endText();

			stream.beginText();
			stream.setFont(PDType1Font.COURIER, 14);
			stream.newLineAtOffset(10, 40);
			stream.showText("M T A K Y O");
			stream.endText();

			stream.beginText();
			stream.setFont(PDType1Font.COURIER, 14);
			stream.newLineAtOffset(10, 50);
			stream.showText("D O G E R V");
			stream.endText();

			stream.close();

			document.save(file);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
