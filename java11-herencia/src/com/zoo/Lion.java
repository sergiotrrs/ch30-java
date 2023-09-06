package com.zoo;

public class Lion extends Feline {
	
	private int maneSize;

	public Lion(String name, int maneSize) {
		super(name, "savannah", 30, "beige");
		this.maneSize = maneSize;		
	}

	public int getManeSize() {
		return maneSize;
	}

	public void setManeSize(int maneSize) {
		this.maneSize = maneSize;
	}
	
	

}
