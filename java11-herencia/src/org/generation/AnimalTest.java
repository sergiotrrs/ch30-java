package org.generation;

import java.util.ArrayList;
import java.util.List;

import com.zoo.*;

public class AnimalTest {

	public static void main(String[] args) {
		
		Lion simba = new Lion("Simba", 5);
		Lion mufasa = new Lion("Mufasa", 40);
		Cat nico = new Cat("Nico", false);
		Cat endora = new Cat("Endora", false);
		Cat michiSalvaje = new Cat("Michi", true);
		
		System.out.println( simba.eat("insectos, viscosos pero sabrosos") );
		System.out.println( nico.eat("croquetas de carne y jugo") );
		System.out.println( nico.eat() );

		System.out.println( mufasa );
		System.out.println( endora );
		
		ArrayList< Animal > noahsArk = new ArrayList<>();
		noahsArk.add(simba);
		noahsArk.add(mufasa);
		noahsArk.add(nico);
		noahsArk.add(endora);
		noahsArk.add(michiSalvaje);		
		showEat( noahsArk );
		
	} // cierre de main
	
	public static void showEat( ArrayList<Animal> animals ) {
		for (Animal animal : animals) {
			System.out.println( animal.eat("cacahuates") );
			System.out.println( animal.sleep() );
			
			if ( animal instanceof Cat )
				System.out.println( ((Cat)animal).purr() );
		}
	}

} // cierre de clase
