package com.supercoolnamespace.hackgame;

import android.graphics.Point;
import android.util.Log;
import entities.BlueFabric;
import entities.RedFabric;

public class Offset {
	private int groundLevel;
	private float multiplier;
	private int nbrStep = 5;
	public Offset(BlueFabric blueHause, Point displaySize) {
		groundLevel = 0;
		
		float xDisp = (float)displaySize.x;
		float blueX = (blueHause.getX() + blueHause.getOffset());
		float tot = xDisp - blueX;
		multiplier = tot / nbrStep; 
	}
	
	public void increment(int value){
		groundLevel += value;
	}
	
	public void decrease(int value){
		groundLevel += value;
	}
	
	public float getOffset() {
		Log.d("WTF", "kommer hit!");
		return multiplier * groundLevel;
	}
	

}
