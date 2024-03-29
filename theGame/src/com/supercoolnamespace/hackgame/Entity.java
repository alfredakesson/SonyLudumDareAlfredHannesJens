package com.supercoolnamespace.hackgame;

import android.graphics.Canvas;

public abstract class Entity {
	protected float x; 
	protected float y; 
	protected float rotation;
	
	protected float opacity;
	
	public Entity(float x, float y){
		this.x = x;
		this.y = y;
		opacity = 1;
	}
	

	public abstract void draw(Canvas c, Offset theDrawOffset);

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

	public float getRotation() {
		// TODO Auto-generated method stub
		return rotation;
	}

	public void setRotation(float newRotation) {
		this.rotation = newRotation;
	}


	public float getOpacity() {
		// TODO Auto-generated method stub
		return opacity;
	}
	
	public void setOpacity(float newOpacity){
		this.opacity = newOpacity;
	}
	

}
