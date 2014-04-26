package com.supercoolnamespace.hackgame;

import java.util.LinkedList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public abstract class World {
	protected LinkedList<SquareEntity> sq;
	protected TweenManager manager;
	protected Context context;
	
	public void removeTopSquare() {
		sq.removeFirst();
	}
	
	
	public void newSquare() {
		SquareEntity temp = new SquareEntity(context, 400, 0);
		sq.add(temp);
		Tween.to(temp, EntityTweener.POSITION_XY, 0.5f).target(400, 200)
				.repeat(5, 1.0f).start(manager)
				.setCallback(new SquareCallback(temp, this))
				.setCallbackTriggers(TweenCallback.ANY);
	}


	public void drawAllSquares(Canvas c, float delta) {
		for(SquareEntity square : sq) {
			square.draw(c);
		}
		Log.d("RAND", "sq size: "+ sq.size());
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
}
