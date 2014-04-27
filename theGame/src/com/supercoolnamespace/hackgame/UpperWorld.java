package com.supercoolnamespace.hackgame;

import java.util.LinkedList;
import java.util.Random;

import android.content.Context;
import android.graphics.Point;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class UpperWorld extends World{

	public UpperWorld(Context context, Point displaySize,SharedResurces share, Offset theDrawOffset){
		super(share, theDrawOffset);
			
		this.displaySize = displaySize;
		rand = new Random();
		squareList = new LinkedList<SquareEntity>();
		Tween.registerAccessor(Entity.class, new EntityTweener());
		this.context = context;
		manager = new TweenManager();
		newSquare();
	}

	@Override
	public int getStartPosX() {
		return 600;
	}

	@Override
	public int getStartPosY() {
		return 200;
	}

}
