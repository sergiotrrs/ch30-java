package com.zoo;

public class Cat extends Feline {
	
	private boolean wild;

	public Cat(String name, boolean wild) {
		super(name, "savannah", 30, "beige");
		this.wild = wild;	
	}

	public boolean isWild() {
		return wild;
	}

	public void setWild(boolean wild) {
		this.wild = wild;
	}

	public String purr() {
		return "purr purr purrrrrs";
	}
	

	@Override
	public String eat(String food) {
		return "El ser supremo " + super.getName() + " come " + food;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( super.toString()  );		
		builder.append("\n\tCat [wild=");
		builder.append( isWild() );
		builder.append(", hasNightVision=");
		builder.append(hasNightVision());
		builder.append(", HairColor=");
		builder.append(getHairColor());
		builder.append("]");
		return builder.toString();
	}

}
