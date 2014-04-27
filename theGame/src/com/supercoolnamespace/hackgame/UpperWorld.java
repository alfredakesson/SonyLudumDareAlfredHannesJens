package com.supercoolnamespace.hackgame;

import java.util.LinkedList;

import android.content.Context;
import android.graphics.Point;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class UpperWorld extends World{

	public UpperWorld(Context context, Point displaySize){
		this.displaySize = displaySize;
		squareList = new LinkedList<SquareEntity>();
		Tween.registerAccessor(Entity.class, new EntityTweener());
		this.context = context;
		manager = new TweenManager();
		newSquare();
		sclass = new ScoreClass(context);
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
