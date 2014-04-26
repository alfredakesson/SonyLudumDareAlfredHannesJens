package com.supercoolnamespace.hackgame;

public abstract class Entity {
	float x; 
	float y; 
	
	public void setX(float newX){
		this.x = newX;
	}
	
	public void setY(float newY){
		this.y = newY;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public abstract void draw();
}
