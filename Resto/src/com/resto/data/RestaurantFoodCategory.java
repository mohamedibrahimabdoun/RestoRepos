package com.resto.data;

public class RestaurantFoodCategory {
	private int Restaurant_ID;
	private int FoodType_ID;
	private int Category_ID;
	private String  Category_NAME;
	
	
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
	public String getCategory_NAME() {
		return Category_NAME;
	}
	public void setCategory_NAME(String category_NAME) {
		Category_NAME = category_NAME;
	}


}
