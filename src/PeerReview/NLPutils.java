package PeerReview;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.ie.util.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.*;
import edu.stanford.nlp.trees.*;

import java.util.*;
import java.util.List;
import java.util.ArrayList;


public class NLPutils {
	private StanfordCoreNLP pipeline;
	private Properties props;
	private List<CoreDocument> docs;
	
	NLPutils(String text) {
		props = new Properties();
		//tokenization, sentence splitting, part-of-speech, lemmas, named-entity recognition
		//Lexicalized PCFG parser, NN dependency parsing, coreference, TAC knowledge base population, picks out quotes
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
		props.setProperty("coref.algorithm","statistical"); //let's be basic
		
		pipeline = new StanfordCoreNLP(props);
		CoreDocument doc = new CoreDocument(text);
		docs.add(doc);
		
		pipeline.annotate(doc);
		
	}
	
	public void getParts() {
		System.out.println(this.docs.get(0).tokens());
	}
	
	public static void main(String[] args) {
		
	}
	
}
