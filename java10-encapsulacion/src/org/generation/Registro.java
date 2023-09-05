package org.generation;

import java.util.Scanner;

public class Registro {

	public static void main(String[] args) {
		
		try {
		Scanner sc = new Scanner( System.in );
		
		System.out.print("Escribe tu nombre: ");
		String name = sc.nextLine();
		
		System.out.print("Escribe tu edad: ");
		int age = sc.nextInt();
		sc.nextLine();		
			
		System.out.println("Registro exitoso: " + ageVerifier( age ));
		sc.close();
		} catch (IllegalStateException e) {
			System.out.println("Por favor verifica la entrada");
			e.printStackTrace();
			System.out.println("El registro no fue exitoso");
		}
	}
	
	private static boolean ageVerifier ( int age) {
		if (age<18) {
			// System.out.println("No es mayor de edad");
			throw new IllegalStateException("No es mayor de edad");
			
		}
		return true;
	}

}
