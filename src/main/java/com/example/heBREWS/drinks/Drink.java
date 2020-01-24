package com.example.heBREWS.drinks;

public class Drink {

	private String name;
	private int quantity;

	public Drink(){ }

	public String getName(){
		return name;
	}
	public void setName( String name ){
		this.name = name;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setQuantity( int quantity ) {
		this.quantity = quantity;
	}

	public void addQuantity( int quantity ) {
		this.quantity = this.quantity + quantity;
	}

	public void subtractQuantity( int quantity ) {
		this.quantity = this.quantity - quantity;
	}

}
