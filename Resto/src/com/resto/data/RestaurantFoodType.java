package com.resto.data;

public class RestaurantFoodType {
	
	private int Restaurant_ID;
	private int FoodType_ID;
	private String FoodType_Name;
	
	
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
	public String getFoodType_Name() {
		return FoodType_Name;
	}
	public void setFoodType_Name(String foodType_Name) {
		FoodType_Name = foodType_Name;
	}



}
