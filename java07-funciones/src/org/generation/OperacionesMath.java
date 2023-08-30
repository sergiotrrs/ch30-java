package org.generation;

public class OperacionesMath {
	
	// atributos de instancia ( non-static fields)
	String name;
	// atributos de clase (static fields)	
	
	// métodos de instancia	
	 void sumaEnterosSinRetorno(int a , int b  ){
		System.out.println("Resultado de "+ name +" : " + ( a + b));	
	}
	 
	// método de instancia que calcule la suma de 2 números double.
	// el retorno debe ser double
	 double addDouble(double a, double b) {
			return a + b;
		}
	 
	 
	
	// ============= métodos de clase (static methods) ==========
	/* Los métodos estáticos se relacia la clase en lugar de las
	 * instancias.
	 * Se puede invocar sin tener que instanciar un objeto.
	 * 
	 */
	static double valorPi(){
		double pi = Math.PI;
		return pi;
	}
	
	// Hacer un método estático que reciba 1 parámetro
	// y retorne la raíz cuadrada de ese valor.
	static double raiz(double num) {
		return Math.sqrt(num);
	}
	

}
