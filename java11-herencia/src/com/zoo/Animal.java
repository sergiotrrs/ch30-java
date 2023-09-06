package com.zoo;

public class Animal {
	
	private String name;
	private String habitat;
	private double lifespan;
	
	protected Animal(String name, String habitat, double lifespan) {		
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
	
	public String eat() {
		return "El animal " + getName() + " come";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyAnimal [name=");
		builder.append(name);
		builder.append(", habitat=");
		builder.append(habitat);
		builder.append(", lifespan=");
		builder.append(lifespan);
		builder.append("]");
		return builder.toString();
	}

	
//	@Override
//	public String toString() {
//		return "Animal [name=" + name + ", habitat=" + habitat + ", lifespan=" + lifespan + "]";
//	}

	

}
