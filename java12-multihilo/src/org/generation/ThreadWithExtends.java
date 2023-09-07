package org.generation;

class Iteration {
	private String name;
	
	public Iteration(String name) {
		this.name = name;
	}
	
	public void numberOfIteration( int number) {
		for (int i = 0; i < number; i++) {
			System.out.println("Obj: " + this.name  + ", iteration: " + i );			
		}
	}
	
}


public class ThreadWithExtends {
	
	public static void main(String[] args) {
		Iteration it01 = new Iteration("iteración 01");
		Iteration it02 = new Iteration("iteración 02");
		Iteration it03 = new Iteration("iteración 03");
		
		it01.numberOfIteration(5);
		it02.numberOfIteration(5);
		it03.numberOfIteration(5);		
	}


}
