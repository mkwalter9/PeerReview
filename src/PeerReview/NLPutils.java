package PeerReview;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.parser.nndep.DependencyParser;
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
	private List<CoreDocument> docs = new ArrayList<CoreDocument>();
	
	NLPutils(String text) {
		try {
			this.props = new Properties();
			//tokenization, sentence splitting, part-of-speech, lemmas, named-entity recognition
			//Lexicalized PCFG parser, NN dependency parsing, coreference, TAC knowledge base population, picks out quotes
			//props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
			this.props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
			//props.setProperty("coref.algorithm","statistical"); //let's be basic
			//props.setProperty("depparse.model", DependencyParser.DEFAULT_MODEL);
			
			this.pipeline = new StanfordCoreNLP(props);
			CoreDocument doc = new CoreDocument(text);
			
			this.pipeline.annotate(doc);
			this.docs.add(doc);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return;		
	}
	
	public void getParts() {
		System.out.println(this.docs.get(0).tokens());
		CoreSentence sentence = this.docs.get(0).sentences().get(1);
		List<String> posTags = sentence.posTags();
		System.out.println(posTags);
		List<String> nerTags = sentence.nerTags();
	    System.out.println("ner tags");
	    System.out.println(nerTags);
	}
	
	public static void main(String[] args) {
		
	}
	
}
