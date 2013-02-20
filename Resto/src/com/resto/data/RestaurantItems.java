package com.resto.data;

public class RestaurantItems {
	private int Restaurant_ID;
	private int FoodType_ID;
	private int Category_ID;
	private int  Item_ID;
	private String  Item_Name;
	private double  Item_Price;
	private String  Item_Descr;
	private double  Item_Tax_Amount;
	
	public int getRestaurant_ID() {
		return Restaurant_ID;
	}
	public void setRestaurant_ID(int restaurant_ID) {
		Restaurant_ID = restaurant_ID;
	}
	public int getFoodType_ID() {
		return FoodType_ID;
	}
	public void setFoodType_ID(int foodType_ID) {
		FoodType_ID = foodType_ID;
	}
	public int getCategory_ID() {
		return Category_ID;
	}
	public void setCategory_ID(int category_ID) {
		Category_ID = category_ID;
	}
	public int getItem_ID() {
		return Item_ID;
	}
	public void setItem_ID(int item_ID) {
		Item_ID = item_ID;
	}
	public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}
	public double getItem_Price() {
		return Item_Price;
	}
	public void setItem_Price(double item_Price) {
		Item_Price = item_Price;
	}
	public String getItem_Descr() {
		return Item_Descr;
	}
	public void setItem_Descr(String item_Descr) {
		Item_Descr = item_Descr;
	}
	public double getItem_Tax_Amount() {
		return Item_Tax_Amount;
	}
	public void setItem_Tax_Amount(double item_Tax_Amount) {
		Item_Tax_Amount = item_Tax_Amount;
	}


}
