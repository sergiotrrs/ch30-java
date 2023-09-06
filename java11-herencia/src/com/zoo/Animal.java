package com.zoo;

public class Animal {
	
	private String name;
	private String habitat;
	private double lifespan;
	
	public Animal(String name, String habitat, double lifespan) {		
		this.name = name;
		this.habitat = habitat;
		this.lifespan = lifespan;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getHabitat() {
		return habitat;
	}

	protected void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	protected double getLifespan() {
		return lifespan;
	}

	protected void setLifespan(double lifespan) {
		this.lifespan = lifespan;
	}
	
	public String eat(String food) {
		return "El animal " + getName() + " está comiendo " + food;
	}
	

}
