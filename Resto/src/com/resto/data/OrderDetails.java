package com.resto.data;

public class OrderDetails {
	private int  Order_ID;
	private int Restaurant_ID;
	private int FoodType_ID;
	private int Category_ID;
	private int  Item_ID;
	private double  Item_Price;
	private int  Items_Quantity;
	private double  Items_Total_Price;
	private double  Items_TotalPriceWithTax;
	public int getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}
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
	public double getItem_Price() {
		return Item_Price;
	}
	public void setItem_Price(double item_Price) {
		Item_Price = item_Price;
	}
	public int getItems_Quantity() {
		return Items_Quantity;
	}
	public void setItems_Quantity(int items_Quantity) {
		Items_Quantity = items_Quantity;
	}
	public double getItems_Total_Price() {
		return Items_Total_Price;
	}
	public void setItems_Total_Price(double items_Total_Price) {
		Items_Total_Price = items_Total_Price;
	}
	public double getItems_TotalPriceWithTax() {
		return Items_TotalPriceWithTax;
	}
	public void setItems_TotalPriceWithTax(double items_TotalPriceWithTax) {
		Items_TotalPriceWithTax = items_TotalPriceWithTax;
	}
	

}
