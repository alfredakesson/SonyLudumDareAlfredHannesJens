package com.supercoolnamespace.hackgame;

import java.util.LinkedList;

import android.content.Context;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class UpperWorld extends World{
	
	public UpperWorld(Context context){
		sq = new LinkedList<SquareEntity>();
		Tween.registerAccessor(Entity.class, new EntityTweener());
		this.context = context;
		manager = new TweenManager();
		newSquare();
	}

}
