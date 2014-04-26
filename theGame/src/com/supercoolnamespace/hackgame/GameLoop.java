package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class GameLoop {
	
	private TweenManager manager;
	private SquareEntity square;
	
	public GameLoop(Context context){
		
		Tween.registerAccessor(Entity.class, new EntityTweener());
		Tween.registerAccessor(SquareEntity.class, new EntityTweener());
		manager = new TweenManager();
		
		square = new SquareEntity(context, 0, 0);
		Tween.to(square, EntityTweener.POSITION_XY, 4f).target(100,200).start(manager);
		
	}
	
	public void draw(Canvas c, float delta){
		square.draw(c);
		manager.update(0.01f);
	}

}
