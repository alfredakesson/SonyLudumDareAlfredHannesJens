package com.supercoolnamespace.hackgame;

import java.util.LinkedList;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class LowerWorld extends World{

	public LowerWorld(Context context, Point displaySize){
		this.displaySize = displaySize;
		Log.d("HOJ", "dispSize y : " + displaySize.y);
		squareList = new LinkedList<SquareEntity>();
		Tween.registerAccessor(Entity.class, new EntityTweener());
		this.context = context;
		manager = new TweenManager();
		newSquare();
		sclass = new ScoreClass(context);
	}

	@Override
	public int getStartPosX() {
		// TODO Auto-generated method stub
		return 400;
	}

	@Override
	public int getStartPosY() {
		// TODO Auto-generated method stub
		return displaySize.y - 200;
	}
	
	
	public void newSquare() {
		SquareEntity temp = new BackSquare(context, getStartPosX(), 0, displaySize.y*0.8f );
		squareList.add(temp);
		Tween.to(temp, EntityTweener.POSITION_XY, 0.5f).target(getStartPosX(), 200)
				.repeat(5, 1f).start(manager)
				.setCallback(new SquareCallback(temp, this))
				.setCallbackTriggers(TweenCallback.ANY);
	}
	

}
