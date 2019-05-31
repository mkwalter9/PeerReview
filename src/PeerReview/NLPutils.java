package PeerReview;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.ie.util.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.*;
import edu.stanford.nlp.trees.*;
import java.util.*;


public class NLPutils {
	
	NLPutils() {
		Properties props = new Properties();
		//tokenization, sentence splitting, part-of-speech, lemmas, named-entity recognition
		//Lexicalized PCFG parser, neural-net dependency parsing, coreference, TAC knowledge base population, picks out quotes
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
	}
	
	public static void main(String[] args) {
		
	}
	
}
