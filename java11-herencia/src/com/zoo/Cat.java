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
	

	
	

}
