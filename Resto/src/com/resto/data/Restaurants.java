package com.resto.data;

public class Restaurants {
	
	private int Restaurant_ID;
	private String Restaurant_NAME;
	private String Restaurant_EMAIL;
	private String Restaurant_WEBSITE;
	private String Restaurant_IMAGE_NAME;
	private byte[] Restaurant_IMAGE;
	
	
	public int getRestaurant_ID() {
		return Restaurant_ID;
	}
	public void setRestaurant_ID(int restaurant_ID) {
		Restaurant_ID = restaurant_ID;
	}
	public String getRestaurant_NAME() {
		return Restaurant_NAME;
	}
	public void setRestaurant_NAME(String restaurant_NAME) {
		Restaurant_NAME = restaurant_NAME;
	}
	public String getRestaurant_EMAIL() {
		return Restaurant_EMAIL;
	}
	public void setRestaurant_EMAIL(String restaurant_EMAIL) {
		Restaurant_EMAIL = restaurant_EMAIL;
	}
	public String getRestaurant_WEBSITE() {
		return Restaurant_WEBSITE;
	}
	public void setRestaurant_WEBSITE(String restaurant_WEBSITE) {
		Restaurant_WEBSITE = restaurant_WEBSITE;
	}
	public String getRestaurant_IMAGE_NAME() {
		return Restaurant_IMAGE_NAME;
	}
	public void setRestaurant_IMAGE_NAME(String restaurant_IMAGE_NAME) {
		Restaurant_IMAGE_NAME = restaurant_IMAGE_NAME;
	}
	public byte[] getRestaurant_IMAGE() {
		return Restaurant_IMAGE;
	}
	public void setRestaurant_IMAGE(byte[] restaurant_IMAGE) {
		Restaurant_IMAGE = restaurant_IMAGE;
	}


}
