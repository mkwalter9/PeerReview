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
	public static void main() {
		PrintPDF textLoader = new PrintPDF("CS",1);
		System.out.println("Test 1.5");
		List<String> texts = textLoader.readPapers();
		int size = texts.size();
		System.out.println(size);
		for (String child : texts) {
			System.out.println(child);
		}
	}
}
