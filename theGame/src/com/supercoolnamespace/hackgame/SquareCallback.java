package com.supercoolnamespace.hackgame;

import android.util.Log;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;

public class SquareCallback implements TweenCallback {
	
	SquareEntity se;
	private World world;
	short iter = 0;

	public SquareCallback(SquareEntity se, World world) {
		super();
		this.se = se;
		this.world = world;
	}

	@Override
	public void onEvent(int arg0, BaseTween<?> arg1) {
		if(arg0 == 1){
					
		}
		if(arg0 == 2){
			iter++;
			if( iter > 1)
				se.update(200f);
			if(iter == 2){
				world.newSquare();
				Log.d("Alfred", "Här kommer man ibland");
			}
			
		}
		if(arg0 == 8){
			se.hide();
			world.removeTopSquare();
		}
	}

}
