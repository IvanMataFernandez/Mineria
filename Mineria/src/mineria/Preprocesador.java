package mineria;
import org.deeplearning4j.models.word2vec.VocabWord;
import org.deeplearning4j.models.word2vec.Word2Vec;

public class Preprocesador {

	private static Preprocesador p;
	
	private Preprocesador() {
	}
	
	public static Preprocesador getPreprocesador() {
		if (Preprocesador.p == null) {
			Preprocesador.p = new Preprocesador();
		}
		return Preprocesador.p;
	}
	

	
	public void wordEmbedding() {
		
		// https://deeplearning4j.konduit.ai/v/en-1.0.0-beta6/language-processing/word2vec
		
		/*
		
		Word2Vec vec = new Word2Vec.Builder()
		        .minWordFrequency(5)
		        .layerSize(100)
		        .seed(42)
		        .windowSize(5)
		        .iterate(iter)
		        .tokenizerFactory(t)
		        .build();
		*/
	} 
	
	
}
