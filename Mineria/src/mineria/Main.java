package mineria;
import java.util.Scanner;

import weka.*;

/*
 
 
  
 
 LIBRERIAS WEKA NO ESTAN EN LAS LIBRERIAS DE ECLIPSE POR DEFECTO
 POR LO QUE EL IMPORT WEKA PUEDE QUE OS DE ERROR
 (SI NO OS DA ERROR, ESO QUIERE DECIR QUE GITHUB HA SUBIDO EL
 CLASSPATH ARREGLADO TMB Y NO TENDREIS QUE TOCAR NADA YA Y PUEDES 
 DEJAR DE LEER) SI OS DA ERROR EL IMPORT DE LA LINEA DE ARRIBA, ENTONCES:
 
 PARA ARREGLAR, SIGUE LOS SIGUIENTES PASOS (SON LOS PASOS PARA AÑADIR
 UNA LIBRERIA EXTERNA COMO PROBABLEMENTE TUVISTEIS QUE HACER CON
 EL CONTROLADOR SQL EN SISTEMAS WEB):
 
 
 
  - Click derecho en "Mineria" en la pestaña de la izquierda de Project Explorer
  - Opcion Build Path (esta por el medio)
  - Pestaña Libraries
  - Clicka en ClassPath y dale a add External Jars
  - Selecciona Weka.jar que esta en el directorio lib de este mismo proyecto
    (ya he encontrado la libreria yo y la he subido a este mismo repositorio)
  - Apply and Close
  
  Y con eso deberia arreglarse el error y poder empezar a usar librerias weka
  
  
  
  
  
  
 */


public class Main {

	
	public static void main (String args[]) {
		
		System.out.println("¿Quieres procesar la muestra train o añadir tus propios textos? 1 = Train, 0 = Propios");
		
		try {
			Scanner sc2 = new Scanner(System.in);
			boolean resp = sc2.nextInt() == 1;

					
			if (resp) {
				ConvertidorDeDatos.getConvertidor().leerMuestraTrain();

				
			} else {
				ConvertidorDeDatos.getConvertidor().añadirFrases();
				
			}			
		} catch (Exception e) {System.out.println("ERROR: caracter no numérico recogido, abortando...");}
	
	}
}
