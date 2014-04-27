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
	public static final int UpperWorld = 0;
	public static final int LowerWorld = 1;
	protected Point displaySize;
	protected LinkedList<SquareEntity> squareList;
	protected TweenManager manager;
	protected Context context;
	protected Random rand;
	protected SharedResurces share;
	public Offset drawOffset;

	public void removeTopSquare() {
		squareList.removeFirst();
	}
	
	public abstract int getStartPosX();
	public abstract int getStartPosY();
	
	public World(SharedResurces share, Offset theDrawOffset){
		this.share = share;
		drawOffset = theDrawOffset;
		
	}
	
	
	
	public void newSquare() {
		
		int color = getColorForSquare();
		
		SquareEntity temp = new SquareEntity(context, getStartPosX(), 0, color);
		squareList.add(temp);
		Tween.to(temp, EntityTweener.POSITION_XY, 0.5f).target(getStartPosX(), getStartPosY())
				.repeat(5, 0.5f).start(manager)
				.setCallback(new SquareCallback(temp, this))
				.setCallbackTriggers(TweenCallback.ANY);
	}

	protected int getColorForSquare() {
		int color = share.getColor();
		if(color == -1)
			color = rand.nextInt(1000)%2;
		else
			Log.d("TAG", "color is: " + color);
		
		return color;
	}


	public void drawAllSquares(Canvas c, float delta) {
		for(SquareEntity square : squareList) {
			square.draw(c, drawOffset);
		}
		Log.d("RAND", "sq size: "+ squareList.size());
		manager.update(delta);
		
	}
//	
//	private void shakeASquare(Canvas c, float delta, SquareEntity sqEntity) {
//
//		Random rand = new Random();
//		int rotation = rand.nextInt(10);
//		if (rotation > 5)
//			rotation *= -1;
//		sqEntity.setRotation(rotation);
//
//		int pos = EntityTweener.POSITION_XY;
//
//		sqEntity.setRotation(-rotation);
//
//	}

	public void handleTouch(float x, float y) {
		for(SquareEntity sq : squareList) {
			if(sq.isPressed(new Point((int)x, (int)y), drawOffset)) {
				share.addSquare(sq.getColor());
				Log.d("world", "Is pressed!");
				sq.hide();
				break;
				
			}
		}
		
	}
}
