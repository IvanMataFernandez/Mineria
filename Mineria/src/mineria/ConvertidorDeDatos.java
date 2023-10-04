package mineria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVWriter;

public class ConvertidorDeDatos {

	private static ConvertidorDeDatos c;
	
	private ConvertidorDeDatos() {}
	
	
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
				
				// Tokenizar el texto
				
				lineaDeInteres[0] = this.tokenizar(lineaDeInteres[0]); 			
				
				// El segundo campo a recoger es el label puesto en el experimento, este siempre es el ultimo campo
				
				lineaDeInteres[1] = apartados[apartados.length-1];
				
				// Recoger el cuarto campo porque este indica el idioma
				
				String idioma = apartados[3];
				
				/* Dependiendo del idioma, las operaciones las hacemos sobre sus estructuras de datos correspondientes:
				 
				  - Los dos datos recogidos previamente se escriben en su CSV de salida
				  - Se hace +1 a la cantidad de labels de ese tipo encontrado en ese idioma
				  
				  
				 */
				
				if (idioma.contentEquals("es")) {
					escEs.writeNext(lineaDeInteres);
				//	System.out.println("En Español -> "+lineaDeInteres[0]+" | "+lineaDeInteres[1]);
					
					
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
	
	
	private String tokenizar (String frase) {
		
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




		s = s.replaceAll("\\s+", " "); // Sustituir >1 espacios seguidos por un único espacio
		s = s.replaceAll("^\\S*", ""); // Quitar los espacios al principio del string
		
		s = s.toLowerCase(); // Pasar a minuscula
		
		// Quitar tildes
		
		s = s.replace('á', 'a');
		s = s.replace('é', 'e');
		s = s.replace('í', 'i');
		s = s.replace('ó', 'o');
		s = s.replace('ú', 'u');
		
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

