package PeerReview;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class PrintPDF {
	private String folder;
	private int iterNum;
	
	PrintPDF(String foldername, int docnum) {
		this.folder = foldername;
		this.iterNum = docnum;
	}
	
	public static void main(String[] args) {
		System.out.println("Test");
	}
	
	public String getText(String arg) throws IOException {
		try {
			PDDocument document = PDDocument.load(new File(arg));

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
}
