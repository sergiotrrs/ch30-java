package org.generation;

import com.zoo.Animal;
import com.zoo.Cat;
import com.zoo.Lion;

public class AnimalTest {

	public static void main(String[] args) {
		
		Lion simba = new Lion("Simba", 5);
		Lion mufasa = new Lion("Mufasa", 40);
		Cat nico = new Cat("Nico", false);
		Cat endora = new Cat("Endora", false);
		Cat michi = new Cat("Michi", true);
		
		System.out.println( simba.eat("insectos, viscosos pero sabrosos") );
		System.out.println( nico.eat("croquetas de carne y jugo") );
		System.out.println( nico.eat() );

		System.out.println( mufasa );
		System.out.println( endora );
	}

}
