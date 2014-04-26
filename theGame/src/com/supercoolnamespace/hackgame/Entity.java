package com.supercoolnamespace.hackgame;

import android.graphics.Canvas;

public abstract class Entity {
	protected float x; 
	protected float y; 
	protected float rotation;
	

	public abstract void draw(Canvas c);

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

}
