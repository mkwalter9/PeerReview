package PeerReview;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PrintPDF {
	private File folder;
	private int iterNum;
	
	PrintPDF(String foldername, int docnum) {
		this.folder = new File(foldername);
		this.iterNum = docnum;
		return;
	}
	
	public List<String> readPapers() {
		// Iterates through folder and reads pdfs
		List<String> texts = new ArrayList<String>();
		System.out.println("Test 2");
		try {
			System.out.println(folder);
			File[] directoryListing = folder.listFiles();
			if (directoryListing != null) {
				for (File child : directoryListing) {
					texts.add(getText(child));
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			texts.add("null");
		}
		return texts;
	}
	
	private String getText(File paper) throws IOException {
		try {
			PDDocument document = PDDocument.load(paper);

            document.getClass();
            System.out.println("Test");

            if (!document.isEncrypted()) {
			
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + pdfFileInText);
                return pdfFileInText;

//				// split by whitespace
//                String lines[] = pdfFileInText.split("\\r?\\n");
//                for (String line : lines) {
//                    System.out.println(line);
//                }

            } else {
            		return "null";
            }	
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		//System.out.println("Test");
		return;
	}
}
