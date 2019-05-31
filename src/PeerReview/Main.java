/**
 * 
 * @author Margaret Walter mkwalter9@gmail.com
 *  5/29/19
 *
 */
package PeerReview;

import java.util.List;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		PrintPDF textLoader = new PrintPDF("CS",1);
		List<String> texts = textLoader.readPapers();
		int size = texts.size();
		for (String child : texts) {
			System.out.println(child);
		}
	}
}
