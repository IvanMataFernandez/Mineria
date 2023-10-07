package mineria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.nd4j.linalg.factory.Nd4j;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;

import au.com.bytecode.opencsv.CSVWriter;

public class ConvertidorDeDatos {

	private static ConvertidorDeDatos c;
	private ArrayList<String> lista; // Stopword list (Eng)
	private ArrayList<String> lista2; // Stopword list (Esp)
	
	
	private ConvertidorDeDatos() {
		this.lista = new ArrayList<String>();
		this.lista2 = new ArrayList<String>();
		

		
		    lista.add("a");
	        lista.add("about");
	        lista.add("above");
	        lista.add("after");
	        lista.add("again");
	        lista.add("against");
	        lista.add("all");
	        lista.add("am");
	        lista.add("an");
	        lista.add("and");
	        lista.add("any");
	        lista.add("are");
	        lista.add("aren't");
	        lista.add("as");
	        lista.add("at");
	        lista.add("be");
	        lista.add("because");
	        lista.add("been");
	        lista.add("before");
	        lista.add("being");
	        lista.add("below");
	        lista.add("between");
	        lista.add("both");
	        lista.add("but");
	        lista.add("by");
	        lista.add("can");
	        lista.add("can't");
	        lista.add("cannot");
	        lista.add("could");
	        lista.add("couldn't");
	        lista.add("did");
	        lista.add("didn't");
	        lista.add("do");
	        lista.add("does");
	        lista.add("doesn't");
	        lista.add("doing");
	        lista.add("don't");
	        lista.add("down");
	        lista.add("during");
	        lista.add("each");
	        lista.add("few");
	        lista.add("for");
	        lista.add("from");
	        lista.add("further");
	        lista.add("had");
	        lista.add("hadn't");
	        lista.add("has");
	        lista.add("hasn't");
	        lista.add("have");
	        lista.add("haven't");
	        lista.add("having");
	        lista.add("he");
	        lista.add("he'd");
	        lista.add("he'll");
	        lista.add("he's");
	        lista.add("her");
	        lista.add("here");
	        lista.add("here's");
	        lista.add("hers");
	        lista.add("herself");
	        lista.add("him");
	        lista.add("himself");
	        lista.add("his");
	        lista.add("how");
	        lista.add("how's");
	        lista.add("i");
	        lista.add("i'd");
	        lista.add("i'll");
	        lista.add("i'm");
	        lista.add("i've");
	        lista.add("if");
	        lista.add("in");
	        lista.add("into");
	        lista.add("is");
	        lista.add("isn't");
	        lista.add("it");
	        lista.add("it's");
	        lista.add("its");
	        lista.add("itself");
	        lista.add("let's");
	        lista.add("me");
	        lista.add("more");
	        lista.add("most");
	        lista.add("mustn't");
	        lista.add("my");
	        lista.add("myself");
	        lista.add("no");
	        lista.add("nor");
	        lista.add("not");
	        lista.add("of");
	        lista.add("off");
	        lista.add("on");
	        lista.add("once");
	        lista.add("only");
	        lista.add("or");
	        lista.add("other");
	        lista.add("ought");
	        lista.add("our");
	        lista.add("ours");
	        lista.add("ourselves");
	        lista.add("out");
	        lista.add("over");
	        lista.add("own");
	        lista.add("same");
	        lista.add("shan't");
	        lista.add("she");
	        lista.add("she'd");
	        lista.add("she'll");
	        lista.add("she's");
	        lista.add("should");
	        lista.add("shouldn't");
	        lista.add("so");
	        lista.add("some");
	        lista.add("such");
	        lista.add("than");
	        lista.add("that");
	        lista.add("that's");
	        lista.add("the");
	        lista.add("their");
	        lista.add("theirs");
	        lista.add("them");
	        lista.add("themselves");
	        lista.add("then");
	        lista.add("there");
	        lista.add("there's");
	        lista.add("these");
	        lista.add("they");
	        lista.add("they'd");
	        lista.add("they'll");
	        lista.add("they're");
	        lista.add("they've");
	        lista.add("this");
	        lista.add("those");
	        lista.add("through");
	        lista.add("to");
	        lista.add("too");
	        lista.add("under");
	        lista.add("until");
	        lista.add("up");
	        lista.add("very");
	        lista.add("was");
	        lista.add("wasn't");
	        lista.add("we");
	        lista.add("we'd");
	        lista.add("we'll");
	        lista.add("we're");
	        lista.add("we've");
	        lista.add("were");
	        lista.add("weren't");
	        lista.add("what");
	        lista.add("what's");
	        lista.add("when");
	        lista.add("when's");
	        lista.add("where");
	        lista.add("where's");
	        lista.add("which");
	        lista.add("while");
	        lista.add("who");
	        lista.add("who's");
	        lista.add("whom");
	        lista.add("why");
	        lista.add("why's");
	        lista.add("with");
	        lista.add("won't");
	        lista.add("would");
	        lista.add("wouldn't");
	        lista.add("you");
	        lista.add("you'd");
	        lista.add("you'll");
	        lista.add("you're");
	        lista.add("you've");
	        lista.add("your");
	        lista.add("yours");
	        lista.add("yourself");
	        lista.add("yourselves");
		
	      
	        lista2.add("un");
	        lista2.add("una");
	        lista2.add("unas");
	        lista2.add("unos");
	        lista2.add("uno");
	        lista2.add("sobre");
	        lista2.add("todo");
	        lista2.add("también");
	        lista2.add("tras");
	        lista2.add("otro");
	        lista2.add("algún");
	        lista2.add("alguno");
	        lista2.add("alguna");
	        lista2.add("algunos");
	        lista2.add("algunas");
	        lista2.add("ser");
	        lista2.add("es");
	        lista2.add("soy");
	        lista2.add("eres");
	        lista2.add("somos");
	        lista2.add("sois");
	        lista2.add("estoy");
	        lista2.add("esta");
	        lista2.add("estamos");
	        lista2.add("estais");
	        lista2.add("estan");
	        lista2.add("como");
	        lista2.add("en");
	        lista2.add("para");
	        lista2.add("atras");
	        lista2.add("porque");
	        lista2.add("por qué");
	        lista2.add("estado");
	        lista2.add("estaba");
	        lista2.add("ante");
	        lista2.add("antes");
	        lista2.add("siendo");
	        lista2.add("ambos");
	        lista2.add("pero");
	        lista2.add("por");
	        lista2.add("poder");
	        lista2.add("puede");
	        lista2.add("puedo");
	        lista2.add("podemos");
	        lista2.add("podeis");
	        lista2.add("pueden");
	        lista2.add("fui");
	        lista2.add("fue");
	        lista2.add("fuimos");
	        lista2.add("fueron");
	        lista2.add("hacer");
	        lista2.add("hago");
	        lista2.add("hace");
	        lista2.add("hacemos");
	        lista2.add("haceis");
	        lista2.add("hacen");
	        lista2.add("cada");
	        lista2.add("fin");
	        lista2.add("incluso");
	        lista2.add("primero");
	        lista2.add("desde");
	        lista2.add("conseguir");
	        lista2.add("consigo");
	        lista2.add("consigue");
	        lista2.add("consigues");
	        lista2.add("conseguimos");
	        lista2.add("consiguen");
	        lista2.add("ir");
	        lista2.add("voy");
	        lista2.add("va");
	        lista2.add("vamos");
	        lista2.add("vais");
	        lista2.add("van");
	        lista2.add("vaya");
	        lista2.add("gueno");
	        lista2.add("ha");
	        lista2.add("tener");
	        lista2.add("tengo");
	        lista2.add("tiene");
	        lista2.add("tenemos");
	        lista2.add("teneis");
	        lista2.add("tienen");
	        lista2.add("el");
	        lista2.add("la");
	        lista2.add("lo");
	        lista2.add("las");
	        lista2.add("los");
	        lista2.add("su");
	        lista2.add("aqui");
	        lista2.add("mio");
	        lista2.add("tuyo");
	        lista2.add("ellos");
	        lista2.add("ellas");
	        lista2.add("nos");
	        lista2.add("nosotros");
	        lista2.add("vosotros");
	        lista2.add("vosotras");
	        lista2.add("si");
	        lista2.add("dentro");
	        lista2.add("solo");
	        lista2.add("solamente");
	        lista2.add("saber");
	        lista2.add("sabes");
	        lista2.add("sabe");
	        lista2.add("sabemos");
	        lista2.add("sabeis");
	        lista2.add("saben");
	        lista2.add("ultimo");
	        lista2.add("largo");
	        lista2.add("bastante");
	        lista2.add("haces");
	        lista2.add("muchos");
	        lista2.add("aquellos");
	        lista2.add("aquellas");
	        lista2.add("sus");
	        lista2.add("entonces");
	        lista2.add("tiempo");
	        lista2.add("verdad");
	        lista2.add("verdadero");
	        lista2.add("verdadera");
	        lista2.add("cierto");
	        lista2.add("ciertos");
	        lista2.add("cierta");
	        lista2.add("ciertas");
	        lista2.add("intentar");
	        lista2.add("intento");
	        lista2.add("intenta");
	        lista2.add("intentas");
	        lista2.add("intentamos");
	        lista2.add("intentais");
	        lista2.add("intentan");
	        lista2.add("dos");
	        lista2.add("bajo");
	        lista2.add("arriba");
	        lista2.add("encima");
	        lista2.add("usar");
	        lista2.add("uso");
	        lista2.add("usas");
	        lista2.add("usa");
	        lista2.add("usamos");
	        lista2.add("usais");
	        lista2.add("usan");
	        lista2.add("emplear");
	        lista2.add("empleo");
	        lista2.add("empleas");
	        lista2.add("emplean");
	        lista2.add("ampleamos");
	        lista2.add("empleais");
	        lista2.add("valor");
	        lista2.add("muy");
	        lista2.add("era");
	        lista2.add("eras");
	        lista2.add("eramos");
	        lista2.add("eran");
	        lista2.add("modo");
	        lista2.add("bien");
	        lista2.add("cual");
	        lista2.add("cuando");
	        lista2.add("donde");
	        lista2.add("mientras");
	        lista2.add("quien");
	        lista2.add("con");
	        lista2.add("entre");
	        lista2.add("sin");
	        lista2.add("trabajo");
	        lista2.add("trabajar");
	        lista2.add("trabajas");
	        lista2.add("trabaja");
	        lista2.add("trabajamos");
	        lista2.add("trabajais");
	        lista2.add("trabajan");
	        lista2.add("podria");
	        lista2.add("podrias");
	        lista2.add("podriamos");
	        lista2.add("podrian");
	        lista2.add("podriais");
	        lista2.add("yo");
	        lista2.add("aquel");
	        
		
	}
	
	
	public static ConvertidorDeDatos getConvertidor() {
		if (ConvertidorDeDatos.c == null) {
			ConvertidorDeDatos.c = new ConvertidorDeDatos();
		}
		
		return ConvertidorDeDatos.c;
	}
	
	public void dividirDatosPorIdioma() {
		// Pre: EXIST2021_training.csv [test_case,id,source,language,text,task1,task2]
		// Post: trainEsp.csv [text, task2], trainEng.csv [text, task2](una por idioma)
		// Extra: - Calculo de media de palabras y desviacion tipica de ellas por lenguaje
		//        - Cantidad de mensajes por label, por lenguaje


		// Ayudas sacadas de -> https://www.javatpoint.com/how-to-read-csv-file-in-java (leer de CSV)
		//                      https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/ (escribir a CSV)
		
		
		try {
			
			// Variables para calcular estadísticas de la muestra
			
			ArrayList<Integer> numPalabrasEsp = new ArrayList<Integer>();
			ArrayList<Integer> numPalabrasEng = new ArrayList<Integer>();
			HashMap<String, Integer> numTargetsEsp = new HashMap<String, Integer>();
			HashMap<String, Integer> numTargetsEng = new HashMap<String, Integer>();

			
			// Preparar el CSV de entrada para leer linea a linea
			
			Scanner sc = new Scanner(new File("."+File.separator+"datos"+File.separator+"EXIST2021_training.csv"));
			sc.useDelimiter("\n");
			
			// Preparar los descriptores para escribir ambos CSV de salida (el de Español e Ingles)
			
			File file = new File("."+File.separator+"datos"+File.separator+"trainEsp.csv");
			FileWriter oFile = new FileWriter(file);
			CSVWriter escEs = new CSVWriter(oFile); // Escribir a fichero de datos en Castellano
			
			file = new File("."+File.separator+"datos"+File.separator+"trainEng.csv");
			oFile = new FileWriter(file);
			CSVWriter escEn = new CSVWriter(oFile); // Escribir a fichero de datos en Inglés
		
			// Escribir la cabecera de los CSV de salida
			
			String[] cabecera = {"Texto", "Target"};
			escEs.writeNext(cabecera);
			escEn.writeNext(cabecera);
			
			
			
			while (sc.hasNext()) {
				
				// Por cada linea, recogerla y...
				String linea = sc.next();
				
				// Dividir por campos (en CSV se usa ',').
				
				String[] apartados = linea.split(",");
				String[] lineaDeInteres = new String[2];
				
				// Al menos hay 7 campos, pueden haber mas si el texto incluye comas, si es el caso hay que reconstruirlo
				
				if (apartados.length != 7) {
					
					// Texto con comas, aplicando esta lógica se unen las partes divididas del texto 
				    // y les ponemos las comas de nuevo entre ellas

					int index = 4;
					
					lineaDeInteres[0] = "";
					
					while (index != apartados.length-2) {
						
						if (index != apartados.length-3) {
							lineaDeInteres[0] = lineaDeInteres[0] + apartados[index] + ", ";
							
						} else {
							lineaDeInteres[0] = lineaDeInteres[0] + apartados[index];
							
						}
						index++;
					}
					
				} else {
					// Texto sin comas, recogemos el valor tal cual
					
					lineaDeInteres[0] = apartados[4];
				}
				
				// Recoger el cuarto campo porque este indica el idioma
				
				String idioma = apartados[3];
				
				// Tokenizar el texto
				
				lineaDeInteres[0] = this.tokenizar(lineaDeInteres[0], idioma); 			
				
				// El segundo campo a recoger es el label puesto en el experimento, este siempre es el ultimo campo
				
				lineaDeInteres[1] = apartados[apartados.length-1];
				

				
				/* Dependiendo del idioma, las operaciones las hacemos sobre sus estructuras de datos correspondientes:
				 
				  - Los dos datos recogidos previamente se escriben en su CSV de salida
				  - Se hace +1 a la cantidad de labels de ese tipo encontrado en ese idioma
				  
				  
				 */
				
				if (idioma.contentEquals("es")) {
					escEs.writeNext(lineaDeInteres);
		//			System.out.println("En Español -> "+lineaDeInteres[0]+" | "+lineaDeInteres[1]);
					
					
					numPalabrasEsp.add(lineaDeInteres[0].split(" ").length);
					
					Integer cant = numTargetsEsp.get(lineaDeInteres[1]);
					if (cant == null) {
						numTargetsEsp.put(lineaDeInteres[1], 1);
					} else {
						numTargetsEsp.put(lineaDeInteres[1], cant+1);	

					}
					

				} else {
					escEn.writeNext(lineaDeInteres);
					System.out.println("En Ingles -> "+lineaDeInteres[0]+" | "+lineaDeInteres[1]);
					
					
					numPalabrasEng.add(lineaDeInteres[0].split(" ").length);
					
					Integer cant = numTargetsEng.get(lineaDeInteres[1]);
					if (numTargetsEng.get(lineaDeInteres[1]) == null) {
						numTargetsEng.put(lineaDeInteres[1], 1);
					} else {
						numTargetsEng.put(lineaDeInteres[1], cant+1);
					}

					
				}
				
				
				
			}

			escEs.close();
			escEn.close();
			
			// Se han escrito los CSV, ahora computamos las estadísticas de estos
			
			// Primero con CSV con textos españoles
			
			// Calculo de media de palabras
			
			int suma = 0;
			int cuadrados = 0;
			double media;
			double desviacion;
			
			for (Integer num : numPalabrasEsp) {
				suma = suma + num;
			}
		
			
			media = (double) suma/numPalabrasEsp.size();
			
			// Calculo de desviación típica de palabras
			

			for (Integer num: numPalabrasEsp) {
				cuadrados = cuadrados + (num-(int)media)^2;
			}
			
			desviacion = (double) cuadrados / numPalabrasEsp.size();
			desviacion = Math.sqrt(desviacion);
			
			
			// Recuento de ocurrencias por label
			
			int i = 0;
			
			Integer[] lista = new Integer[numTargetsEsp.size()];
			for (Map.Entry<String, Integer> set : numTargetsEsp.entrySet()) {
				lista[i] = set.getValue();
				i++;
			}
			
			// Mostrar resultados
			
			System.out.println("Media de palabras en español por mensaje:"+media);
			System.out.println("Desviación de palabras en español por mensaje:"+desviacion);
			System.out.print("Num Targets: "); this.imprimirLista(lista);
			
			// Ahora con CSV con textos ingleses

			// Calculo de media
			
			suma = 0;
			cuadrados = 0;
	
			for (Integer num : numPalabrasEng) {
				suma = suma + num;
			}
		
			
			media = (double) suma/numPalabrasEng.size();
			
			
			// Calculo de desviación típica

			for (Integer num: numPalabrasEng) {
				cuadrados = cuadrados + (num-(int)media)^2;
			}
			
			desviacion = (double) cuadrados / numPalabrasEng.size();
			desviacion = Math.sqrt(desviacion);
			
			// Recuento de labels
			
			i = 0;
			
			lista = new Integer[numTargetsEng.size()];
			for (Map.Entry<String, Integer> set : numTargetsEng.entrySet()) {
				lista[i] = set.getValue();
				i++;
			}
			
			
			// Mostrar resultados
			
			System.out.println("Media de palabras en ingles por mensaje:"+media);
			System.out.println("Desviación de palabras en ingles por mensaje:"+desviacion);
			System.out.print("Num Targets: "); this.imprimirLista(lista);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private String tokenizar (String frase, String idioma) {
		
		/*
		  Pre: String
		  Post: La string recibe las siguientes modificaciones: 
		 
		  - Pasar a minuscula
		  - Eliminar palabras que empiecen @ o #
		  - Eliminar enlaces http / https
		  - Eliminar puntuacion y otros simbolos como emojis
		  - Respecto a comillas, manternerlas si hay texto a ambos lados de ella (como "it's" por ejemplo), pero
		    quitarlas si no hay texto al menos en uno de sus lados (como "hola 'Ivan'" pasa a "hola Ivan")
		  - Quitar tildes
		  - Arreglar espacios a solo uno por palabra 
		  
		  
		  
		  Nota: El paso de quitar las stopwords se hace durante el word embedding
		  
		 */
		String s = frase;

		s = s.replaceAll("@\\S*", "");     // Quitar menciones
		s = s.replaceAll("#\\S*", "");     // Quitar hashtags de otros posts
		s = s.replaceAll("http:\\S*", ""); // Quitar enlaces http
		s = s.replaceAll("https:\\S*", ""); // Quitar enlaces https
		s = s.replaceAll("[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]",""); // Eliminar caracteres raros como emojis. Fuente: https://stackoverflow.com/questions/49510006/remove-and-other-such-emojis-images-signs-from-java-strings  (mejor respuesta)
		s = s.replace('[', ' '); // Quitar puntuacion
		s = s.replace(']', ' ');
		s = s.replace('"', ' '); 
		s = s.replace('.', ' ');
		s = s.replace(',', ' ');
		s = s.replace(';', ' ');
		s = s.replace(':', ' ');
		s = s.replace('(', ' ');
		s = s.replace(')', ' ');
		s = s.replace('{', ' ');
		s = s.replace('}', ' ');
		s = s.replace('?', ' ');
		s = s.replace('¿', ' ');
		s = s.replace('!', ' ');
		s = s.replace('¡', ' ');
		s = s.replace('“', ' ');
		s = s.replace('”', ' ');
		s = s.replace('/', ' ');
		s = s.replace('━', ' ');
		s = s.replace('|', ' ');
		s = s.replace('-', ' ');
		s = s.replace('❝', ' ');
		s = s.replace('❞', ' ');
		s = s.replace('=', ' ');
		s = s.replace('$', ' ');
		s = s.replace('€', ' ');
		s = s.replace('%', ' ');
		s = s.replace('+', ' ');
		s = s.replace('*', ' ');
		s = s.replace('&', ' '); 
//		s = s.replace("[.,;:(){}?¿!¡“”/━|-❝❞=$€%+*&]", " ");
				
		s = s.replaceAll("’", "'"); // La lógica de lo de las comillas
		s = s.replaceAll("\\S'[^\\S]", " ");
		s = s.replaceAll("[^\\S]'\\S", " ");


		s = s.toLowerCase(); // Pasar a minuscula

		
		// Quitar tildes
		
		s = s.replace('á', 'a');
		s = s.replace('é', 'e');
		s = s.replace('í', 'i');
		s = s.replace('ó', 'o');
		s = s.replace('ú', 'u');
		
		
		// Quitar stopwords
		
		s = " " + s + " ";
		
		// " a b e " -> " a b e "
		
		if (idioma.contentEquals("es")) {
			
			for (String stopWord : this.lista2) {
				s = s.replaceAll(" "+stopWord + " ", " ");
				
			}
			
		} else {

			for (String stopWord : this.lista) {
				s = s.replaceAll(" "+stopWord + " ", " ");
				
			}
		}
		
		// REFERENCIA: https://www.ranks.nl/stopwords
		

		

		s = s.replaceAll("\\s+", " "); // Sustituir >1 espacios seguidos por un único espacio
		s = s.replaceAll("^\\S*", ""); // Quitar los espacios al principio del string
		

		



		

		
		
		return s;
		
	}
	
	
	private void imprimirLista (Integer[] lista) {
		
		// Pre: puntero a lista no null
		// Post: Imprimir la lista de forma legible al ser humano Y NO en forma de ID como hace java
		//      Ej.  [1, 3, 4, 4,]
		
		System.out.print("[");
		for (Integer num : lista) {
			System.out.print(num + ", ");
		}
		
		System.out.println("]");

	}
	

	
}

