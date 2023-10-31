package mineria;
import java.util.Scanner;




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
