package org.generation;

import java.util.Scanner;

public class UsoScanner {

	public static void main(String[] args) {
		// La clase scanner nos sirve para
		// escanerar un input, como puede ser la termina.
		
		// 1.- Crear una variable de tipo Scanner
		// 2.- Importar la clase Scanner del paquete java.util.Scanner
		Scanner myScan;
		
		// 3.- Instanciar un objeto de la clase Scanner
		// 4.- Indicar que la entrada será de System.in (consola)
		myScan = new Scanner( System.in );
		
		System.out.println("Escribe tu nombre: ");
		String myName = myScan.nextLine();
		System.out.println("Tu nombre es: " + myName);

				
				
				
				
				
				
				
				
				
	}

}
