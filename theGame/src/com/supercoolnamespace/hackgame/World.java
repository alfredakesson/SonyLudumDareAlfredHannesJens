package com.supercoolnamespace.hackgame;

import java.util.LinkedList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public abstract class World {
	protected Point displaySize;
	protected LinkedList<SquareEntity> squareList;
	protected TweenManager manager;
	protected Context context;
	
	public void removeTopSquare() {
		squareList.removeFirst();
	}
	
	public abstract int getStartPosX();
	public abstract int getStartPosY();
	
	
	public void newSquare() {
		SquareEntity temp = new SquareEntity(context, getStartPosX(), 0);
		squareList.add(temp);
		Tween.to(temp, EntityTweener.POSITION_XY, 0.5f).target(getStartPosX(), getStartPosY())
				.repeat(5, 1.0f).start(manager)
				.setCallback(new SquareCallback(temp, this))
				.setCallbackTriggers(TweenCallback.ANY);
	}


	public void drawAllSquares(Canvas c, float delta) {
		for(SquareEntity square : squareList) {
			square.draw(c);
		}
		Log.d("RAND", "sq size: "+ squareList.size());
		manager.update(delta);
		
	}
	
	private void shakeASquare(Canvas c, float delta, SquareEntity sqEntity) {

		Random rand = new Random();
		int rotation = rand.nextInt(10);
		if (rotation > 5)
			rotation *= -1;
		sqEntity.setRotation(rotation);

		int pos = EntityTweener.POSITION_XY;

		sqEntity.setRotation(-rotation);

	}

	public void handleTouch(float x, float y) {
		for(SquareEntity sq : squareList) {
			if(sq.isPressed(new Point((int)x, (int)y))) {
				Log.d("world", "Is pressed!");
			}
		}
		
	}
}
