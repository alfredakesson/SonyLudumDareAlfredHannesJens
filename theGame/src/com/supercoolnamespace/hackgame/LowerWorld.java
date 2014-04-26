package com.supercoolnamespace.hackgame;

import java.util.LinkedList;

import android.content.Context;
import android.graphics.Point;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class LowerWorld extends World{

	public LowerWorld(Context context, Point displaySize){
		this.displaySize = displaySize;
		squareList = new LinkedList<SquareEntity>();
		Tween.registerAccessor(Entity.class, new EntityTweener());
		this.context = context;
		manager = new TweenManager();
		newSquare();
	}

	@Override
	public int getStartPosX() {
		// TODO Auto-generated method stub
		return 400;
	}

	@Override
	public int getStartPosY() {
		// TODO Auto-generated method stub
		return 200;
	}
	
	

}
