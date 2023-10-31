package mineria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

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
	        
	        lista.add("amp");
	        lista.add("just");
	        lista.add("get");
	        lista.add("gets");
	        lista.add("one");
	        lista.add("u");
	        lista.add("will");
	        lista.add("now");
	        lista.add("say");
	        lista.add("says");
	        lista.add("got");
	        lista.add("see");
	        lista.add("sees");
	        lista.add("know");
	        lista.add("like");
	        lista.add("day");
	        lista.add("days");
	        lista.add("y'all");
	        lista.add("many");
	        lista.add("still");
	        lista.add("really");
	        lista.add("us");
	        lista.add("look");
	        lista.add("looks");
	        lista.add("even");
	        lista.add("time");
	        lista.add("never");
	        lista.add("said");
	        lista.add("go");
	        lista.add("even");
	        lista.add("thing");
	        lista.add("always");
	        lista.add("usually");
	        lista.add("lot");
	        lista.add("things");
	        lista.add("lots");
	        lista.add("every");
	        lista.add("today");
	        lista.add("think");
	        lista.add("thinks");
	        lista.add("every");
	        lista.add("way");
	        lista.add("much");
	        lista.add("many");


	      
	        lista2.add("un");
	        lista2.add("una");
	        lista2.add("unas");
	        lista2.add("unos");
	        lista2.add("uno");
	        lista2.add("sobre");
	        lista2.add("todo");
	        lista2.add("tambien");
	        lista2.add("tras");
	        lista2.add("otro");
	        lista2.add("algun");
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
	        lista2.add("por que");
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
	        
	        
	        lista2.add("de");
	        lista2.add("que");
	        lista2.add("y");
	        lista2.add("a");
	        lista2.add("se");
	        lista2.add("te");
	        lista2.add("mas");
	        lista2.add("son");
	        lista2.add("le");
	        lista2.add("q");
	        lista2.add("tu");
	        lista2.add("al");
	        lista2.add("ni");
	        lista2.add("del");
	        lista2.add("o");
	        lista2.add("son");
	        lista2.add("hay");
	        lista2.add("les");
	        lista2.add("el");
	        lista2.add("la");
	        lista2.add("me");
	        lista2.add("mi");
	        lista2.add("hasta");
	        lista2.add("este");
	        lista2.add("cosas");
	        lista2.add("tan");
	        lista2.add("estas");
	        lista2.add("haciendo");
	        lista2.add("esto");
	        lista2.add("ya");
	        lista2.add("nada");
	        lista2.add("esa");
	        lista2.add("siempre");
	        lista2.add("todos");
	        lista2.add("eso");
	        lista2.add("ella");
	        lista2.add("ese");
	        lista2.add("nadie");
	        lista2.add("d");
	        lista2.add("todas");
	        lista2.add("ahora");
	        lista2.add("dice");
	        lista2.add("tus");
	        lista2.add("otra");     
	        lista2.add("sea");
	        lista2.add("algo");
	        lista2.add("estar");
	        lista2.add("yyy");
	        lista2.add("asi");
	        lista2.add("he");
	        lista2.add("dia");
	        lista2.add("decir");
	        lista2.add("han");
	        lista2.add("hoy");
	        lista2.add("dias");       
	        lista2.add("igual");
	        lista2.add("vez");
	        lista2.add("da");
	        lista2.add("pues");
	        lista2.add("ja");
	        lista2.add("mucho");
	        lista2.add("medio");
	        lista2.add("dias");
	        
		
	}
	
	
	public static ConvertidorDeDatos getConvertidor() {
		if (ConvertidorDeDatos.c == null) {
			ConvertidorDeDatos.c = new ConvertidorDeDatos();
		}
		
		return ConvertidorDeDatos.c;
	}
	
	
	public void añadirFrases() {
		
		Scanner sc2 = new Scanner(System.in);
		Charset charset = Charset.forName("UTF-8");
		File file = new File("."+File.separator+"datos"+File.separator+"test.csv");
	 	FileWriter oFile;
	 	CSVWriter esc = null;
	 	
	 	System.out.println("Elige el idioma en el que vas a meter tweets: 0 = Español | 1 = Inglés | 2 = Otro");
	 	
	 	try {
		 	
	 		int resp = sc2.nextInt();
	 		sc2.nextLine();
		 	String idioma;
	 		if (resp == 0) {
	 			idioma = "es";
	 		} else if (resp == 1) {
	 			idioma = "en";
	 		} else {
	 			idioma = "x";
	 		}
	 		
		 	
			

			try {
				oFile = new FileWriter(file, charset);
				esc = new CSVWriter(oFile); // Escribir a fichero de datos en Inglés
				
				// Escribir la cabecera de los CSV de salida
				
				String[] cabecera = {"Texto", "TextoOriginal"};
				esc.writeNext(cabecera);

				boolean seguir = true;
				
				while (seguir) {	
					System.out.println("Introduce el texto a analizar:");
					String texto = sc2.nextLine();

					
					String[] input = new String[2];
					input[1] = texto;

					input[0] = this.tokenizar(texto, idioma);


					esc.writeNext(input);

					System.out.println("¿Deseas seguir añadiendo frases? 1 = Sí, 0 = No");
				    seguir = sc2.nextInt() == 1;
				    sc2.nextLine();					

					
				}
				
				
			} catch (Exception e) {}

			
			try {
				esc.close();
			} catch (IOException e) {

			}
			

			System.out.println("Ejecución acabada. Se han guardado las instancias en el fichero 'test.csv' dentro de la carpeta 'datos'.");
		 	
	 		
	 	} catch (Exception e) {	System.out.println("ERROR: valor no númerico dado, abortando...");}

		
	}
	
	public void leerMuestraTrain() {
		// Pre: EXIST2021_training.csv [test_case,id,source,language,text,task1,task2]
		// Post: trainEsp.csv [text, task2], trainEng.csv [text, task2](una por idioma)
		// Extra: - Calculo de media de palabras y desviacion tipica de ellas por lenguaje
		//        - Cantidad de mensajes por label, por lenguaje


		// Ayudas sacadas de -> https://www.javatpoint.com/how-to-read-csv-file-in-java (leer de CSV)
		//                      https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/ (escribir a CSV)
		
		
		try {
			
			System.out.println("Leyendo archivo .csv ...");
			
			// Variables para calcular estadísticas de la muestra
			
			ArrayList<Integer> numPalabrasEsp = new ArrayList<Integer>();
			ArrayList<Integer> numPalabrasEng = new ArrayList<Integer>();
			HashMap<String, Integer> numTargetsEsp = new HashMap<String, Integer>();
			HashMap<String, Integer> numTargetsEng = new HashMap<String, Integer>();
			HashSet<String> yaRecogidos = new HashSet<String>();
			HashSet<String> yaRecogidosOG = new HashSet<String>(); 
			HashMap<String, Integer> numRepetidosOG = new HashMap<String, Integer>();

			Charset charset = Charset.forName("UTF-8");
			
			// Preparar el CSV de entrada para leer linea a linea
			
			Scanner sc = new Scanner(new File("."+File.separator+"datos"+File.separator+"EXIST2021_training.csv"), charset);
			sc.useDelimiter("\n");
			
			// Preparar los descriptores para escribir ambos CSV de salida (el de Español e Ingles)
			
			File file = new File("."+File.separator+"datos"+File.separator+"trainEsp.csv");
			FileWriter oFile = new FileWriter(file, charset);
			CSVWriter escEs = new CSVWriter(oFile); // Escribir a fichero de datos en Castellano
			
			file = new File("."+File.separator+"datos"+File.separator+"trainEng.csv");
			oFile = new FileWriter(file, charset);
			CSVWriter escEn = new CSVWriter(oFile); // Escribir a fichero de datos en Inglés
		
			// Escribir la cabecera de los CSV de salida
			
			String[] cabecera = {"Texto", "Target", "TextoOriginal"};
			escEs.writeNext(cabecera);
			escEn.writeNext(cabecera);
			
			System.out.println("Preprocesando...");

			sc.next();
			
			while (sc.hasNext()) {
				
				// Por cada linea, recogerla y...
				String linea = sc.next();
				
				// Dividir por campos (en CSV se usa ',').
				
				String[] apartados = linea.split(",");
				String[] lineaDeInteres = new String[3];
				
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
				
				lineaDeInteres[2] = lineaDeInteres[0]; // guardar el valor del texto original
				
				// Recoger el cuarto campo porque este indica el idioma
				
				String idioma = apartados[3];
				
				// Tokenizar el texto
				
				lineaDeInteres[0] = this.tokenizar(lineaDeInteres[0], idioma); 			
				
				// El segundo campo a recoger es el label puesto en el experimento, este siempre es el ultimo campo
				
				lineaDeInteres[1] = apartados[apartados.length-1];
				
				// Eliminar el ultimo caracter que representa el salto de linea en si
				
				lineaDeInteres[1] = lineaDeInteres[1].substring(0, lineaDeInteres[1].length() - 1);


				
				/* Dependiendo del idioma, las operaciones las hacemos sobre sus estructuras de datos correspondientes:
				 
				  - Los dos datos recogidos previamente se escriben en su CSV de salida
				  - Se hace +1 a la cantidad de labels de ese tipo encontrado en ese idioma
				  
				  
				 */
				
				// Solo meter a la muestra frases que tengan 4 o mas tokens y que no se hayan recogido ya
				// (puede haber tweets repetidos, si los hay, solo recoger el primer ejemplar)
				
				if (lineaDeInteres[0].split(" ").length > 3 && !yaRecogidos.contains(lineaDeInteres[0])) {
					yaRecogidos.add(lineaDeInteres[0]);
					if (idioma.contentEquals("es")) {
						escEs.writeNext(lineaDeInteres);
						System.out.println("En Español -> "+lineaDeInteres[0]+" | "+lineaDeInteres[1]);
						
						
						numPalabrasEsp.add(lineaDeInteres[0].split(" ").length);
						
						Integer cant = numTargetsEsp.get(lineaDeInteres[1]);
						if (cant == null) {
							numTargetsEsp.put(lineaDeInteres[1], 1);
						} else {
							numTargetsEsp.put(lineaDeInteres[1], cant+1);	

						}
						

					} else {
						escEn.writeNext(lineaDeInteres);
						System.out.println("En Inglés -> "+lineaDeInteres[0]+" | "+lineaDeInteres[1]);
						
						
						numPalabrasEng.add(lineaDeInteres[0].split(" ").length);
						
						Integer cant = numTargetsEng.get(lineaDeInteres[1]);
						if (numTargetsEng.get(lineaDeInteres[1]) == null) {
							numTargetsEng.put(lineaDeInteres[1], 1);
						} else {
							numTargetsEng.put(lineaDeInteres[1], cant+1);
						}

						
					}
				} 
				
				// Para estadísticas de tweets repetidos, contar los tweets.
				
				if (!yaRecogidosOG.contains(lineaDeInteres[2])) {
					yaRecogidosOG.add(lineaDeInteres[2]);
					
				} else {
					if (!numRepetidosOG.containsKey(lineaDeInteres[2])) {
						numRepetidosOG.put(lineaDeInteres[2], 2);
					} else {
						numRepetidosOG.put(lineaDeInteres[2], numRepetidosOG.get(lineaDeInteres[2])+1);
						
					}
					
				}
				
				

				
				
				
			}
			
			

			
			

			escEs.close();
			escEn.close();
			
			System.out.println("¡Preproceso completado!");

			
			// Se han escrito los CSV, ahora computamos las estadísticas de estos
			
			// Primero con CSV con textos españoles
			
			// Calculo de media de palabras
			
			int suma = 0;
			double cuadrados = 0;
			double media;
			double desviacion;
			
			for (Integer num : numPalabrasEsp) {
				suma = suma + num;
			}
		
			
			media = (double) suma/numPalabrasEsp.size();
			
			// Calculo de desviación típica de palabras
			

			for (Integer num: numPalabrasEsp) {
				cuadrados = cuadrados + Math.pow(num-media, 2);
			}
			
			
			
			desviacion = (double) cuadrados / numPalabrasEsp.size();
			desviacion = Math.sqrt(desviacion);
			
			
			// Recuento de ocurrencias por label
			
			int i = 0;
			
			Integer[] lista = new Integer[numTargetsEsp.size()];
			String [] lista2 = new String[numTargetsEng.size()];

			for (Map.Entry<String, Integer> set : numTargetsEsp.entrySet()) {
				lista[i] = set.getValue();
				lista2[i] = set.getKey();
				i++;
			}
			
			// Mostrar resultados
			System.out.println("Estadísticas de las muestras tokenizadas obtenidas:");
			System.out.println();
			System.out.println("Idioma: Español");
			System.out.println("Media de número de tokens por mensaje: "+media);
			System.out.println("Desviación típica de tokens por mensaje: "+desviacion);
			System.out.print("Num labels: "); this.imprimirLista(lista);
			System.out.print("Labels: "); this.imprimirLista(lista2); 
			
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
				cuadrados = cuadrados + Math.pow(num-media, 2);
			}
			
			desviacion = (double) cuadrados / numPalabrasEng.size();
			desviacion = Math.sqrt(desviacion);
			
			// Recuento de labels
			
			i = 0;
			
			lista = new Integer[numTargetsEng.size()];
			lista2 = new String[numTargetsEng.size()];
			for (Map.Entry<String, Integer> set : numTargetsEng.entrySet()) {
				lista[i] = set.getValue();
				lista2[i] = set.getKey();
				i++;
			}
			
			
			// Mostrar resultados
			
			System.out.println();
			System.out.println("Idioma: Inglés");
			System.out.println("Media de número de tokens por mensaje: "+media);
			System.out.println("Desviación típica de tokens por mensaje: "+desviacion);
			System.out.print("Num labels: "); this.imprimirLista(lista);
			System.out.print("Labels: "); this.imprimirLista(lista2); 

			System.out.println();
			
			
			// Mostrar cantidad de textos originales repetidos
			
			System.out.println("De la muestra original, se han encontrado los siguientes textos duplicados:");
			
			int[] cantDups = new int[12];
			
			for (i = 0; i != 4; i++) {
				cantDups[i] = 0;
			}
			
			for (Map.Entry<String, Integer> set : numRepetidosOG.entrySet()) {
				cantDups[set.getValue()-2]++;
			}
			
			for (i = 0; i != 12; i++) {
				System.out.println("Cantidad de textos repetidos "+(i+2)+ " veces: "+cantDups[i]);
			}			

			
			System.out.println("El texto repetido más veces es:");
			
			for (Map.Entry<String, Integer> set : numRepetidosOG.entrySet()) {
				if (set.getValue() == 13) {
					System.out.println(set.getKey());
				}
			}			
			System.out.println();
			System.out.println("Ejecución acabada. Los archivos respectivos ya se han colocado en la carpeta 'datos'");

			
		} catch (FileNotFoundException e) {
			System.out.println("¡ERROR! Pon EXIST2021_training.csv crea una carpeta llamada 'datos' en el mismo directorio que este jar y mete el archivo EXIST2021_training.csv en esa carpeta creada para poder realizar el preproceso");
		//	e.printStackTrace();
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
		

		if (idioma.contentEquals("es")) {
			
			// Repetir el bucle dos veces para que encuentre la misma stopword repetida dos veces seguida		
			
			
			
			for (String stopWord : this.lista2) {
				s = s.replaceAll(" "+stopWord + " ", " ");
				
			}
			
			for (String stopWord : this.lista2) {
				s = s.replaceAll(" "+stopWord + " ", " ");
				
			}
			

			
		} else if (idioma.contentEquals("en")) {


			for (String stopWord : this.lista) {
				s = s.replaceAll(" "+stopWord + " ", " ");
				
			}
			
			for (String stopWord : this.lista) {
				s = s.replaceAll(" "+stopWord + " ", " ");
				
			}
		}
		
		// REFERENCIA: https://www.ranks.nl/stopwords
		

		// Eliminar primer y ultimo caracter, que son espaicos en blanco 
		


		s = s.replaceAll("\\s+", " "); // Sustituir >1 espacios seguidos por un único espacio

	//	s = s.substring(1, s.length() - 1);
		
		

		



		

		
		
		return s;
		
	}
	
	
	private void imprimirLista (Object[] lista) {
		
		// Pre: puntero a lista no null
		// Post: Imprimir la lista de forma legible al ser humano Y NO en forma de ID como hace java
		//      Ej.  [1, 3, 4, 4,]
		
		System.out.print("[");
		for (Object num : lista) {
			System.out.print(num + ", ");
		}
		
		System.out.println("]");

	}
	

	
}

