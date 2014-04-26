package com.supercoolnamespace.hackgame;

import java.util.ArrayList;

import android.graphics.Canvas;

public class SuperTween extends Entity{
	
	private ArrayList<SquareEntity> updateSquares;

	public SuperTween(float x, float y, ArrayList<SquareEntity> updateSquares) {
		super(x, y);
		
		this.updateSquares = updateSquares;
	}

	@Override
	public void draw(Canvas c) {
		
		
	}
	
	
	public void setX(float newX){
		if(newX > x){
			for(SquareEntity se: updateSquares){
				se.setX(se.getX() + newX - x);
			}
		}
	}

}
